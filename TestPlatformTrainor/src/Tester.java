
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	// TODO Auto-generated method stub 
	// Code for testing goes here  
	Contact william = new Contact("William","Trainor"); 
	Contact george = new Contact("George","Burdell");
    
	william.setEmail("william@email.com"); 
	george.setEmail("george@email.com"); 
	
	william.setCell("770-643-2524"); 
	george.setCell("655-123-4567"); 
	
	william.setAddress("12955 Old Course Drive"); 
	george.setAddress("30332 North Ave NW"); 
	
	System.out.println(william.getName()); 
	System.out.println(william.getEmail());
	System.out.println(william.getCell());
	System.out.println(william.getAddress()); 
	
	System.out.println(george.getName()); 
	System.out.println(george.getEmail());
	System.out.println(george.getCell());
	System.out.println(george.getAddress());
} 
}