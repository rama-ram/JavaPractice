package com.practice.cmp.ntnx;

import java.util.Stack;

public class TopViewOfTree {
	// 1
	// / \
	// 2 3
	// / \ / \
	// 4 5 6 7
	// Top view of the above binary tree is
	// 4 2 1 3 7
	private static Node root;

	TopViewOfTree(int value) {
		root = new Node(value);
	}

	void add(int data) {
		if (root == null) {
			root = new Node(data);
			System.out.println("added root node " + root.value);
			return;
		} else {
			Node current = root;
			root.addNode(current, data);

		}
	}

	Node getNode() {
		return root;
	}

	void inorder() {
		root.inOrderT(root);
	}

	void topView() {
		root.topLeftView(root);
		root.topRightView(root.right);
	}

	static class Node {
		Node(int value) {
			this.value = value;
		}

		Node left, right;

		int value;

		void topLeftView(Node node) {

			if (node == null)
				return;
			if (node.left != null) {
				topLeftView(node.left);
			}
			System.out.print(node.value + "  ");
		}

		void topRightView(Node node) {

			if (node == null)
				return;
			if (node.right != null) {
				System.out.print(node.value + "  ");
				topLeftView(node.right);
			}

		}

		void inOrderT(Node node) {

			if (node == null) {
				return;
			}
			inOrderT(node.left);
			System.out.print(node.value + "  ");
			inOrderT(node.right);
		}

		void addNode(Node node, int data) {
			while (node != null) {
				if (node.value > data) {
					// move left
					if (node.left == null) {
						node.left = new Node(data);
						System.out.println("added node " + data + " to left of " + node.value);
						return;
					}
					node = node.left;
				} else if (node.value < data) {
					// move right
					if (node.right == null) {
						node.right = new Node(data);
						System.out.println("added node " + data + " to right of " + node.value);
						return;
					}
					node = node.right;
				}
			}

		}
	}

	// Input: Array {1, 2, 3}
	// Output: A Balanced BST
	// 2
	// /
	// 1 3
	//
	// Input: Array {1, 2, 3, 4}
	// Output: A Balanced BST
	// 3
	// /
	// 2 4
	// /
	// 1
	void arrToTree(int[] arr) {

		int mid = arr.length / 2;

		root = new Node(arr[mid]);
		a2BTLeft(arr, root, 0, mid - 1);
		a2BTRight(arr, root, mid + 1, arr.length - 1);
	}

	void a2BTLeft(int[] arr, Node node, int start, int end) {
		if (start > end) {
			return;
		}
		if (start == end) {
			node.left = new Node(arr[start]);
			return;
		}
		int mid = end - start / 2;

		node.left = new Node(arr[mid]);
		end = mid - 1;
		node = node.left;

		a2BTLeft(arr, node, start, end);
	}

	void a2BTRight(int[] arr, Node node, int start, int end) {
		if (start > end) {
			return;
		}
		if (start == end) {
			node.right = new Node(arr[start]);
			return;
		}
		int mid = (start + end) / 2;

		node.right = new Node(arr[mid]);
		start = mid + 1;
		node = node.right;

		a2BTRight(arr, node, start, end);
	}

	void printSpiralTree(Node node) {

		if (node == null)
			return;
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		s1.push(node);
		while (!s1.isEmpty() || !s2.isEmpty()) {

			while (!s1.isEmpty()) {
				Node temp = s1.pop();
				System.out.print(temp.value + " ");
				if (temp.right != null) {
					s2.push(temp.right);
				}
				if (temp.left != null) {
					s2.push(temp.left);
				}
			}
			while (!s2.isEmpty()) {
				Node temp = s2.pop();
				System.out.print(temp.value + "  ");
				if (temp.left != null) {
					s1.push(temp.left);
				}
				if (temp.right != null) {
					s1.push(temp.right);
				}
			}
		}

	}

	public static void main(String[] args) {
		TopViewOfTree tree = new TopViewOfTree(4);
		tree.add(2);
		tree.add(3);
		tree.add(1);
		tree.add(5);
		tree.add(6);
		System.out.println("Following are nodes in top view of Binary Tree");
		// // tree.topView();
		// int[] arr = { 1, 2, 3 };
		// tree.arrToTree(arr);
		// tree.inorder();
		// System.out.println();
		// int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
		// tree.arrToTree(arr1);
		// tree.inorder();
		tree.printSpiralTree(tree.getNode());
	}

}
