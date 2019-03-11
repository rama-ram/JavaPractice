package com.practice.allaboutTree;

import com.practice.dataStructures.BinaryTree;

public class SameTree {
	// given 2 trees find if they are the same
	// compare roots and then left subtree and right sub treee
	boolean isSameTreee(BinaryTree tree1, BinaryTree tree2) {
		return isSameTree(tree1.root, tree2.root);
	}

	boolean isSameTree(BinaryTree.Node tree1, BinaryTree.Node tree2) {
		if (tree1 == null && tree2 == null)
			return true;
		if (tree1 == null || tree2 == null)
			return false;

		return (tree1.data == tree2.data && isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right));

	}

	public static void main(String[] args) {
		SameTree st = new SameTree();
		BinaryTree tree1 = new BinaryTree();
		BinaryTree tree2 = new BinaryTree();
		tree1.add(40);
		tree1.add(30);
		tree1.add(20);
		tree1.add(10);
		tree1.add(35);
		tree1.add(80);
		tree1.add(100);

		// second tree
		tree2.add(40);
		tree2.add(30);
		tree2.add(20);
		tree2.add(10);
		tree2.add(35);
		tree2.add(80);
		// tree2.add(100);

		System.out.println("is same tree..?" + st.isSameTreee(tree1, tree2));
	}

}
