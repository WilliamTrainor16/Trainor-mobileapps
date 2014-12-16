public class Contact {

// Fields 
	private String lastname; 
	private String firstname; 
	private String email; 
	private String cellphone; 
	private String address; 
	
// Constructor 
public Contact(String first, String last){ 
	firstname = first; 
	lastname = last; 
	
} // end constructor
	
	
// Methods 
	public String getName(){ 
		return firstname.concat(lastname);
	} // end getName 
	
	public String getEmail(){ 
		return email;
	} // end getEmail 
	
	public String getCell(){ 
		return cellphone;
	} // end getCell 
	
	public String getAddress(){ 
		return address;
	} // end getAddress 
	
	public void setEmail(String e){ 
		email = e;
	} // end setEmail 
	
	public void setCell(String c){ 
		cellphone = c;
	} // end setCell 
	
	public void setAddress(String a){ 
		address = a;
	} // end setAddress 
	
	public void setName(String last, String first){ 
		
	} // end setName
	
} // end of Contact Class