package edu.homework_5;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Exercise2 {

	public static void main(String[] args) {
		boolean run = true;
		Scanner in = new Scanner(System.in);
		System.out.println("What type of list would you like to create? S - String, I - Integer, D - doubled");
		String type = in.next();
		if (type.equals("S")) {
			LinkedList<String> UsersList = new LinkedList<String>();
			System.out.println("You selected String, please enter the elements you wish to store. type END to finish");
			while (in.hasNext() && run) {
				String currentInput = in.next();
				if (currentInput.equals("END")) {
					run = false;
				} else
					UsersList.add(currentInput);
			}
			ReverseStr(UsersList);
		} else if (type.equals("I")) {
			LinkedList<Integer> UsersList = new LinkedList<Integer>();
			System.out.println("You selected Integer, please enter the elements you wish to store. type END to finish");
			while (in.hasNext() && run) {
				String currentInput = in.next();
				if (currentInput.equals("END")) {
					run = false;
				} else
					UsersList.add(Integer.parseInt(currentInput));
			}
			ReverseInt(UsersList);

		} else if (type.equals("D")) {
			LinkedList<Double> UsersList = new LinkedList<Double>();
			System.out.println("You selected Double, please enter the elements you wish to store. type END to finish");
			while (in.hasNext() && run) {
				String currentInput = in.next();
				if (currentInput.equals("END")) {
					run = false;
				} else
					UsersList.add(Double.parseDouble(currentInput));
			}
			ReverseDbl(UsersList);
		} else
			System.out.println("Invalid selection " + type);
		in.close();
	}

	public static void ReverseInt(LinkedList<Integer> UsersList) {
		Stack<Integer> reverse = new Stack<Integer>();
		while (!UsersList.isEmpty()) {
			reverse.push(UsersList.getFirst());
			UsersList.removeFirst();
		}
		System.out.println("Your list in reverse order is ");
		while (!reverse.isEmpty()) {
			System.out.print(reverse.pop()+" ");
		}
	}

	public static void ReverseStr(LinkedList<String> UsersList) {
		Stack<String> reverse = new Stack<String>();
		while (!UsersList.isEmpty()) {
			reverse.push(UsersList.getFirst());
			UsersList.removeFirst();
		}
		System.out.println("Your list in reverse order is ");
		while (!reverse.isEmpty()) {
			System.out.print(reverse.pop()+" ");
		}
	}

	public static void ReverseDbl(LinkedList<Double> UsersList) {
		Stack<Double> reverse = new Stack<Double>();
		while (!UsersList.isEmpty()) {
			reverse.push(UsersList.getFirst());
			UsersList.removeFirst();
		}
		System.out.println("Your list in reverse order is ");
		while (!reverse.isEmpty()) {
			System.out.print(reverse.pop()+" ");
		}
	}
}
