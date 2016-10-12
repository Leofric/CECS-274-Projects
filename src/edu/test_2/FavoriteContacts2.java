package edu.test_2;

import java.util.NoSuchElementException;

/**
 * This program keeps a Double linked list of favorite contacts.
 * 
 * @author Alexander Berthon
 */
public class FavoriteContacts2 {
	private int size = 0;
	private Node first;
	private Node last;

	/**
	 * default constructor;
	 */
	public FavoriteContacts2() {
		first = null;
		last = null;
	}

	/**
	 * This method returns the name of the first contact in the list.
	 * 
	 * @return The name of the contact, type String.
	 */
	public Object getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.name;
	}

	/**
	 * This method adds a contact to the front of the list.
	 * 
	 * @param newName
	 *            the name of the contact, type String.
	 * @param newNum
	 *            the phone number of the contact, type String.
	 */
	public void addFirst(String name, String phoneNum) {
		Node newNode = new Node(name, phoneNum);
		if (first == null && last == null) {
			first = newNode;
			last = newNode;
		} else if (first == null) {
			newNode.next = first;
			first = newNode;
		} else {
			newNode.next = first;
			first = newNode;
			newNode.next.previous = newNode;
		}
		size++;
	}

	/**
	 * This method adds a contact to the end of the list.
	 * 
	 * @param newName
	 *            the name of the contact, type String.
	 * @param newNum
	 *            the phone number of the contact, type String.
	 */
	public void addLast(String name, String phoneNumber) {
		Node newNode = new Node(name, phoneNumber);
		if (last == null && first == null) {
			last = newNode;
			first = newNode;
		} else if (last == null) {
			last = newNode;
		} else {
			newNode.previous = last;
			last = newNode;
		}
		size++;
	}

	/**
	 * This method adds a contact to a user defined location in the list, if the
	 * location exists.
	 * 
	 * @param newName
	 *            the name of the contact, type String.
	 * @param newNum
	 *            the phone number of the contact, type String.
	 * @param index
	 *            the index at which the contact will be added, type Int.
	 */
	public void add(String newName, String newNum, int index) {
		Node newNode = new Node(newName, newNum);
		if (getNode(first, index) == null) {
			throw new IndexOutOfBoundsException();
		} else {
			newNode.previous = getNode(first, index - 1);
			newNode.next = getNode(first, index);
			newNode.previous.next = newNode;
			size++;
		}
	}

	/**
	 * This method returns the name of a contact at the specified location in
	 * the list, if it exists.
	 * 
	 * @param i
	 *            The location of the contact, type Int.
	 * @return The name of the contact, type String.
	 */
	public String getContact(int i) {
		if (getNode(first, i) == null) {
			throw new IndexOutOfBoundsException("There are only "+size+" elements in the list");
		} else
			return getNode(first, i).name;
	}

	/**
	 * This method prints all contacts currently stored in the list.
	 */
	public void displayAll() {
		for (int i = 0; i < size; i++) {
			System.out.println("Name: " + getNode(first, i+1).name);
			System.out.println("Name: " + getNode(first, i+1).phoneNumber);
			System.out.println();
		}
	}

	/**
	 * This is a private helper method that checks the ith term in the list,
	 * returns it if it exists.
	 * 
	 * @param start
	 *            The node to start with, type Node.
	 * @param dist
	 *            The distance from the start, type Int.
	 * @return The node at the given distance, type Node.
	 */
	private Node getNode(Node start, int dist) {
		if (dist == 1) {
			return start;
		} else {
			return getNode(start.next, dist - 1);
		}
	}

	/**
	 * This class stores the name and phone number of a contact, used in the
	 * favorite contacts class.
	 * 
	 * @author alexberthon
	 *
	 */
	public class Node {
		private String name;
		private String phoneNumber;
		private Node next;
		private Node previous;

		/**
		 * Default constructor.
		 */
		public Node() {
			name = null;
			phoneNumber = null;
			next = null;
			previous = null;
		}

		/**
		 * Overloaded contructor, constructs a contact node with the input name
		 * and number.
		 * 
		 * @param name
		 *            The name of the contact, type String.
		 * @param phoneNumber
		 *            The phone number of the contact, type String.
		 */
		public Node(String name, String phoneNumber) {
			this.name = name;
			this.phoneNumber = phoneNumber;
			next = null;
			previous = null;
		}
	}
}
