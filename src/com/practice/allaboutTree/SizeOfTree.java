package com.practice.allaboutTree;

import com.practice.dataStructures.BinaryTree;

public class SizeOfTree {
	// given a binary tree, calculate the tree size (number of nodes in the
	// tree)

	int getTreeSize(BinaryTree tree1) {

		return getSize(tree1.root);
	}

	int getSize(BinaryTree.Node node) {
		if (node == null)
			return 0;

		int left = getSize(node.left);
		int right = getSize(node.right);
		return left + right + 1;

	}

	public static void main(String[] args) {
		SizeOfTree sz = new SizeOfTree();
		BinaryTree tree1 = new BinaryTree();
		tree1.add(40);
		tree1.add(30);
		tree1.add(20);
		tree1.add(10);
		tree1.add(35);
		tree1.add(80);
		tree1.add(100);
		tree1.add(10);

		System.out.println("the size of the tree is " + sz.getTreeSize(tree1));
	}

}
