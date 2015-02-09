package com.example.trainorbouncing;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View {

	private int lives;
	// Create some Actors! 
	private Actor abner; 
	private Actor rebecca;   
	
	private Actor paddle; 
	private Actor ball;
	private Actor brickSquad [] = new Actor [6]; 
	
	// values to hold the Accel Data 
		private float ax = 0; 
		private float ay = 0; 
		private float az = 0;
	
	// Create the Handler for animation 
	private Handler h; 
	private int RATE = 30; // about 30 frames a second
	
	public int getLives() { 
	int life = lives;	
	return 	life;
	} // end getLives
	
	public AnimationView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		lives = 3;
		
		ball = new Actor(context, 200, 200, Color.BLUE, 25);
		ball.setDX(12); 
		ball.setDY(10); 
		
		paddle = new Actor(context, 300, 300, Color.RED, 40); 
		paddle.setWidth(150); 
		paddle.setHeight(40);
		
		Random gen; 
		gen = new Random();
		
		// Initialize the Actors 
		for (int i = 0; i < brickSquad.length; i++) {  
			brickSquad[i] = new Actor(context, i*80, 750, Color.MAGENTA, 40);  
			brickSquad[i].setWidth(75);
			} // end for loop 
		
		// Initialize the Handler 
		h = new Handler(); 
		
	} // end AnimationView

	public void onDraw(Canvas c) { 
		
		int counter = 0; 
		counter = 0;
		for (int i = 0; i < brickSquad.length; i++) { 
			brickSquad[i].setWidth((c.getWidth()/6)-3);
			int xPos = i * (c.getWidth()/6);
			brickSquad[i].goTo(xPos, 100);
			brickSquad[i].drawRect(c);  
			
			if(ball.isTouchingActor(brickSquad[i])) { 
				if(brickSquad[i].getVisable() == true) { 
				ball.bounceOff(); 
				brickSquad[i].setVisable(false);
				} // end if statement
			} // end if statement
			
			if (brickSquad[i].getVisable() == false){ 
				counter++; 
				if (counter == brickSquad.length){ 
					for(int m = 0; m < brickSquad.length; m++) { 
						brickSquad[m].setVisable(true); 
						ball.goTo(paddle.getX(), paddle.getY() - 10);
					} // end for loop
				} // end if statement
					
			} // end if statement
			
		} // end for loop 
		
		if(ball.getY() + 50 > paddle.getY() ){ 
			ball.goTo(paddle.getY() +10, paddle.getX() ); 
			lives--;
		}
		
		paddle.drawRect(c); 
		ball.drawCircle(c); 
		ball.move(); 
		ball.bounce(c); 
		if(ball.isTouchingActor(paddle)) { 
		ball.bounceUp();	
		} // end if statement

		switch(lives){ 
		case 3: 
		setBackgroundColor(Color.WHITE);
		break;
		case 2: 
		setBackgroundColor(Color.GREEN);	
		break;
		case 1: 
		setBackgroundColor(Color.YELLOW);	
		break;
		case 0: 
		setBackgroundColor(Color.RED); 
		lives = 3;
		break;
		}
		
		// call the Runnable 
		h.postDelayed(r,  RATE); 
		
	} // end onDraw 
	
	private Runnable r = new Runnable() {

		@Override
		public void run() {
			invalidate();
			
		} // end run
		
	}; // end Runnable r
	
	public boolean onTouchEvent(MotionEvent event){ 
		int action = event.getActionMasked(); 
		int actionIdex = event.getActionIndex(); 
		
		paddle.goTo((int)event.getX(), 750);
		
	return true;
	} // end onTouchEvnet 
	
	public void setAX(float x) { 
		ax = x;
	} // end setAX 
	
	public void setAY(float y) { 
		ay = y;
	} // end setAY 
	
	public void setAZ(float z) { 
		az = z;
	} // end setAZ
	
} // end class AnimationView
