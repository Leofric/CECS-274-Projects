package edu.project_1;

import java.util.ArrayList;

public class PhoneBook {
	private String i = "I"; // fixes a problem i think?
	private ArrayList<Contact> contactList = new ArrayList<Contact>();
	public static final String NAME = "1";
	public static final String PH_NUM = "2";
	public static final String CELL = "3";
	public static final String EMAIL = "4";
	public static final String NOTES = "5";

	/**
	 * Constructor that takes in all information to create initial contact for
	 * the phonebook object. calls method from contact class to create a contact
	 * object, then stores that object in an array list within the phonebook
	 * object
	 * 
	 * @param name
	 *            takes in the name of the contact, type String
	 * @param phoneNumber
	 *            takes in the phone number of the contact, type long
	 * @param cellPhoneNumber
	 *            takes in the cell phone number of the contact, type long
	 * @param email
	 *            takes in the email of the contact, type String
	 * @param notes
	 *            takes in any notes you wish to add to the contact, type String
	 */
	public PhoneBook(String name, long phoneNumber, long cellPhoneNumber, String email, String notes) {
		Contact contact1 = new Contact(name, phoneNumber, cellPhoneNumber, email, notes);
		contactList.add(contact1);
	}

	/**
	 * Constructor that takes in a name, email, and notes for the initial
	 * contact for the phonebook object. calls method from contact class to
	 * create a contact object, then stores that object in an array list within
	 * the phonebook object
	 * 
	 * @param name
	 *            takes in the name of the contact, type String
	 * @param email
	 *            takes in the email of the contact, type String
	 * @param notes
	 *            takes in any notes you wish to add to the contact, type String
	 */
	public PhoneBook(String name, String email, String notes) {
		Contact contact1 = new Contact(name, email, notes);
		contactList.add(contact1);
	}

	/**
	 * Constructor that takes in a name and phone number for the initial contact
	 * for the phonebook object. calls method from contact class to create a
	 * contact object, then stores that object in an array list within the
	 * phonebook object
	 * 
	 * @param name
	 *            takes in the name of the contact, type String
	 * @param phoneNumber
	 *            takes in the phone number of the contact, type long
	 */
	public PhoneBook(String name, long phoneNumber) {
		Contact contact1 = new Contact(name, phoneNumber);
		contactList.add(contact1);

	}

	/**
	 * Constructor that takes in a name for the initial contact for the
	 * phonebook object. calls method from contact class to create a contact
	 * object, then stores that object in an array list within the phonebook
	 * object
	 * 
	 * @param name
	 *            takes in the name of the contact, type String
	 */
	public PhoneBook(String name) {
		Contact contact1 = new Contact(name);
		contactList.add(contact1);
	}

	/**
	 * Constructor that takes in a name and email for the initial contact for
	 * the phonebook object. calls method from contact class to create a contact
	 * object, then stores that object in an array list within the phonebook
	 * object
	 * 
	 * @param name
	 *            takes in the name of the contact, type String
	 * @param email
	 *            takes in the email of the contact, type String
	 */
	public PhoneBook(String name, String email) {
		Contact contact1 = new Contact(name, email);
		contactList.add(contact1);
	}

	/**
	 * method that displays a specific contact
	 * 
	 * @param name
	 *            the name of the contact you wish to display, type String
	 */
	public void display(String name) {
		for (int i = 0; i < contactList.size(); i++) {
			Contact searchedContact = contactList.get(i);
			if (searchedContact.getName().equals(name)) {
				searchedContact.print();
			}
		}
		System.out.println("*****************************************");
	}

	/**
	 * method that displays all contacts that are stored in the phonebook
	 */
	public void displayAll() {
		for (int i = 0; i < contactList.size(); i++) {
			contactList.get(i).print();
			System.out.println("*****************************************");
		}
	}

	/**
	 * adds a contact to the phonebook by name and phone number
	 * 
	 * @param name
	 *            takes in the name of the contact, type String
	 * @param phoneNumber
	 *            takes in the phone number of the contact, type long
	 */
	public void addContact(String name, long phoneNumber) {
		i = i + "I";
		Contact i = new Contact(name, phoneNumber);
		contactList.add(i);
	}

	/**
	 * adds a contact to the phonebook by name
	 * 
	 * @param name
	 *            takes in the name of the contact, type String
	 */
	public void addContact(String name) {
		i = i + "I";
		Contact i = new Contact(name);
		contactList.add(i);
	}

	/**
	 * adds a contact to the phonebook by name and email
	 * 
	 * @param name
	 *            takes in the name of the contact, type String
	 * @param email
	 *            takes in the email of the contact, type String
	 */
	public void addContact(String name, String email) {
		i = i + "I";
		Contact i = new Contact(name, email);
		contactList.add(i);
	}

	/**
	 * adds a contact to the phonebook by name, phone number, cellphone number,
	 * email, and a note
	 * 
	 * @param name
	 *            takes in the name of the contact, type String
	 * @param phoneNumber
	 *            takes in the phone number of the contact, type long
	 * @param cellPhoneNumber
	 *            takes in the cell phone number of the contact, type long
	 * @param email
	 *            takes in the email of the contact, type String
	 * @param note
	 *            takes in any notes you wish to add to the contact, type String
	 */
	public void addContact(String name, long phoneNumber, long cellPhoneNumber, String email, String note) {
		i = i + "I";
		Contact i = new Contact(name, phoneNumber, cellPhoneNumber, email, note);
		contactList.add(i);
	}

	/**
	 * Method that edits an existing contact.
	 * 
	 * @param name
	 *            takes in the name of the contact that you wish to edit, type
	 *            String
	 * @param type
	 *            takes in the type of data that you want to change, i.e. NAME,
	 *            PH_NUM, NOTES, CELL, EMAIL
	 * @param newValue
	 *            takes in the new data to replace the current data, type String
	 */
	public void editContact(String name, String type, String newValue) {
		for (int i = 0; i < contactList.size(); i++) {
			Contact searchedContact = contactList.get(i);
			if (searchedContact.getName().equals(name) && type == NAME) {
				searchedContact.edit("NAME", newValue);
			} else if (searchedContact.getName().equals(name) && type == PH_NUM) {
				searchedContact.edit("PH_NUM", newValue);
			} else if (searchedContact.getName().equals(name) && type == NOTES) {
				searchedContact.edit("NOTES", newValue);
			} else if (searchedContact.getName().equals(name) && type == CELL) {
				searchedContact.edit("CELL", newValue);
			} else if (searchedContact.getName().equals(name) && type == EMAIL) {
				searchedContact.edit("EMAIL", newValue);
			}
		}
	}
}