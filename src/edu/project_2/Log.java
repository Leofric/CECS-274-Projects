/**
 * This program is used to store the data from a phone call within an object
 * called Log. The time, date, phone number or contact name, type, and frequency
 * of the call are stored. This program is essential in the use of the cellPhone
 * class.
 * 
 * @author alexberthon
 * @version 1.0
 */
package edu.project_2;

public class Log {
	private long phoneNumber;
	private String name;
	private String time;
	private String date;
	private String type;
	private int frequency;

	/**
	 * Constructor log for a phone call
	 * 
	 * @param phoneNumber
	 *            the phone number called
	 * @param date
	 *            the date of the call
	 * @param time
	 *            the time of the call
	 * @param type
	 *            the type of call it is, incoming or outgoing
	 * @param frequency
	 *            the number of times this number has been called or recieved in
	 *            the same day.
	 */
	public Log(long phoneNumber, String date, String time, String type, int frequency) {
		this.phoneNumber = phoneNumber;
		this.time = time;
		this.date = date;
		this.type = type;
		this.frequency = frequency;
	}

	/**
	 * constructor Log for a contact call
	 * 
	 * @param name
	 *            the name of the contact
	 * @param date
	 *            the date the call took place
	 * @param time
	 *            the time of the call
	 * @param type
	 *            the type of call it is, incoming or outgoing
	 * @param frequency
	 *            the number of times this contact has been called/recieved in
	 *            the same day
	 */
	public Log(String name, String date, String time, String type, int frequency) {
		this.name = name;
		this.time = time;
		this.date = date;
		this.type = type;
		this.frequency = frequency;
	}

	/**
	 * This method is used to print the data stored within the log.
	 */
	public void print() {
		if (this.phoneNumber > 0) {
			String phoneNumber = "";
			phoneNumber += this.phoneNumber;
			phoneNumber="("+phoneNumber.substring(0, 3)+")"+phoneNumber.substring(3, 6)+"-"+phoneNumber.substring(6, 10);
			if (this.frequency > 1) {
				phoneNumber += " (" + this.frequency + ")";
				System.out.println(phoneNumber);
			} else {
				String output = "";
				output+=phoneNumber+" "+this.type+" "+this.date+" "+this.time;
				System.out.println(output);
			}
		} else {
			if (this.frequency < 2) {
				String output = this.name+" "+this.type+" "+this.date+" "+this.time;
				System.out.println(output);
			}
			else{
				System.out.println(this.name);
			}
		}
	}
	/**
	 * This method is used to print a log when it is repeated, ignores frequency.
	 */
	public void printDetails(){
		if (this.phoneNumber > 0){			
			String output = this.type+" "+this.date+" "+this.time;
			System.out.println(output);

		}
		else{
			String output = "";
			output += this.type+" "+this.date+" "+this.time;
			System.out.println(output);
		}		
	}

	/**
	 * This method is used to access the name of a contact in a logged call.
	 * 
	 * @return the name of the contact, type String.
	 */
	public String getName() {
		String returnedName = "No name in this log";
		if (this.name != null) {
			returnedName = this.name;
		}
		return returnedName;
	}

	/**
	 * This method is used to format the name of a contact in order to compact
	 * the logs for multiple calls to the same contact
	 * 
	 * @param name
	 *            the name of the contact to be edited, type String.
	 */
	public void editName(String name) {
		this.name = name;
	}

	/**
	 * This method increments the frequency of a call.
	 */
	public void addFrequency() {
		this.frequency++;
	}

	/**
	 * This method returns the frequency of a log, ie if the same person was
	 * called multiple times in a day
	 * 
	 * @return the frequency of a log, type int.
	 */
	public int getFrequency() {
		return this.frequency;
	}

	/**
	 * This method returns the phone number in a log
	 *
	 * @return returns the phone number, type long.
	 */
	public long getPhoneNumber() {
		return this.phoneNumber;
	}
}
