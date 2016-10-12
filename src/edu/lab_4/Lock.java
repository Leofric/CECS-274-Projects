/**
 * This program is a simulated lock with digit buttons.
 * 
 * @author Alexander Berthon
 * @author Katherine Varela
 * @version 1.0
 */
package edu.lab_4;

public class Lock {
	private int combination;
	private int input;

	public Lock() {
		input = 0;
		combination = 1729;
	}

	/**
	 * Simulates a digit button push.
	 * 
	 * @param button
	 *            a digit 0 ... 9
	 */
	public void push(int button) {
		input = 10 * input + button;
	}

	/**
	 * Simulates a push of the open button.
	 * 
	 * @return true if the lock opened
	 */
	public boolean open() {
		boolean open = false;
		if (input == combination) {
			open = true;
		} else
			open = false;
		input = 0; // resets input for next attempt (if any)
		return open;
	}
}