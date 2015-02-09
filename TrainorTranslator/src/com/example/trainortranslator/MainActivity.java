package com.example.trainortranslator;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText; 
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

public class MainActivity extends Activity implements OnInitListener {

	// Define the dictionary field for Translations 
	private EnglishToSpanish dictionary; 
	
	// Fields for UI 
	private EditText editEnglish; 
	private EditText editTranslate; 
	private Button buttonTranslateWord; 
	private Button buttonAddWord; 
	private Button buttonPhrase; 
	private Button buttonSpeak; 
	private Button buttonClear; 
	private TextToSpeech speaker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		// Initialize the dictionary 
		dictionary = new EnglishToSpanish(); 
		
		// Bind to XML objects 
		editEnglish = (EditText)findViewById(R.id.editEnglish); 
		editTranslate = (EditText)findViewById(R.id.editTranslate); 
		buttonTranslateWord = (Button)findViewById(R.id.buttonTranslateWord); 
		buttonPhrase = (Button)findViewById(R.id.buttonPhrase); 
		buttonSpeak = (Button)findViewById(R.id.buttonSpeak); 
		buttonClear = (Button)findViewById(R.id.buttonClear); 
		speaker = new TextToSpeech(this, this);
	} // end onCreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	// Returns a List of words parsed from a string 
	public List<String> getParsed(String s) { 
		// establish a blank List to return 
		List <String> words = new ArrayList<String>(0); 
		// transfer content of s to phrase 
		String phrase = s; 
		// Convert phrase to lower case 
		phrase.toLowerCase(); 
		// Define current word 
		String currentWord = ""; // blank  
		// Create an array of char objects from string 
		char[] charList = phrase.toCharArray(); 
		
		// For loop to search characters and pull out words 
		for (int i = 0; i < charList.length; i++) { 
		// Is the char a not a space 
		if (!String.valueOf(charList[i]).equals(" ")) { 
			currentWord += String.valueOf(charList[i]); // add letter
		} // end if 
		else { 
		words.add(currentWord); // put currentWord in List
		currentWord = ""; // Blank out currentWord
		} // end else
		} // end for loop
		
		// Check for word at end 
		if (currentWord.length() > 0) { 
			words.add(currentWord);
		} // end if
		
		return words;
	} // end getParsed
	
	// Translates a string of words and returns a string with translation 
	public String translate(String s) { 
		String result = ""; 
		
		// Define a Blank List 
		List<String> words = getParsed(s); 
		// Define a List of available translations
		List<String []> bank = dictionary.getDictionary();
		
		// For the Words in the List words  
		for (int i = 0; i < words.size(); i++) { 
		// Search for the match in the bank List
		for (int w = 0; w < bank.size(); w++) { 
		if (words.get(i).equals(bank.get(w)[0] )) { 
		result += bank.get(w)[1]; // add translated word to result 
		result += " "; // add a space
		} // end if
		} // end for loop bank
		} // end for loop words
		
		return result;
	} // end translate
	
	// Functions for Button Clicks 
	
	//Translate single word (or phrase) 
	public void buttonTranslateWordClicked(View V) { 
		String eWord = editEnglish.getText().toString(); 
		String spanishWord = translate(eWord); 
		editTranslate.setText(spanishWord);
	} // end buttonTranslateWordClicked
	
	public void buttonPhraseClicked(View v) { 
		String english = editEnglish.getText().toString(); 
		String spanish = translate(english);  
		editTranslate.setText(spanish);
	} // end buttonPhraseClicked 
	
	public void buttonAddWordClicked(View v) { 
	String english = editEnglish.getText().toString(); 
	String spanish = editTranslate.getText().toString(); 
	dictionary.addEntry(english, spanish); 
	editEnglish.setText(""); 
	editTranslate.setText(""); 
	editEnglish.requestFocus();
	} // end buttonAddWordClicked 
	
	public void buttonClearClicked(View v) { 
		editEnglish.setText(""); 
		editTranslate.setText("");
	} // end buttonClearClicked 
	
	public void buttonSpeakClicked(View v) { 
		String english = editEnglish.getText().toString(); 
		String spanish = translate(english); 
		editTranslate.setText(spanish); 
		speaker.speak(spanish, 1, null);
	} // end buttonSpeakClicked
	
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

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
	} 
} // end MainActivity Class
