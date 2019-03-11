package com.practice.allaboutTree;

import com.practice.dataStructures.BinaryTree;

public class IsBTaBST {
	// given a tree find if its a binary search tree
	// set a MIN and MAX value so as to assess the tree

	void isBST(BinaryTree tree) {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		System.out.println("is this tree a BST" + isTreeBST(tree.root, min, max));
	}

	boolean isTreeBST(BinaryTree.Node node, int min, int max) {
		if (node == null)
			return true;

		if (node.data < min || node.data > max)
			return false;

		return (isTreeBST(node.left, min, node.data) && isTreeBST(node.right, node.data, max));
	}

	public static void main(String[] args) {
		IsBTaBST sz = new IsBTaBST();
		BinaryTree tree1 = new BinaryTree();
		tree1.add(40);
		tree1.add(30);
		tree1.add(20);
		tree1.add(10);
		tree1.add(35);
		tree1.add(80);
		tree1.add(100);
		tree1.add(10);
		sz.isBST(tree1);
	}

}
