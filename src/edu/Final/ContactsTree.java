package edu.Final;

public class ContactsTree {
	
	private Node root;
	
	private static class Node { 
	    Node left; 
	    Node right; 
	    String name;
	    String number;

	    Node(String name, String number) { 
	      left = null; 
	      right = null; 
	      this.name = name;
	      this.number = number;
	    }
	  }
	
	public ContactsTree(String name, String num){		
		 root= new Node(name, num);
	}
	public ContactsTree(){
		root = null;
	}
	
	/**
	 * Adds a contact to the tree/list.
	 * @param name name the name of the contact, type string. 
	 * @param num num the phone number of the contact, type int.
	 */
		public void add(String name, String num) {
			   if ( root == null ) {
			      root = new Node(name, num);
			      return;
			   }
			   Node runner;  
			   runner = root; 
			   while (true) {
			      if ( name.compareTo(runner.name) < 0 ) {  //compare alphabetically here
			        
			         if ( runner.left == null ) {
			            runner.left = new Node(name, num);
			            return;
			         }
			         else
			            runner = runner.left;
			      }
			      else {
			          
			         if ( runner.right == null ) {
			            runner.right = new Node(name, num);
			            return;
			         }
			         else
			            runner = runner.right;
			      }
			   }
			} 
		
	/**
	 * removes the contact with the given name from the list
	 * @param name name of the contact to remove, type string.
	 */
	public void remove(String name){
		
	}
	
		/**
		 * Helper method for search.
		 * @param name name of contact to print
		 * @return returns contact if it exists.
		 */
		public String getContact(String name) {
			Node found = search(name, root);
			String contact = "Name: "+found.name+"\n"+"Number: "+found.number;
			return contact;
		}
		/**
		 * searches for a node and returns it.
		 * @param name name of the node, type string.
		 * @param node node to start at, type node.
		 * @return returns the node your searching for, if it exists, type node.
		 */
			private Node search(String name, Node node){
			    if(node != null){
			        if(node.name.equals(name)){
			           return node;
			        } else {
			            Node foundNode = search(name, node.left);
			            if(foundNode == null) {
			                foundNode = search(name, node.right);
			            }
			            return foundNode;
			         }
			    } else {
			        return null;
			    }
			}
	
	/**
	 * Edits the contact's number to the newNumber, helper method
	 * @param name name of the contact to edit, type string.
	 * @param newNumber the new number to assign, type int.
	 */
	public void editContactNum(String name, String newNumber){
		edit(name, root, newNumber);
	}

	private Node edit(String name, Node node, String number){
	    if(node != null){
	        if(node.name.equals(name)){
	           node.number = number;
	           return null;
	        } else {
	            Node foundNode = edit(name, node.left, number);
	            if(foundNode == null) {
	                foundNode = edit(name, node.right, number);
	            }
	            node.number = number;
	            return null;
	         }
	    } else {
	        return null;
	    }
	}
	
	
	/**
	 * Displays the names and numbers of all contacts stored in alphabetical order.
	 */
	public void displayAll(){
		
	}
}
