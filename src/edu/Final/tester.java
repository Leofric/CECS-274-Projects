package edu.Final;

public class tester {
	
	public static void main(String[] args){
		ContactsTree contacts = new ContactsTree("Kathy","555-555-5555");
		contacts.add("Tony", "555-555-1234");
		contacts.add("Chio", "555-555-6666");
		contacts.add("Kenia", "");
		contacts.add("Sam", "555-555-1717");
		
		System.out.println("Now displaying Kenia...\n");
		System.out.println(contacts.getContact("Kenia"));	
		contacts.editContactNum("Kenia", "555-555-1919");
	//	contacts.displayAll();
		
		System.out.println("\nRemoved Sam...\n");
	//	contacts.remove("Sam");
	//	contacts.displayAll();
		
		/*-- TEST 1: ATTEMPT TO ACCESS NON-EXISTENT CONTACT ---*/
		//contacts.getContact("Sam");
		
		/*-- TEST 2: ATTEMPT TO EDIT NON-EXISTENT CONTACT ---*/
		//contacts.editContactNum("Sam", "555");
				
		/*-- TEST 3: ATTEMPT TO REMOVE NON-EXISTENT CONTACT ---*/
		contacts.remove("Sam");		
	}
}
