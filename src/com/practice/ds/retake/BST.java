package com.practice.ds.retake;

class Node {
	private Node left, right;
	private int value;

	Node(int data) {
		this.value = data;
	}

	void addNode(int data) {
		Node current = this;
		while (current != null) {
			if (data >= current.value) {
				if (current.right == null) {
					current.right = new Node(data);
					System.out.println("inserted node " + data);
					break;
				} else
					current = current.right;
			}
			if (data <= current.value) {
				if (current.left == null) {
					current.left = new Node(data);
					System.out.println("inserted node " + data);
					break;
				} else
					current = current.left;
			}
		}
	}

	void inorderTraversal(Node node) {
		if (node == null)
			return;
		inorderTraversal(node.left);
		System.out.print(node.value + "\t");
		inorderTraversal(node.right);
	}

	void preOrderTraversal(Node node) {
		if (node == null)
			return;
		System.out.print(node.value + "\t");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	void postOrderTraversal(Node node) {
		if (node == null)
			return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.value + "\t");

	}
}

public class BST {
	Node root = null;

	public void addNodes(int value) {
		if (root == null) {
			System.out.println("empty BST, inserting the root node" + value);
			root = new Node(value);
		} else
			root.addNode(value);

	}

	public void inorderTraverse() {
		root.inorderTraversal(root);
	}

	public void preOrderTraverse() {
		root.preOrderTraversal(root);
	}

	public void postOrderTraverse() {
		root.postOrderTraversal(root);
	}

	public static void main(String[] args) {
		BST bt = new BST();
		bt.addNodes(5);
		bt.addNodes(6);
		bt.addNodes(4);
		bt.addNodes(1);
		System.out.println("in order traversal");
		bt.inorderTraverse();
		System.out.println();
		System.out.println("Pre order traversal");
		bt.preOrderTraverse();
		System.out.println();
		System.out.println("Post order traversal");
		bt.postOrderTraverse();
	}

}
