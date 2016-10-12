package edu.test_1;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class testerino {

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<String>();
		names.add("Mary");
		names.add("Mike");
		ListIterator<String> iter = names.listIterator();
		iter.next();
		iter.next();
		System.out.print(iter.hasNext() + " " + iter.hasPrevious());
	}

}
