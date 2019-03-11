package com.practice.misc;

import java.util.HashMap;

public class AnotherTrie {

	static Node root = new Node('\0');

	static void addName(String text) {
		if (root == null)
			return;
		char[] arr = text.toCharArray();
		Node temp = root;
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			if (!temp.childMap.containsKey(arr[i])) {
				temp.childMap.put(arr[i], new Node(arr[i]));
			} else
				temp = temp.childMap.get(arr[i]);

			temp.size++;

		}
		temp.eow = true;
	}

	static void findPartial(String word) {
		if (root == null)
			return;
		char[] arr = word.toCharArray();
		Node temp = root;
		int size = arr.length;
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (temp.childMap.containsKey(arr[i])) {
				temp = temp.childMap.get(arr[i]);
				// System.out.print(c);
			} else {
				System.out.println(0);

			}
		}
		System.out.println(temp.childMap.size());
		String test = "tst";
		test.split("\\s+");
	}

	public static void solution(String magazine, String note) {
		if (magazine != null && note != null) {
			if (magazine.length() < note.length()) {
				System.out.println("No");
				return;
			}
			int index = 0;
			String[] arr = note.split("\\s+");
			for (String s : arr) {
				int temp = magazine.indexOf(s);
				if (temp == -1 || temp < index) {
					System.out.println("No");
					return;
				}
				index = temp;

			}
			System.out.println("Yes");
			return;
		}
		System.out.println("No");
	}

	// static int findCount(Node node, int count) {
	// if (node.eow)
	// return 1;
	// ArrayList<Node> list = new ArrayList<Node>();
	// list.
	//
	// return 1;
	// }
	// find the sequence in the array that has maximum sum and return the sum
	static int[] findMaxArrSumSequence(int[] arr) {
		int max = arr[0];
		int sum = max;
		int start = 0;
		int end = 0;
		int start_temp = 0;

		for (int i = 1; i < arr.length; i++) {
			// handle condition when sum starts dropping to less than 0, reset
			// the sum and start index
			if (sum < 0) {
				sum = arr[i];
				start_temp = i;
			} else {
				sum = sum + arr[i];
			}
			// reset max if sum keeps increasing
			if (sum >= max) {
				max = sum;
				end = i;
				start = start_temp;
			}
		}
		return new int[] { start, end, max };
	}

	public static int[] maxSum(int[] arr) {
		if (arr.length == 0)
			return new int[] { -1, -1, Integer.MIN_VALUE };

		int start = 0;
		int end = 0;
		int max = arr[0];
		int start_temp = 0;
		int sum = max;

		for (int i = 1; i < arr.length; i++) {
			if (sum < 0) {
				sum = arr[i];
				start_temp = i;
			} else {
				sum += arr[i];
			}

			if (sum >= max) {
				max = sum;
				start = start_temp;
				end = i;
			}
		}

		return new int[] { start, end, max };
	}

	public static void main(String[] args) {
		// String op = "";
		// if (op.equalsIgnoreCase("add")) {
		// }
		// solution("give me one grand Today night", "give one grand today");
		// int[] arr1 = findMaxArrSumSequence(new int[] { -1, 2, -4, 5, 6 });
		// for (int i : arr1)
		// System.out.print(i + " ");
		int[] arr = findMaxArrSumSequence(new int[] { -1, 2, 9, -4, 5, 6 });
		for (int i : arr)
			System.out.print(i + " ");
		// int[] arr3 = maxSum(new int[] { -1, 2, 9, -4, 5, 6 });
		// for (int i : arr3)
		// System.out.print(i + " ");
	}

	// rotate a given matrix by 90 degrees

	public static void rotate(int[][] img, int n) {
		for (int layer = 0; layer < n / 2; layer++) {
			int rotations = n - 2 * layer - 1;
			int last = n - 1 - layer;

			for (int i = 0; i < rotations; i++) {

				// top -> temp
				int temp = img[layer][layer + i];

				// left -> top
				img[layer][layer + i] = img[last - i][layer];

				// bottom -> left
				img[last - i][layer] = img[last][last - i];

				// right -> bottom
				img[last][last - i] = img[layer + i][last];

				// top -> right
				img[layer + i][last] = temp;
			}
		}
	}
}

class Node {
	HashMap<Character, Node> childMap = new HashMap<Character, Node>();
	boolean eow = false;
	Character c;
	int size = 0;

	Node(Character text) {
		c = text;
	}
}
