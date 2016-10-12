package edu.test_2;

public class Tester {

	public static void main(String[] args) {

				FavoriteContacts2 friends = new FavoriteContacts2();
				
				friends.addLast("Katherine","555-555-5555");
				friends.addFirst("Mighty Joe", "555-111-1111");
				friends.addFirst("Superman", "1");
				friends.add("Pizza Man", "555-222-2222", 2);
				
				System.out.println("My first contact is " + friends.getFirst()); //getFirst() is the same as getContact(1)
				System.out.println("Expected: Superman\n");
				
				System.out.println("My third contact is " + friends.getContact(3));
				System.out.println("Expected: Mighty Joe\n");
				
				System.out.println("\nDisplaying all contacts...");
				friends.displayAll();
				System.out.println("Expected: \nName: Superman \nNumber: 1 \n\nName: Pizza Man \nNumber: 555-222-2222 \n\nName: Mighty Joe \nNumber: 555-111-1111 \n\nName: Katherine \nNumber: 555-555-5555");
				
				System.out.println("\nNow, I will attempt to access a non-existent contact.");		
				friends.getContact(5);		
}
}