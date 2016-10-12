package edu.project_3;

import java.util.Random;

public class Sorter {

	public static void main(String[] args) {
		int array[] = randomIntArray(10, 100);
		StopWatch timer = new StopWatch();

		//prints the array before running the sort method
		System.out.print("Before sorting: [");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.print(array[i] + "]");
			} else {
				System.out.print(array[i] + ",");
			}
		}
		
		timer.start();
		bubbleSort(array);
		timer.stop();
		
		//prints the array after running the sort method
		System.out.print("\nAfter sorting: [");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.print(array[i] + "]");
			} else {
				System.out.print(array[i] + ",");
			}
		}
		
		System.out.println("\n\nTime elapsed: "+timer.getElapsedTime()+" Milisecond");

	}

	public static void bubbleSort(int num[]) {
		boolean done = false;
		int temp;

		while (!done) {
			done = true;
			for (int i = 0; i < num.length - 1; i++) {
				if (num[i] < num[i + 1]) {
					temp = num[i];
					num[i] = num[i + 1];
					num[i + 1] = temp;
					done = false;
				}
			}
		}
	}

	public static int[] randomIntArray(int length, int max) {
		int[] a = new int[length];
		Random generator = new Random();

		for (int i = 0; i < a.length; i++) {
			a[i] = generator.nextInt(max);
		}

		return a;
	}
}
