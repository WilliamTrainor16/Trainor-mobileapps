package com.example.soundsapp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	// Fields for the Image buttons and stop button 
	private ImageButton buttonDevil;
	private ImageButton buttonTroll;
	private ImageButton buttonUnicorn;
	private ImageButton buttonReaper;
	private ImageButton buttonSquirrel;
	private ImageButton buttonKnight;
	// stop button 
	private Button buttonStopSound;
	
	// MediaPlayer Array 
	private MediaPlayer soundPlayer [] = new MediaPlayer[6]; 
	
	private int soundResources [] = {R.raw.howl,  R.raw.cough, R.raw.medieval, R.raw.screech, R.raw.hey, R.raw.fairydust };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		// Bind the ImageButton Java objects to the XML Resources 
		buttonDevil = (ImageButton)findViewById(R.id.buttonDevil);
		buttonTroll = (ImageButton)findViewById(R.id.buttonTroll);		
		buttonKnight = (ImageButton)findViewById(R.id.buttonKnight);
		buttonReaper = (ImageButton)findViewById(R.id.buttonReaper);
		buttonSquirrel = (ImageButton)findViewById(R.id.buttonSquirrel);
		buttonUnicorn = (ImageButton)findViewById(R.id.buttonUnicorn); 
		buttonStopSound = (Button)findViewById(R.id.buttonStopSound);
		// Intilize MediaPlayer with resources  
		// sounds from the 'raw' folder
		soundPlayer[0] = MediaPlayer.create(this, soundResources[0]); 
		soundPlayer[1] = MediaPlayer.create(this, soundResources[1]); 
		soundPlayer[2] = MediaPlayer.create(this, soundResources[2]);
		soundPlayer[3] = MediaPlayer.create(this, soundResources[3]);		
		soundPlayer[4] = MediaPlayer.create(this, soundResources[4]);
		soundPlayer[5] = MediaPlayer.create(this, soundResources[5]);
	}

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
	// Functions to play sounds 
	
	public void handleClick(View v){ 
		switch (v.getId()){ 
		case R.id.buttonDevil:
			soundPlayer[0].start();
			break;
		case R.id.buttonTroll: 
			soundPlayer[1].start();
			break;
		case R.id.buttonKnight: 
			soundPlayer[2].start();
			break;
		case R.id.buttonReaper: 
			soundPlayer[3].start();
			break;
		case R.id.buttonUnicorn: 
			soundPlayer[4].start();
			break;
		case R.id.buttonSquirrel:
			soundPlayer[5].start();
			break;
		}
	}
	
	public void buttonDevilClick(View v){
		soundPlayer[0].start();
	} 
	public void buttonTrollClick(View v){ 
		soundPlayer[1].start();
	} 
	public void buttonKnightClick(View v){ 
		soundPlayer[2].start();
	} 
	public void buttonReaperClick(View v){ 
		soundPlayer[3].start();
	} 
	public void buttonSquirrelClick(View v){ 
		soundPlayer[4].start();
	} 
	public void buttonUnicornClick(View v){ 
		soundPlayer[5].start();
	} 
	 
	// Stop all sounds from playing 
	public void stopAllSounds(View v){ 
		// Go through all the sounds 
		for (int i = 0; i < soundPlayer.length; i++) { 
			// if sound is playing 
			if(soundPlayer[i].isPlaying()){ 
				soundPlayer[i].pause(); // pause the sound 
				soundPlayer[i].seekTo(0); // rewind to the beginning 
			} // end if
		} // end for
	} // end function stopAllSounds
}
