package edu.homework_6;

public class TreeTester {

	public static void main(String[] args) {
		Tree t1 = new Tree("Anne");
		Tree t2 = new Tree("Peter");
		t1.addSubtree(t2);
		Tree t3 = new Tree("Zara");
		t1.addSubtree(t3);
		Tree t4 = new Tree("Kat");
		t1.addSubtree(t4);


		System.out.println("Max number of siblings: " + t1.maxNumSiblings());
		System.out.println("Expected: 3\n");
		System.out.println("Total path length: " + t1.totalPathLength());
		System.out.println("Expected: 6\n");
	}
}
