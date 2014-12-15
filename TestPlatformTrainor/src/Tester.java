
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    // Make two Players 
		Player rebecca = new Player("Rebecca"); 
		Player joshua = new Player("Joshua");
		
		rebecca.setEmail("rebecca17@marist.com");
		joshua.setEmail("joshua21@marist.com");
		
		System.out.println(rebecca.getName()); 
		System.out.println(joshua.getName()); 
		
		rebecca.setPosition(10); 
		joshua.setPosition(8); 
		
		System.out.println(rebecca.getName() + "'s position is: "); 
		System.out.println(joshua.getPosition());
		
		System.out.println(joshua.getName() + "'s position is: ");
		System.out.println(joshua.getPosition());
}
}