package com.practice.algos.search;

public class LinearSearch {

	static int linearSrch(int[] a, int start, int end, int key) {
		if (end > start) {
			for (int c = 0; c < a.length; c++) {
				if (a[c] == key)
					return c;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int index = linearSrch(a, 0, 5, 5);
		if (index > -1)
			System.out.println("the key is found in " + index);
		else
			System.out.println("the key is not found ");
	}

}
