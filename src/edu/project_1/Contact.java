/**
 * This class is used by the Phonebook class, creates a contact object that
 * stores user input. the objects of this class are then stored in the phonebook
 * object. See phonebook class for more info
 * 
 * @author Alexander Berthon
 * @version 1.0
 */
package edu.project_1;
public class Contact {
	private String name;
	private long phoneNumber;
	private long cellPhoneNumber;
	private String emailAdress;
	private String notes;

	public Contact() {
	}
	
	/**
	 * Creates a contact object with that stores the contacts name, phone
	 * number, cell phone number, email adress, and any notes.
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
	public Contact(String name, long phoneNumber, long cellPhoneNumber, String emailAdress, String notes) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.cellPhoneNumber = cellPhoneNumber;
		this.emailAdress = emailAdress;
		this.notes = notes;
	}

	/**
	 * Creates a contact object with that stores the contacts name and phone
	 * number
	 * 
	 * @param name
	 *            takes in the name of the contact, type String
	 * @param phoneNumber
	 *            takes in the cell phone number of the contact, type long
	 */
	public Contact(String name, long phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Creates a contact object with that stores the contacts name and email
	 * adress
	 * 
	 * @param name
	 *            takes in the name of the contact, type String
	 * @param emailAdress
	 *            takes in the email of the contact, type String
	 */
	public Contact(String name, String emailAdress) {
		this.name = name;
		this.emailAdress = emailAdress;
	}

	/**
	 * Creates a contact object with that stores the contacts name
	 * 
	 * @param name
	 */
	public Contact(String name) {
		this.name = name;
	}

	/**
	 * Creates a contact object with that stores the contacts name, email, and
	 * notes
	 * 
	 * @param name
	 *            takes in the name of the contact, type String
	 * @param email
	 *            takes in the email of the contact, type String
	 * @param notes
	 *            takes in any notes you wish to add to the contact, type String
	 */
	public Contact(String name, String email, String notes) {
		this.name = name;
		this.emailAdress = email;
		this.notes = notes;
	}

	/**
	 * this method returns the name of a contact object, used in phone book
	 * methods
	 * 
	 * @return returns contact name, type String
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * This method prints all the data stored in a contact object
	 */
	public void print() {
		System.out.println("Name:			" + this.name);
		if (this.phoneNumber > 100000000) {
			String output = "(";
			output += this.phoneNumber;
			output = output.substring(0, 4) + ")" + output.substring(4, 7) + "-" + output.substring(7, 11);
			System.out.println("Phone Number:		" + output);
		} else if (this.phoneNumber > 100000) {
			String output = "";
			output += this.phoneNumber;
			output = output.substring(0, 3) + "-" + output.substring(3, 7);
			System.out.println("Phone Number:		" + output);
		} else if (this.phoneNumber > 0) {
			String output = "";
			output += this.phoneNumber;
			System.out.println("Phone Number:		" + output);
		}
		if (this.cellPhoneNumber > 100000000) {
			String output = "(";
			output += this.cellPhoneNumber;
			output = output.substring(0, 4) + ")" + output.substring(4, 7) + "-" + output.substring(7, 11);
			System.out.println("Cell Phone Number:	" + output);
		} else if (this.cellPhoneNumber > 100000) {
			String output = "";
			output += this.cellPhoneNumber;
			output = output.substring(0, 3) + "-" + output.substring(3, 7);
			System.out.println("Cell Phone Number:		" + output);
		} else if (this.cellPhoneNumber > 0) {
			String output = "";
			output += this.cellPhoneNumber;
			System.out.println("Cell Phone Number:		" + output);
		}
		if (this.emailAdress != null) {
			System.out.println("Email:			" + this.emailAdress);
		}
		if (this.notes != null) {
			System.out.println("Notes:			" + this.notes);
		}
	}

	/**
	 * This method is used to edit the contact objects
	 * 
	 * @param type
	 *            takes in the type of data to be edited, type String
	 * @param newInput
	 *            takes in the new data to replace the current data stored, type
	 *            String
	 */
	public void edit(String type, String newInput) {
		if (type == "NAME")
			this.name = newInput;
		else if (type == "NOTES")
			this.notes = newInput;
		else if (type == "EMAIL")
			this.emailAdress = newInput;
		else if (type == "PH_NUM") {
			long newValue = Long.valueOf(newInput).longValue();
			this.phoneNumber = newValue;
		} else if (type == "CELL") {
			long newValue = Long.valueOf(newInput).longValue();
			this.cellPhoneNumber = newValue;
		}
	}
}