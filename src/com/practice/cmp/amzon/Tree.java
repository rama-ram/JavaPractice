package com.practice.cmp.amzon;

//ind the sum of all nodes in a binary tree which was divided vertically 
//find max depth of a tree
public class Tree {
	Node root;

	void addNode(int value) {

		if (root == null) {
			root = new Node(value);
			System.out.println("added head node" + root.data);
			return;
		}
		add(value);
	}

	void findMinDepth() {

		System.out.println(minDepth(root));
	}

	void findMaxDepth() {

		System.out.println(maxDepth(root));
	}

	void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);

	}

	void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	void add(int value) {
		Node temp = root;
		while (temp != null) {
			if (value < temp.data) {
				if (temp.left == null) {
					temp.left = new Node(value);
					System.out.println("added node" + value + "to the left of " + temp.data);
					return;
				}
				temp = temp.left;

			}
			if (value > temp.data) {
				if (temp.right == null) {
					temp.right = new Node(value);
					System.out.println("added node" + value + "to the right of " + temp.data);
					return;
				}
				temp = temp.right;
			}
		}
	}

	void inorder() {
		inorderTraverse(root);
	}

	void inorderTraverse(Node node) {
		if (node == null)
			return;
		inorderTraverse(node.left);
		System.out.print(node.data + " ");
		inorderTraverse(node.right);
	}

	int minDepth(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		if (node.left == null)
			return minDepth(node.right) + 1;
		if (node.right == null)
			return minDepth(node.left) + 1;

		return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
	}

	int maxDepth(Node node) {
		if (node == null)
			return 0;
		int lh = maxDepth(node.left);
		int rh = maxDepth(node.right);
		if (lh > rh)
			return lh + 1;
		return rh + 1;
	}

	public class Node {
		int data;
		Node left;
		Node right;

		Node(int value) {
			data = value;

		}
	}

	// Given sides of a triangle write a function which could say it is
	// equilateral , isosceles or scalene. Give Test data for the solution you
	// give
	// 2.Write a program to find Max Depth of a BST. Give test data for the same
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.addNode(50);
		tree.addNode(20);
		tree.addNode(10);
		tree.addNode(30);
		tree.addNode(40);
		tree.addNode(60);
		tree.addNode(55);
		tree.addNode(70);
		tree.addNode(80);
		tree.addNode(5);
		tree.addNode(1);
		// System.out.println("in order ..");
		// tree.inorder();
		System.out.println("min depth..");
		tree.findMinDepth();
		System.out.println("max depth..");
		tree.findMaxDepth();
		// System.out.println("max depth ..");
		// tree.findMaxDepth();

	}

}
