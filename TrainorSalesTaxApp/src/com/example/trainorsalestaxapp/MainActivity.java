package com.example.trainorsalestaxapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	// Fields for UI Objects 
	private EditText editSale; 
	private TextView textTax; 
	private SeekBar seekBar; 
	private TextView textPercent; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
	// Bind to XML 
		editSale = (EditText)findViewById(R.id.editSale); 
		textTax = (TextView)findViewById(R.id.textTax);
		seekBar = (SeekBar)findViewById(R.id.seekBar); 
		textPercent = (TextView)findViewById(R.id.textPercent);
		//textPercent = (Text)
		
		// Register SeekBar with a listener 
		seekBar.setMax(100); 
		seekBar.setProgress(6); 
		seekBar.setOnSeekBarChangeListener(seekBarListener);
		
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
	
	// Define the seekBar Listener 
	private OnSeekBarChangeListener seekBarListener = 
			new OnSeekBarChangeListener() {

				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					int percent = seekBar.getProgress(); 
					String percentString = String.valueOf(percent);
					textPercent.setText(percentString + "%");
					textTax.setText(getTax(percent));
					
				}

				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				} 
		
	};
	
	private String getTax(int percent) { 
		
		double bill = Double.valueOf(editSale.getText().toString() );
		double tax = bill * (Double.valueOf(percent)/100);  
		double totalBill = tax + bill;
		String taxString = "$ "+ String.valueOf(totalBill);
		return taxString;
		
	} // end getTax
	
	
}
