package com.practice.allaboutTree;

import java.util.ArrayList;
import java.util.List;

import com.practice.dataStructures.BinaryTree;

public class RootToLeafSum {
	// given a BT find if there is a path from root to leaf such that the sum of
	// nodes in path = given sum

	// loigc
	// check if node is a leaf, if not check left side passing remaing sum
	// check if node has right passgn remaining sum

	void getTreeSum(BinaryTree tree, int sum) {
		List<Integer> arr = new ArrayList<Integer>();
		getSum(tree.root, sum, arr);

		for (int i : arr)
			System.out.println(i);
	}

	boolean getSum(BinaryTree.Node node, int sum, List<Integer> arr) {
		if (node == null)
			return true;
		if (node.left == null && node.right == null)
			if (node.data == sum) {
				System.out.println(node.data);
				arr.add(node.data);
				return true;
			} else {
				return false;
			}
		if (getSum(node.left, sum - node.data, arr)) {
			arr.add(node.data);
			return true;
		}
		if (getSum(node.right, sum - node.data, arr)) {
			arr.add(node.data);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		RootToLeafSum sz = new RootToLeafSum();
		BinaryTree tree1 = new BinaryTree();
		tree1.add(40);
		tree1.add(30);
		tree1.add(20);
		tree1.add(10);
		tree1.add(35);
		tree1.add(80);
		tree1.add(100);
		tree1.add(10);
		sz.getTreeSum(tree1, 100);
	}

}
