package edu.test_1;
/**
 * models some properties of a fruit
 * @author Katherine Varela
 * @version 1.0
 * */
public class Fruit {
	//instance variables
	private String name;
	private String color;
	private double aveHarvestTime; 
	private String timeUnit;
	
	/**
	 * constructs a Fruit object with name being "Not Specified", color being "Not Specified", and average harvest time 0 days.
	 * */
	public Fruit(){
		name = "Not Specified";
		color = "Not Specified";
		aveHarvestTime = 0.0;
		timeUnit = "days";
	}
	
	/**
	 * constructs a Fruit object with the given properties
	 * @param name - name of the fruit, as a string
	 * @param color - color of the fruit, as a string
	 * @param aveHarvestTime - average harvest time, as a double
	 * @param timeUnit - time unit of the harvest time, as a string
	 * */
	public Fruit(String name, String color, double aveHarvestTime, String timeUnit){
		this.name = name;
		this.color = color;
		this.aveHarvestTime = aveHarvestTime;
		this.timeUnit = timeUnit;
	}
	
	
	//getters
	/**
	 * displays the name of the fruit object
	 * @return the name of the fruit, as a string
	 * */
	public String showName(){
		System.out.println("This is a " + name);
		return name;}
	
	/**
	 * displays the color of the fruit object
	 * @return the color of the fruit, as a string
	 * */
	public String showColor(){
		System.out.println("The color of this fruit is " + color);
		return color;}
	
	/**
	 * displays the harvest time of the fruit object
	 * @return the average harvest time of the fruit, as a double
	 * */
	public double showHarvestTime(){
		System.out.println("The average harvest time is " + aveHarvestTime + " " + timeUnit);
		return aveHarvestTime;}

}
