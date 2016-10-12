package edu.project_1;

public class MyTester {

	public static void main(String[] args) {
			
		PhoneBook fubcity = new PhoneBook("Katherine", 5625550000L, 5555555555L, "kapiva@ucla.edu", "My favorite prof"); 
		fubcity.display("Katherine");
		fubcity.editContact("Katherine", PhoneBook.CELL, "5625550055");	//editing Katherine Varela's cell # to (562) 555-0055

		fubcity.display("Katherine");
	}

}
