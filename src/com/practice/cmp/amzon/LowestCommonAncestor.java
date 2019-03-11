package com.practice.cmp.amzon;

import java.util.ArrayList;
import java.util.Collections;

public class LowestCommonAncestor {
	Tree tree;

	void lca(Tree tree, int a, int b) {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr1 = findPathToNode(tree, a);
		arr2 = findPathToNode(tree, b);
		System.out.println("the lcs is ..." + intersect(arr1, arr2));

	}

	// traverse path from root to node and find the intersection point of the 2
	// paths
	// traverse from the root node and see if the left is not null and also not
	// the value we are searching,
	// if its the value we are searching then return the parent and start
	// traversing to the right side

	Tree.Node path(Tree.Node root, int a, int b) {

		if (root == null)
			return null;
		if (root.data == a || root.data == b)
			return root;
		Tree.Node left = path(root.left, a, b);
		Tree.Node right = path(root.right, a, b);

		if (left != null && right != null)
			return root;

		if (left == null && right == null)
			return null;
		return left != null ? left : right;
	}

	int intersect(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		int n1 = arr1.size();
		int n2 = arr2.size();
		// if (n1 == n2) {
		// for (int i = n1; i > 0; i--) {
		// for (int j = n2; j > 0; j--) {
		// if (arr1.contains(arr2.get(j)))
		// return arr1.get(i);
		// }
		// }
		// }
		// if (n1 < n2) {
		// for (int i = n1; i > 0; i--) {
		// for (int j = n2; j > 0; j--) {
		// if (arr1.get(i) == arr2.get(j))
		// return arr1.get(i);
		// }
		// }
		// }
		// if (n1 > n2) {
		// for (int i = n2; i > 0; i--) {
		// for (int j = n2; j > 0; j--) {
		// if (arr1.get(i) == arr2.get(i))
		// return arr1.get(i);
		// }
		// }
		// }
		Collections.sort(arr1);
		Collections.sort(arr2);
		for (int i : arr1)
			System.out.println(i);
		for (int i : arr2)
			System.out.println(i);

		for (int i = 0; i < n1; i++) {
			if (arr2.contains(arr1.get(i)))
				return arr1.get(i);
		}
		System.out.println("ther is no intersection");
		return 0;
	}

	void lowestCommonAncestor(Tree tree, int a, int b) {
		System.out.println(path(tree.root, a, b).data);
	}

	ArrayList<Integer> findPathToNode(Tree tree, int a) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		findPathOfNode(tree.root, a, arr);
		System.out.println("path to the node " + a + " is");
		for (int b : arr)
			System.out.println(b);
		return arr;
	}

	boolean findPathOfNode(Tree.Node node, int a, ArrayList<Integer> arr) {
		if (node == null)
			return false;

		if (node.data == a)
			return true;
		arr.add(node.data);
		if (findPathOfNode(node.left, a, arr) || findPathOfNode(node.right, a, arr))
			return true;

		arr.remove(Integer.valueOf(node.data));
		return false;
	}

	public static void main(String[] args) {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		Tree tree = new Tree();
		tree.addNode(50);
		tree.addNode(20);
		tree.addNode(10);
		tree.addNode(30);
		tree.addNode(40);
		tree.addNode(60);
		tree.addNode(55);
		tree.addNode(70);
		tree.addNode(80);
		tree.addNode(5);
		tree.addNode(1);
		// System.out.println("in order ..");
		// tree.inorder();
		// System.out.println("lowet common ansector ..5 and 30");
		// lca.lowestCommonAncestor(tree, 5, 30);
		// System.out.println("lowet common ansector ..5 and 30");
		// lca.findPathToNode(tree, 80);
		// System.out.println("lowet common ansector ..5 and 30 method 2 ");
		lca.lca(tree, 5, 30);
		System.out.println("in order ..");
		tree.inorder();
		System.out.println("pre order traversal...");
		tree.preOrder(tree.root);
		System.out.println("post order traversal...");
		tree.postOrder(tree.root);
	}

}
