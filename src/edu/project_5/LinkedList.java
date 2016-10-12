package edu.project_5;

import java.util.NoSuchElementException;

public class LinkedList {
	private Node first;
	private Node last;

	public LinkedList() {
		first = null;
		last = null;
	}

	public Object getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	public void addFirst(Object element) {
		Node newNode = new Node();
		newNode.data = element;
		if (first == null && last == null) {
			first = newNode;
			last = newNode;
		} else if (first == null) {
			newNode.next = first;
			first = newNode;
		} else {
			newNode.next = first;
			first = newNode;
			newNode.next.previous = newNode;
		}
	}

	public Object removeFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		Object element = first.data;
		first = first.next;
		return element;
	}

	public Object getLast() {
		if (last == null) {
			throw new NoSuchElementException();
		}
		return last.data;
	}

	public void addLast(Object element) {
		Node newNode = new Node();
		newNode.data = element;
		if (last == null && first == null) {
			last = newNode;
			first = newNode;
		} else if (last == null){
			last = newNode;
		}
		else{
			newNode.previous = last;
			last = newNode;
		}
	}

	public Object removeLast() {
		if (last == null) {
			throw new NoSuchElementException();
		}
		Object element = last.data;
		last = last.previous;
		return element;
	}

	public ListIterator listIterator() {
		return new LinkedListIterator();
	}

	class LinkedListIterator implements ListIterator {
		private Node position;
		private Node previous;

		public LinkedListIterator() {
			position = null;
			previous = null;
			isAfterNext = false;
		}

		private boolean isAfterNext;

		public boolean hasNext() {
			if (position == null) {
				return first != null;
			} else {
				return position.next != null;
			}
		}

		public Object next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			previous = position;
			isAfterNext = true;

			if (position == null) {
				position = first;
			} else {
				position = position.next;
			}
			return position.data;
		}

		public boolean hasPrevious() {
			if (position == null) {
				return last != null;
			} else {
				return position.previous != null;
			}
		}

		public Object previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			previous = position;
			isAfterNext = true;

			if (position == null) {
				position = last;
			} else {
				position = position.previous;
			}
			return previous.data;
		}

		public Object remove() {
			Object removed;
			if (!isAfterNext) {
				throw new IllegalStateException();
			}
			if (position == first) {
				removed = first.data;
				removeFirst();
			} else if (position == last) {
				removed = last.data;
				removeLast();
			} else {
				removed = position.data;
				previous.next = position.next;
			}
			position = previous;
			isAfterNext = false;
			return removed;
		}

		public void add(Object element) {
			if (position == null) {
				addFirst(element);
				position = first;
			} else {
				Node newNode = new Node();
				newNode.data = element;
				newNode.next = position.next;
				newNode.previous = position;
				position.next = newNode;
				position.previous = position;
				position = newNode;
			}
			isAfterNext = false;
		}

		public void set(Object element) {
			if (!isAfterNext) {
				throw new IllegalStateException();
			}
			position.data = element;
		}
	}

	class Node {
		public Object data;
		public Node next;
		public Node previous;
	}
}
