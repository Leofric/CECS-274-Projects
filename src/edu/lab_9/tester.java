package edu.lab_9;

public class tester {

	public static void main(String[] args) {

		Square square_5 = new Square(7);
		System.out.println("Area: " + square_5.getArea());
		square_5.printSquare();

		Square square_25 = new Square(15);
		System.out.println("Area: " + square_25.getArea());
		square_25.printSquare();

	}

}
