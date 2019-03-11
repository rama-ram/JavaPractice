package com.practice.dataStructures.retake;

class BinaryTree {
	Node root;

	BinaryTree(int data) {

		if (root == null) {
			root = new Node(data);
			return;
		}
		addNode(data);
	}

	void addNode(int data) {
		Node temp = root;
		while (temp != null) {
			if (temp.value < data)
				if (temp.right == null) {
					temp.right = new Node(data);
					return;
				} else
					temp = temp.right;
			else if (temp.left == null) {
				temp.left = new Node(data);
				return;
			} else
				temp = temp.left;
		}

	}

	void inOrderNode() {
		if (root == null) {
			System.out.println("Sorry Tree is empty!");
			return;
		}
		root.inOrder(root);
	}

	void preOrderNode() {
		if (root == null) {
			System.out.println("Sorry Tree is empty!");
			return;
		}
		root.preOrder(root);
	}

	void postOrderNode() {
		if (root == null) {
			System.out.println("Sorry Tree is empty!");
			return;
		}
		root.postOrder(root);
	}
}

class Node {
	int value;
	Node right, left;

	Node(int data) {

		this.value = data;
	}

	void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.value + "\t");
		inOrder(node.right);
	}

	void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.value + "\t");
		inOrder(node.left);
		inOrder(node.right);
	}

	void postOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		inOrder(node.right);
		System.out.print(node.value + "\t");
	}
}

public class BinaryTreeretake {

	public static void main(String[] args) {
		BinaryTree BT = new BinaryTree(10);
		BT.addNode(18);
		BT.addNode(20);
		BT.addNode(16);
		BT.addNode(5);
		BT.addNode(7);
		BT.addNode(6);
		BT.addNode(3);
		BT.addNode(1);
		System.out.println("IN order is:\n");
		BT.inOrderNode();
		System.out.println("\n pre order is:\n");
		BT.preOrderNode();
		System.out.println("\n post order is:\n");
		BT.postOrderNode();
	}

}
