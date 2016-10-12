package edu.homework_6;

import java.util.List;
import java.util.ArrayList;

/**
 * A tree in which each node has an arbitrary number of children.
 */
public class Tree {

	private Node root;

	class Node {
		public Object data;
		public List<Node> children;

		/**
		 * Computes the size of the subtree whose root is this node.
		 * 
		 * @return the number of nodes in the subtree
		 */
		public int size() {
			int sum = 0;
			for (Node child : children) {
				sum = sum + child.size();
			}
			return 1 + sum;
		}

		/**
		 * needed to compute the height of child node objects along the branch
		 * 
		 * @return the height of this nodes branch, type int.
		 */
		public int height() {
			int height = 0;
			for (Node child : children) {
				height = Math.max(height, child.height());
			}
			return height + 1;
		}
	}

	/**
	 * Constructs an empty tree.
	 */
	public Tree() {
		root = null;
	}

	/**
	 * Constructs a tree with one node and no children.
	 * 
	 * @param rootData
	 *            the data for the root
	 */
	public Tree(Object rootData) {
		root = new Node();
		root.data = rootData;
		root.children = new ArrayList<Node>();
	}

	/**
	 * Adds a subtree as the last child of the root.
	 */
	public void addSubtree(Tree subtree) {
		root.children.add(subtree.root);
	}

	/**
	 * Computes the size of this tree.
	 * 
	 * @return the number of nodes in the tree
	 */
	public int size() {
		if (root == null) {
			return 0;
		} else {
			return root.size();
		}
	}

	/**
	 * calculates the height of the tree.
	 * 
	 * @return the height of the tree, type int.
	 */
	public int height() {
		int answer = 0;
		if (root == null) {
			return 0;
		} else {
			answer = Math.max(answer, root.height());
		}
		return answer;
	}

	/**
	 * Calculates the maximum number of siblings in the tree.
	 * 
	 * @return the max number of siblings, type int.
	 */
	public int maxNumSiblings() {
		int answer = 0;
		if (root == null) {
			return 0;
		} else {
			int max = 0;
			for (Node child : root.children) {
				max = child.children.size();
				answer = Math.max(root.children.size(), max);
			}
		}
		return answer;
	}

	/**
	 * Calculates the total path length by adding all the different heights of
	 * the branches of the tree.
	 * 
	 * @param n
	 *            the node to start at, type node.
	 * @return the total path length, type int.
	 */
	private int height(Node n) {
		if (n == null) {
			return 0;
		} else {
			int answer = 0;
			for (int i = 0; i < n.children.size(); i++) {
				answer += 1 + height(n.children.get(i));
			}
			return answer;
		}
	}

	/**
	 * Helper method for total path length, returns the final answer.
	 * 
	 * @return the total path length, type int.
	 */
	public int totalPathLength() {
		int test = root.children.size();
		return height(root)+test;
	}
}