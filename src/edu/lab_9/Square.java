package edu.lab_9;

public class Square {
	private int length = 0;

	public Square(int length) {
		this.length = length;
	}

	public void printSquare() {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print("[]");
			}
			System.out.println();
		}
		System.out.println();
	}

	public int getArea() {
		if (length == 1) {return 1;}
		Square smallerSquare = new Square(length - 1);
		int smallerArea = smallerSquare.getArea();
		return smallerArea+length+length-1;
	}
}