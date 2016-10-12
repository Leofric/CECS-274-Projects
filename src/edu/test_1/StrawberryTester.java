package edu.test_1;
public class StrawberryTester {
	
	public static void main(String[] args){
		Fruit redBerry = new Strawberry(); // Strawberry is a fruit. 
		
		//show the name 
		//show the color
		//show the harvestTime
		
		redBerry.showColor();
		redBerry.showName();
		redBerry.showHarvestTime();
		
		Fruit banana = new Fruit();
		banana.showColor();
		banana.showName();
		banana.showHarvestTime();
	}
}
