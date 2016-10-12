/**
 * This program simulates a simple cellphone that is capable of making calls to both a phonenumber or a stored contact.
 * keeps a phonebook of stored contacts with their name, cell phone number, home phone number, email, and/or any notes.
 * keep a log of phonecalls to track the numbers and contacts called or recieved in a day, including the phone number, 
 * name of contact, date, time, type, and frequency of calls during the day.
 * 
 * @author Alexander Berthon, Matthew Quevas, Jonathan Galaviz, Katherine Varela
 * @version 1.0
 */
package edu.project_2;

//TODO: test all project requirements && make a tester class for presentation.
//Notes: printLog(name) and printLog(number) must be called after print(); 

import java.util.ArrayList;
import java.util.Calendar;

public class CellPhone {

	private ArrayList<Log> history = new ArrayList<Log>();
	private ArrayList<Log> repeatedLogs = new ArrayList<Log>();
	public PhoneBook phoneBook = new PhoneBook();

	/**
	 * Default constructor
	 */
	public CellPhone() {
	}

	/**
	 * this method simulates a phonecall to a user defined phonenumber and logs
	 * the call
	 *
	 * @param phoneNumber
	 *            The phone number you want to call, type long
	 */
	public void call(long phoneNumber) {
		boolean repeated = false;
		for (int i = 0; i < history.size(); i++) {
			if (history.get(i).getPhoneNumber() == phoneNumber) {
				history.get(i).addFrequency();
				String type = "Outgoing";
				String time = getTime();
				String date = getDate();
				Log call = new Log(phoneNumber, date, time, type, 1);
				repeatedLogs.add(call);
				repeated = true;
			}
		}

		if (!repeated) {
			String type = "Outgoing";
			String time = getTime();
			String date = getDate();
			Log call = new Log(phoneNumber, date, time, type, 1);
			history.add(call);
			repeatedLogs.add(call);
		}
	}

	/**
	 * this method simulates a phonecall to a contact in the phonebook, if they
	 * exist, and stores the call
	 *
	 * @param contact
	 *            the contact that will be called, type string.
	 */
	public void call(String contact) {
		boolean repeated = false;
		for (int i = 0; i < history.size(); i++) {
			if (history.get(i).getName() == contact) {
				history.get(i).addFrequency();
				String type = "Outgoing";
				String time = getTime();
				String date = getDate();
				Log call = new Log(contact, date, time, type, 1);
				repeatedLogs.add(call);
				repeated = true;
			}
		}
		if (phoneBook.find(contact) && !repeated) {
			String type = "Outgoing";
			String time = getTime();
			String date = getDate();
			Log call = new Log(contact, date, time, type, 1);
			history.add(call);
			repeatedLogs.add(call);
		} else if (!phoneBook.find(contact)) {
			if (history.size()<2) {
				System.out.println("The phonebook is empty");
				System.out.println("");
			}
			else{
			System.out.println("Contact: " + contact + " was not found");
			System.out.println("");
			}
		}
	}

	/**
	 * This method will simulate a call to the most recently searched contact,
	 * and stores the call in the log.
	 */
	public void callCurrentContact() {
		String contact = phoneBook.lastContact();
		if (contact.length() > 1) {
			call(contact);
		} else
			System.out.println("Error: invalid name");
	}

	/**
	 * This is an overloaded method. With no parameters, this method will print
	 * all of the phone call logs for the day.
	 */
	public void printLog() {
		System.out.println("		All call History:");
		System.out.println("");
		for (int i = 0; i < history.size(); i++) {
			Log currentLog = history.get(i);
			if (currentLog.getFrequency() > 1) {
				currentLog.editName(currentLog.getName() + " (" + currentLog.getFrequency() + ")");
			}
			history.get(i).print();
			System.out.println("");
		}
	}

	/**
	 * If the log contains more than one phone call from a specific phone
	 * number, it will be condensed to one log when printed via printLog()
	 * method. To access more information about each call specifically, this
	 * method must be called on the specified number.
	 * 
	 * @param phoneNumber
	 *            the phone number to be acessed, type long.
	 */
	public void printLog(long phoneNumber) {
		boolean found = false;
		for (int i = 0; i < history.size(); i++) {
			String enteredPhoneNumber = "";
			enteredPhoneNumber += phoneNumber;
			String logPhoneNumber = "";
			logPhoneNumber += history.get(i).getPhoneNumber();
			if (logPhoneNumber.contains(enteredPhoneNumber)) {
				found = true;
			}
		}
		for (int i = 0; i < repeatedLogs.size(); i++) {
			if (repeatedLogs.get(i).getPhoneNumber() == phoneNumber) {
				found = true;
			}
		}

		if (found) {
			// display all logs with this phoneNumber
			System.out.println("Details:");
			System.out.println("");
			for (int i = 0; i < repeatedLogs.size(); i++) {
				if (repeatedLogs.get(i).getPhoneNumber() == phoneNumber && repeatedLogs.get(i).getFrequency() <= 2) {
					repeatedLogs.get(i).printDetails();
					System.out.println("");
				} else if (repeatedLogs.get(i).getPhoneNumber() == phoneNumber
						&& repeatedLogs.get(i).getFrequency() >= 2) {
					repeatedLogs.get(i).printDetails();
					System.out.println("");
				}
			}
		} else
			System.out.println("There are no logs for this phone number");
	}

	/**
	 *
	 * If the log contains more than one phone call from a specific contact it
	 * will be condensed to one log when printed via printLog() method. To
	 * access more information about each call specifically, this method must be
	 * called on the specified contact.
	 * 
	 * @param contact
	 *            the contact to be acessed, type string.
	 */
	public void printLog(String contact) {
		boolean found = false;
		for (int i = 0; i < history.size(); i++) {
			if (history.get(i).getName().equals(contact)) {
				found = true;
			}
		}
		for (int i = 0; i < repeatedLogs.size(); i++) {
			if (repeatedLogs.get(i).getName().equals(contact)) {
				found = true;
			}
		}
		if (found) {
			// display all logs for this contact
			System.out.println("              "+contact);
			for (int i = 0; i < history.size(); i++) {
				if (history.get(i).getName().contains(contact)) {
					history.get(i).printDetails();
					System.out.println("");
				}
			}

			for (int i = 0; i < repeatedLogs.size(); i++) {
				if (repeatedLogs.get(i).getName().equals(contact)) {
					repeatedLogs.get(i).printDetails();
					System.out.println("");
				}
			}

		} else
			System.out.println("There are no logs for this contact");
	}

	/**
	 * This method is used to get the time that a phonecall took place
	 * 
	 * @return the time a call took place, type String.
	 */
	public String getTime() {
		Calendar someEvent = Calendar.getInstance();

		String time = "";
		String amPm = " ";
		int hour = someEvent.get(Calendar.HOUR);
		int minute = someEvent.get(Calendar.MINUTE);

		if (someEvent.get(Calendar.AM_PM) == 0) {
			amPm = "AM";
		} else {
			amPm = "PM";
		}

		// Formatting time
		if (minute < 10) {
			time += hour + ":" + "0" + minute + " " + amPm;
		} else {
			time += hour + ":" + minute + " " + amPm;
		}
		return time;
	}

	/**
	 * this method is used to get the date a phone call took place
	 * 
	 * @return the date, type string.
	 */
	public String getDate() {
		String date = "";
		Calendar someEvent = Calendar.getInstance();

		int month = someEvent.get(Calendar.MONTH) + 1; // January is Calendar
		int day = someEvent.get(Calendar.DAY_OF_MONTH);
		int year = someEvent.get(Calendar.YEAR);

		// Formatting date
		if (month < 10 && day < 10) {
			date += year + "/0" + month + "/0" + day;
		} else if (month < 10) {
			date += year + "/0" + month + "/" + day;
		} else if (day < 10) {
			date += year + "/" + month + "/0" + day;
		} else {
			date += year + "/" + month + "/" + day;
		}
		return date;
	}

	/**
	 * This method simulates a call to the user
	 * 
	 * @param contact
	 *            the contact name of the caller, type String
	 */
	public void receiveCall(String contact) {
		boolean repeated = false;
		for (int i = 0; i < history.size(); i++) {
			if (history.get(i).getName() == contact) {
				history.get(i).addFrequency();
				String type = "Incoming";
				String time = getTime();
				String date = getDate();
				Log call = new Log(contact, date, time, type, 1);
				repeatedLogs.add(call);
				repeated = true;
			}
		}
		if (phoneBook.find(contact) && !repeated) {
			String type = "Incoming";
			String time = getTime();
			String date = getDate();
			Log call = new Log(contact, date, time, type, 1);
			history.add(call);
			repeatedLogs.add(call);
		} else if (!phoneBook.find(contact)) {
			System.out.println("Contact: " + contact + " was not found");
		}
	}

	/**
	 * This method simulates a call to the user
	 * 
	 * @param phoneNumber
	 *            the incoming phone number, type long
	 */
	public void receiveCall(long phoneNumber) {
		boolean repeated = false;
		for (int i = 0; i < history.size(); i++) {
			if (history.get(i).getPhoneNumber() == phoneNumber) {
				history.get(i).addFrequency();
				String type = "Incoming";
				String time = getTime();
				String date = getDate();
				Log call = new Log(phoneNumber, date, time, type, 1);
				repeatedLogs.add(call);
				repeated = true;
			}
		}

		if (!repeated) {
			String type = "Incoming";
			String time = getTime();
			String date = getDate();
			Log call = new Log(phoneNumber, date, time, type, 1);
			history.add(call);
			repeatedLogs.add(call);
		}
	}

}