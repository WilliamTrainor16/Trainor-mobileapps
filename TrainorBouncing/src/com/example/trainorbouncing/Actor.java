package com.example.trainorbouncing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;

public class Actor {

	// Fields 
private Point p; // Position 
private int c; // Color
private int s; // Size 
private int dx; // change in x speed
private int dy; // change in y speed
private Paint paint; // Paint object  

// Integers for width and height 
private int w; 
private int h; 

private boolean isVisable = true;

//Context
private Context aContext; 
private int costume; 
private BitmapDrawable graphic; 
	
// Constructors 
public Actor(Context context, int x, int y, int col, int size){ 
p = new Point(x, y); 
c = col; 
s = size; // assign size 
paint = new Paint(); 
paint.setColor(c);
dx = 0; 
dy = 0; 

// Set width and height to size
w = s; 
h = s;

//Set the Context 
aContext = context;

} // end constructor Actor 

// Methods  

// Getters 
public boolean getVisable() { 
return isVisable;
} // end getVisable

public int getX() { 
	return p.x;
} // end getX 

public int getY() { 
	return p.y;
} // end getY 

public int getDX() { 
	return dx;
} // end getDX

public int getDY() { 
	return dy;
} // end getDy 

public int getColor() { 
	return c;
} // end getColor  

public int getWidth() { 
	return w;
} // end getWidth 

public int getHeight() { 
	return h;
} // end getHeight


// Setters  
public void setVisable(boolean v) { 
	isVisable = v;
} // end setVisable

public void setWidth(int width) { 
 w = width;	
} // end setWidth 

public void setHeight(int height) { 
h = height;	
} // end setHeight

public void setColor(int col) { 
	c = col; 
	paint.setColor(c);
} // end setColor 

public void goTo(int x, int y) { 
	p.x = x; 
	p.y = y;
} // end goTo

public void setDX(int speed) { 
dx = speed;	
} // end setDX

public void setDY(int speed) { 
dy = speed;	
} // end setDY

public void changeDX(float a) { 
	dx += a;
} // end changeDX

public void changeDY(float a) { 
	dy += a;
} // end changeDY 

public void move() { 
	p.x = p.x + dx; 
	p.y = p.y + dy;
} // end move

public void bounce(Canvas c) { 
	
	if(p.x + 70 > c.getWidth() || p.x < 0){ 
		dx = dx * -1;
	} // end if statement 
	
	if(p.y + 70 > c.getHeight() || p.y < 0){ 
		dy = dy * -1;
	} // end if statement 
	
} // end bounce 

public void bounceOff() { 
	dx = (int)(dx * -1.1); 
	dy = (int)(dy * -1.1);
} // end bounceOff 

public void bounceUp() { 
	dy = (int) (dy * -1);
} // end bounceUp

public void bounceActor(Actor a) { 
	
	
	
} // end bounceActor
 
public void toTop(Canvas c){ 
	int bottom = c.getHeight();
	if (p.y > bottom ){  
	p.y = 0;	
	} // end if statement
} // end toTop

public void drawCircle(Canvas c) { 
c.drawCircle(p.x, p.y, s, paint);	
} // end drawCircle 

public void drawSquare(Canvas c) { 
c.drawRect(p.x, p.y, p.x+s, p.y+s, paint);	
} // end drawCircle  

public void drawRect(Canvas c) { 
if(isVisable) { 
c.drawRect(p.x, p.y, p.x +w, p.y+h, paint);	
} // end if statement
} // end drawRect

public void setCostume(int cost) { 
	costume = cost; 
	graphic = (BitmapDrawable)aContext.getResources().getDrawable(costume);
	w = graphic.getBitmap().getWidth(); 
	h = graphic.getBitmap().getHeight();
} // end setCostume 

public Bitmap getBitmap() { 
	return graphic.getBitmap();
} // end getBitmap 

public void draw(Canvas c) { 
	c.drawBitmap(getBitmap(), p.x,  p.y, paint);
} // end draw

public boolean isTouchingActor(Actor other) { 
	boolean result = false;  
	int left = p.x;
	int top = p.y; 
	int right = p.x + w; 
	int bottom = p.y + h; 
	int otherLeft = other.getX();
	int otherTop = other.getY();
	int otherRight = other.getX() + other.getWidth(); 
	int otherBottom = other.getY() + other.getHeight();
	
	if((right > otherLeft && left < otherRight) && (bottom > otherTop && top < otherBottom)){
	result = true;
} // end if statement 

	return result;
} // end isTouchingActor

} // end class Actor
