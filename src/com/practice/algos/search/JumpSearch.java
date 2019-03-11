package com.practice.algos.search;

public class JumpSearch {

	static int jumpSrch(int[] a, int key) {
		// divide entire arr in to blocks and then based on the condition, jump
		// blocks or perform linear search in that block.
		int size = a.length;
		int step = (int) Math.floor(Math.sqrt(size));
		int previous = 0;
		while (a[(Math.min(step, size) - 1)] < key) {
			previous = step;
			step = step + (int) Math.floor(Math.sqrt(size));
			if (previous >= size)
				return -1;
		}
		while (a[previous] < key) {
			previous++;
			if (a[previous] == key)
				return previous;
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int index = jumpSrch(a, 5);
		if (index > -1)
			System.out.println("the key is found in " + index);
		else
			System.out.println("the key is not found ");
	}

}
