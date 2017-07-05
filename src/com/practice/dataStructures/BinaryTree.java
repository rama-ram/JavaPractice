package com.practice.dataStructures;

public class BinaryTree {

	Node root;

	void add(int value) {
		if (root == null) {
			root = new Node(value);
			System.out.println("Added root node" + value);
		} else
			root.addNode(value);
	}

	void inorder() {

		root.inorderTraversal(root);
	}

	void preorder() {

		root.preorderTraversal(root);
	}

	void postorder() {

		root.postorderTraversal(root);
	}

	void levelorder() {

		root.levelorderTraversal(root);
	}

	int minDepth() {

		return root.minDepth(root);
	}

	class Res {
		public int val;
	}

	int findMaxUtil(Node node, Res res) {

		// Base Case
		if (node == null)
			return 0;

		// l and r store maximum path sum going through left and
		// right child of root respectively
		int l = findMaxUtil(node.left, res);
		int r = findMaxUtil(node.right, res);

		// Max path for parent call of root. This path must
		// include at-most one child of root
		int max_single = Math.max(Math.max(l, r) + node.data, node.data);

		// Max Top represents the sum when the Node under
		// consideration is the root of the maxsum path and no
		// ancestors of root are there in max sum path
		int max_top = Math.max(max_single, l + r + node.data);

		// Store the Maximum Result.
		res.val = Math.max(res.val, max_top);

		return max_single;
	}

	int findMaxSum() {
		// For each node there can be four ways that the max path goes through
		// the node:
		// 1. Node only
		// 2. Max path through Left Child + Node
		// 3. Max path through Right Child + Node
		// 4. Max path through Left Child + Node + Max path through Right Child
		return findMaxSum(root);
	}

	// Returns maximum path sum in tree with given root
	int findMaxSum(Node node) {

		// Initialize result
		// int res2 = Integer.MIN_VALUE;
		Res res = new Res();
		res.val = Integer.MIN_VALUE;

		// Compute and return result
		findMaxUtil(node, res);
		return res.val;
	}

	public class Node {
		Node left;
		Node right;
		int data;

		Node(int value) {
			data = value;

		}

		void addNode(int value) {
			Node current = root;

			while (current.data >= value) {
				if (current.left != null)
					current = current.left;
				else {
					current.left = new Node(value);
					System.out.println(value + "added node to left of " + current.data);
					return;
				}
			}
			while (current.data < value) {
				if (current.right != null)
					current = current.right;
				else {
					current.right = new Node(value);
					System.out.println(value + "added node to right of " + current.data);
					return;
				}
			}
		}

		void inorderTraversal(Node node) {
			if (node == null)
				return;
			inorderTraversal(node.left);
			System.out.println(node.data);
			inorderTraversal(node.right);

		}

		void preorderTraversal(Node node) {
			if (node == null)
				return;
			System.out.println(node.data);
			inorderTraversal(node.left);
			inorderTraversal(node.right);

		}

		void postorderTraversal(Node node) {
			if (node == null)
				return;
			inorderTraversal(node.left);
			inorderTraversal(node.right);
			System.out.println(node.data);

		}

		void levelorderTraversal(Node node) {
			if (node == null)
				return;
			int height = getTreeHeight(node);
			for (int i = 1; i <= height; i++) {

				printGivenLevel(node, i);
			}
		}

		int getTreeHeight(Node node) {

			if (node == null)
				return 0;
			else {
				int lheight = getTreeHeight(node.left);
				int rheight = getTreeHeight(node.right);

				if (lheight > rheight)
					return (1 + lheight);
				else
					return (1 + rheight);
			}
		}

		void printGivenLevel(Node root, int level) {
			if (root == null)
				return;
			if (level == 1)
				System.out.print(root.data + " ");
			else if (level > 1) {
				printGivenLevel(root.left, level - 1);
				printGivenLevel(root.right, level - 1);
			}
		}

		int minDepth(Node node) {
			if (root == null)
				return 0;
			if (node.left == null && node.right == null)
				return 1;
			if (node.right == null) {
				return minDepth(node.left) + 1;
			}
			if (node.left == null) {
				return minDepth(node.right) + 1;
			}
			return Math.min(minDepth(node.left), minDepth(node.right)) + 1;

		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(40);
		bt.add(30);
		bt.add(20);
		bt.add(10);
		bt.add(35);
		bt.add(80);
		bt.add(100);
		// bt.add(5);
		// bt.add(3);
		// bt.add(4);
		// bt.add(6);
		// bt.add(10);
		// bt.add(2);
		// bt.add(1);
		System.out.println("inorder..");
		bt.inorder();
		System.out.println("preorder..");
		bt.preorder();
		System.out.println("postorder..");
		bt.postorder();
		System.out.println("levelorder..");
		bt.levelorder();
		System.out.println("minDepth.." + bt.minDepth());

	}

}
