package edu.project_5;

public class DLQueue {
	private LinkedList list = new LinkedList();

	public DLQueue() {
		
	}

	public void add(Object data) {
		list.addFirst(data);
	}

	public Object remove() {
		return list.removeLast();
	}

	public Object peek() {
		return list.getLast();
	}
}