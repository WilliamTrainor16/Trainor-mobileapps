package com.example.trainortranslator;

import java.util.ArrayList;
import java.util.List;

public class EnglishToSpanish {

// Field to hold String Arrays	
private List<String []>	dictionaryS;
	
// Initialize dictionary List 
public EnglishToSpanish() { 
	
// Initialize dictionary List 
dictionaryS = new ArrayList<String []>(0);
	
// Add some words to the dictionary 
addEntry("this","esta");
addEntry("dog","perro"); 
addEntry("is","es");
addEntry("a","un");
addEntry("father","padre");
addEntry("mother","madre");
addEntry("kitchen","cocina");
addEntry("in","en");
addEntry("the","el");
addEntry("with","con");

} // end Constructor

// Adds words to the dictionary List
public void addEntry(String e, String s){ 
	String entry[] = {e, s}; 
	dictionaryS.add(entry);
} // end addEntry
 
// Returns the dictionary object
public List <String []> getDictionary() { 
	return dictionaryS;
} // end getDictionary


} // end EnglishToSpanish Class
