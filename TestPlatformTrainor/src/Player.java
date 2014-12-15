
public class Player {
// Fields 
	private String name; 
	private int position; 
	private String email;
	
	// Constructor 
	public Player (String n){
		name = n; // Sets name 
		position = 0; // Makes Position = 0
	} 
	
	// Methods for our Player 
	public String getName() { 
		return name;
	} // end getName
	
	public int getPosition() { 
		return position;
	} // end getPosition
	
	public void setEmail(String em){
	email = em; 
	} // end setEmail 
	
	public String getEmail() { 
		return email;
	} // end getEmail
	
	public void getPosition(int p) { 
		position = p;
	} // end getPosition
	
	public void setPosition(int p){
	position = p;
	} // end setPosition 
	
} // end Player class
