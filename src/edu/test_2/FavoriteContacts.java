package edu.test_2;

import java.util.LinkedList;

/**
 * 
 * @author Alexander Berthon
 *
 */
public class FavoriteContacts {

	private LinkedList<Node> contacts = new LinkedList<Node>();

	/**
	 * This method adds a contact to the front of the list.
	 * 
	 * @param newName the name of the contact, type String.
	 * @param newNum the phone number of the contact, type String.
	 */
	public void addFirst(String newName, String newNum) {
		Node contact = new Node(newName, newNum);
		contacts.addFirst(contact);
	}

/**
 * This method adds a contact to the end of the list.	
 * 
 * @param newName the name of the contact, type String.
 * @param newNum the phone number of the contact, type String.
 */
	public void addLast(String newName, String newNum) {
		Node contact = new Node(newName, newNum);
		contacts.addLast(contact);
	}

	/**
	 * This method adds a contact to a user defined location in the list, if the location exists.
	 * 
	 * @param newName the name of the contact, type String.
	 * @param newNum the phone number of the contact, type String.
	 * @param index the index at which the contact will be added, type Int.
	 */
	public void add(String newName, String newNum, int index) {
		Node contact = new Node(newName, newNum);
		if (contacts.size() - 1 < index-1) {
			System.out.println("there are only " + contacts.size() + " number of elements in the list");
			throw new IndexOutOfBoundsException();
		} else {
			contacts.add(index-1, contact);
		}
	}

	/**
	 * This method returns the name of the first contact in the list.
	 * 
	 * @return The name of the contact, type String.
	 */
	public String getFirst() {
		if (contacts.isEmpty()) {
			System.out.println("error, no contacts found");
		}
		return contacts.get(0).name;
	}

	/**
	 * This method returns the name of a contact at the specified location in the list, if it exists.
	 * 
	 * @param i The location of the contact, type Int.
	 * @return The name of the contact, type String.
	 */
	public String getContact(int i) {
		if (contacts.size() < i) {
			throw new IndexOutOfBoundsException("the list only contains " + contacts.size() + " elements");
		} else
			return contacts.get(i-1).name;
	}

	/**
	 * This method prints all contacts currently stored in the list.
	 */
	public void displayAll() {
		if (contacts.isEmpty()) {
			System.out.println("List is empty");
		} else {
			for (int i = 0; i < contacts.size(); i++) {
				System.out.println("Name: "+contacts.get(i).name);
				System.out.println("Phone Number: "+contacts.get(i).phoneNumber);
				System.out.println();
			}
		}
	}
/**
 * This is a private helper method that checks the ith term in the list, returns it if it exists.
 * 
 * @param start The node to start with, type Node.
 * @param dist The distance from the start, type Int.
 * @return The node at the given distance, type Node.
 */
	private Node getNode(Node start, int dist) {
		return null;
	}

	/**
	 * This class stores the name and phone number of a contact, used in the favorite contacts class.
	 * @author alexberthon
	 *
	 */
	public class Node {
		private String name;
		private String phoneNumber;

		/**
		 * Default constructor.
		 */
		public Node() {
			name = null;
			phoneNumber = null;
		}

		/**
		 * Overloaded contructor, constructs a contact node with the input name and number.
		 * @param name The name of the contact, type String.
		 * @param phoneNumber The phone number of the contact, type String.
		 */
		public Node(String name, String phoneNumber) {
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
	}
}
