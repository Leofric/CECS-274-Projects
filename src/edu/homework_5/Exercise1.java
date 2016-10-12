package edu.homework_5;

import java.util.Scanner;
import java.util.Stack;

public class Exercise1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter an expression with {[()]}");
		String input = in.next();
		checker(input);
		in.close();
	}

	public static void checker(String input) {
		Stack<Character> balance = new Stack<Character>();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(') {
				balance.push(input.charAt(i));
			} else if (input.charAt(i) == '}') {
				if (balance.peek() == '{') {
					balance.pop();
				} else
					System.out.println("Not balanced. Mismatched " + balance.peek() + " with " + input.charAt(i)
							+ "at index " + i);
			} else if (input.charAt(i) == ']') {
				if (balance.peek() == '[') {
					balance.pop();
				} else
					System.out.println("Not balanced. Mismatched " + balance.peek() + " with " + input.charAt(i)
							+ "at index " + i);
			} else if (input.charAt(i) == ')') {
				if (balance.peek() == '(') {
					balance.pop();
				} else
					System.out.println("Not balanced. Mismatched " + balance.peek() + " with " + input.charAt(i)
							+ "at index " + i);
			}
			// System.out.println(balance);
		}
		if (balance.isEmpty()) {
			System.out.println("Balanced");
		} else if (balance.size() == 1)
			System.out.println("Not balanced. Missing last closing parentheses to match "+balance.peek());
	}
}
