package com.example.countdown;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
// Fields 
	private TextView textTimer; 
	private Button buttonReset; 
	private Button buttonPause;
	private Button buttonStart; 
	private boolean isRunning;
	
	// h / r 
	private int elapsedTime; // hold the time that has passed
	
	private Handler h; // The Handler 
	
	private int RATE = 1000; // Milliseconds- how fast
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		// Bind to the XML 
		textTimer = (TextView)findViewById(R.id.textTimer); 
		buttonReset = (Button)findViewById(R.id.buttonReset); 
		buttonPause = (Button)findViewById(R.id.buttonPause); 
		buttonStart = (Button)findViewById(R.id.buttonStart);
		
		// initialize the counters 
		elapsedTime = 60; 
		h = new Handler(); 
		count();
	} // end onCreate
	
	public void reset(View v) { 
		elapsedTime = 60;
	} // end reset

	public void start(View v) { 
		isRunning = true;
	} // end reset
	 
	public void pause(View v) { 
		isRunning = false;
	} // end reset
	
	public void count() {
		if (elapsedTime == 0){ 
			isRunning = false;
		} // end if statement
		if (isRunning == true){
		elapsedTime--;   
		} // end if statement 
		textTimer.setText(String.valueOf(elapsedTime)); 
		h.postDelayed(r, RATE);
	} // end count

	// define runnable - calls the count() function 
	private Runnable r = new Runnable() {

		@Override
		public void run() {
			count(); // call back to count function
			
		} 
		
	}; // end Runnable R
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
