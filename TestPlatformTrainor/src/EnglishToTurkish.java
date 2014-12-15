import java.util.ArrayList;
import java.util.List;


public class EnglishToTurkish {
	// Field for List to String Arrays 
		private List<String []> dictionary; 
		
		public EnglishToTurkish() {
			dictionary = new ArrayList<String []>(0);
			
			// Add words to the dictionary 
			addEntry("hello","merhaba"); 
			addEntry("bye","gule gule");
			addEntry("pilot","pilot");
			addEntry("principal","muduru");
			addEntry("lion","aslan");
			addEntry("donkey","esek");
			addEntry("peach","seftali"); 
			addEntry("apple","elma");
			
		} // end of EnglishToTurkish command
		// Adds words to the dictionary list 
		public void addEntry(String e, String s){
			String entry [] = {e, s}; 
			dictionary.add(entry);
		}
		// translate function
		public String translate(String s){
			String result = ""; // Blank word 
			
			// Search for translation 
			for (int w = 0; w < dictionary.size(); w++){
				if (s.equals(dictionary.get(w)[0])){
					result = dictionary.get(w)[1]; // get match
				}
			}
			if (result.equals("")){
				result = s; //set to incoming word
			}
			return result; // Give back to the program
		}
} // end EnglishToTurkish Class
