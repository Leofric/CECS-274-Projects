package edu.project_5;

public class TestQ {

	public static void main(String[] args) {
		
				DLQueue myQueue = new DLQueue();
				myQueue.add("This");
				myQueue.add("is");
				myQueue.add("my");
				myQueue.add("Queue");
				
				System.out.println(myQueue.peek());	System.out.println("Expected: This");
				myQueue.remove();
				System.out.println("\n" + myQueue.remove());	System.out.println("Expected: is");

				System.out.println("\n" + myQueue.remove());	System.out.println("Expected: my");
				
				System.out.println("\n" + myQueue.remove());	System.out.println("Expected: Queue");
				
				System.out.println("\n" + myQueue.remove());	// <<---------- THROWS NoSuchElementException 
		}
	}
