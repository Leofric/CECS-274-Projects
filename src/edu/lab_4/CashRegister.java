/**
 * This program acts as a simple cash register. It can add items, get the total cost of all items added
 * calculate change due, return items, and return the amount of items in a transaction.
 * 
 * @author Alexander Berthon
 * @version 1.0
 * @date 1-28-16
 */
package edu.lab_4;
import java.util.ArrayList;

public class CashRegister {
	
	private ArrayList<Double> prices = new ArrayList<Double>();
	private int count;
	private double total;
	private double change; 
/**
 * Default Constructor, if no items to be returned, a new sale is started.
 */
	public CashRegister(){
		count = 0;
		total = 0;
		change = 0;
	}
	/**
	 * Overloaded Constructor, if there are items to be returned, it is added
	 * to the change owed.
	 * @param changeOwed, the price of the item being returned, double.
	 */
	public CashRegister(double changeOwed){
		change = changeOwed;
		count = 0;
		total = 0;
	}
	/**
	 * Adds an items price to the register
	 * @param price the price of the item, double.
	 */
	public void addItem(double price) {
		prices.add(price);
		count++;
	}
/**
 * Returns the number of items in a given transaction
 * @return returns the #of items in the transaction, int.
 */
	public double getCount() {
		return count;
	}
/**
 * Returns the total cost of the transaction, calculates store credit/returned items here 
 * so that customers who return an item and wish to purchase something else
 * are not double tax'ed
 * 
 * Must be executed before finishing the transaction, i.e. getting the change due.
 * @return returns the total cost, double.
 */
	public double getTotal() {
		for (int i = 0; i<prices.size(); i++) {
			total = total + prices.get(i);
		}
		total -= change;
		total = total*1.09;
		return total;
	}
	/**
	 * Calculates the change due from the transaction.
	 * @param payment The amount used to pay for the transaction. Double.
	 * @return Returns the amount of change that is due, double.
	 */
	public double getChangeDue(double payment){
		change = payment-total;
		return change;
	}
}