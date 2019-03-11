package com.practice.allaboutTree;

import com.practice.dataStructures.BinaryTree;

public class HeightTree {
	// given a root a B tree, find the max height of the tree (path with max
	// nodes)
	int getTreeHeight(BinaryTree tree1) {

		return getHeight(tree1.root);
	}

	int getHeight(BinaryTree.Node node) {
		if (node == null)
			return 0;

		int left = getHeight(node.left);
		int right = getHeight(node.right);
		return Math.max(left, right) + 1;

	}
	// construct a tree from a given array

	void arrToTree(int[] arr) {

		int mid = arr.length / 2;

	}

	public static void main(String[] args) {
		HeightTree sz = new HeightTree();
		BinaryTree tree1 = new BinaryTree();
		tree1.add(40);
		tree1.add(30);
		tree1.add(20);
		tree1.add(10);
		tree1.add(35);
		tree1.add(80);
		tree1.add(100);

		System.out.println("the height of the tree is " + sz.getTreeHeight(tree1));

	}

}
