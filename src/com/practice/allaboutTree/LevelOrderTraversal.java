package com.practice.allaboutTree;

import java.util.Stack;

class Node {
	int value;
	Node left, right;

	public Node(int data) {
		value = data;

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

	void levelOrder(Node node) {

		if (node == null) {
			return;
		}
		int height = getTreeHeight(node);
		System.out.println("nHeight of the tree is : " + height);
		for (int i = 1; i <= height; i++)
			printLevel(node, i);
	}

	void spiralLevel(Node node) {

		if (node == null) {
			return;
		}
		int height = getTreeHeight(node);
		System.out.println("nHeight of the tree is : " + height);
		boolean l = false;
		for (int i = 1; i <= height; i++) {
			printSpiralLevelM1(node, i, l);
			l = !l;
		}
	}

	int getTreeHeight(Node node) {
		if (node == null)
			return 0;
		int lh = getTreeHeight(node.left);
		int rh = getTreeHeight(node.right);
		if (lh > rh)
			return lh + 1;
		else
			return rh + 1;

	}

	void printLevel(Node node, int level) {
		if (level == 0 || node == null)
			return;
		if (level == 1) {
			System.out.print(node.value + "  ");
		}
		if (level > 1) {
			printLevel(node.left, level - 1);
			printLevel(node.right, level - 1);
		}
	}

	void printSpiralLevelM1(Node node, int level, boolean l) {
		if (level == 0 || node == null)
			return;
		if (level == 1) {
			System.out.print(node.value + "  ");
		}

		if (level > 1) {
			if (l != false) {
				printSpiralLevelM1(node.left, level - 1, l);
				printSpiralLevelM1(node.right, level - 1, l);
			} else {
				printLevel(node.right, level - 1);
				printLevel(node.left, level - 1);
			}
		}

	}
}

public class LevelOrderTraversal {
	static Node root;

	void inOrderT(Node node) {

		if (node == null) {
			return;
		}
		inOrderT(node.left);
		System.out.print(node.value + "  ");
		inOrderT(node.right);
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

	void inOrder() {
		if (root == null) {
			return;
		}
		inOrderT(root);
	}

	void levelOrder() {
		if (root == null) {
			return;
		}
		root.levelOrder(root);
	}

	void spiralLevelOrder() {
		if (root == null) {
			return;
		}
		root.spiralLevel(root);
	}

	void printSpiralM2(Node node) {
		if (node == null)
			return; // NULL check

		// Create two stacks to store alternate levels
		Stack<Node> s1 = new Stack<Node>();// For levels to be printed from
											// right to left
		Stack<Node> s2 = new Stack<Node>();// For levels to be printed from left
											// to right

		// Push first level to first stack 's1'
		s1.push(node);

		// Keep printing while any of the stacks has some nodes
		while (!s1.empty() || !s2.empty()) {
			// Print nodes of current level from s1 and push nodes of
			// next level to s2
			while (!s1.empty()) {
				Node temp = s1.peek();
				s1.pop();
				System.out.print(temp.value + " ");

				// Note that is right is pushed before left
				if (temp.right != null)
					s2.push(temp.right);

				if (temp.left != null)
					s2.push(temp.left);

			}

			// Print nodes of current level from s2 and push nodes of
			// next level to s1
			while (!s2.empty()) {
				Node temp = s2.peek();
				s2.pop();
				System.out.print(temp.value + " ");

				// Note that is left is pushed before right
				if (temp.left != null)
					s1.push(temp.left);
				if (temp.right != null)
					s1.push(temp.right);
			}
		}
	}

	void printSpiral(Node node) {
		int h = height(node);
		int i;

		/*
		 * ltr -> left to right. If this variable is set then the given label is
		 * transversed from left to right
		 */
		boolean ltr = false;
		for (i = 1; i <= h; i++) {
			printGivenLevel(node, i, ltr);

			/* Revert ltr to traverse next level in opposite order */
			ltr = !ltr;
		}

	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int height(Node node) {
		if (node == null)
			return 0;
		else {

			/* compute the height of each subtree */
			int lheight = height(node.left);
			int rheight = height(node.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at a given level */
	void printGivenLevel(Node node, int level, boolean ltr) {
		if (node == null)
			return;
		if (level == 1)
			System.out.print(node.value + " ");
		else if (level > 1) {
			if (ltr != false) {
				printGivenLevel(node.left, level - 1, ltr);
				printGivenLevel(node.right, level - 1, ltr);
			} else {
				printGivenLevel(node.right, level - 1, ltr);
				printGivenLevel(node.left, level - 1, ltr);
			}
		}
	}

	public static void main(String[] args) {
		LevelOrderTraversal tree1 = new LevelOrderTraversal();
		// tree1.add(40);
		// tree1.add(30);
		// tree1.add(20);
		// tree1.add(10);
		// tree1.add(35);
		// tree1.add(80);
		// tree1.add(75);
		// tree1.add(100);
		// tree1.add(1);
		// tree1.add(2);
		// tree1.add(3);
		// tree1.add(7);
		// tree1.add(6);
		// tree1.add(5);
		// tree1.add(4);
		tree1.root = new Node(1);
		tree1.root.left = new Node(2);
		tree1.root.right = new Node(3);
		tree1.root.left.left = new Node(7);
		tree1.root.left.right = new Node(6);
		tree1.root.right.left = new Node(5);
		tree1.root.right.right = new Node(4);
		// System.out.println("IO traversal of the tree is ");
		// tree1.inOrder();
		// System.out.println(" \nLevel Order traversal of the tree is ");
		// tree1.levelOrder();
		System.out.println(" \nSpiral Level Order traversal of the tree is ");
		// tree1.spiralLevelOrder();
		tree1.printSpiral(tree1.root);
		System.out.println(" \nMethod 2 Spiral Level Order traversal of the tree is ");
		tree1.printSpiralM2(tree1.root);
	}

}
