package com.practice.algos.search;

public class BinarySearch {

	static int binSearch(int[] a, int start, int end, long key) {
		int high = end - 1;
		int low = start;
		while (high >= low) {
			int mid = (low + high) >>> 1;
			if (a[mid] < key) {
				low = mid + 1;

			} else if (a[mid] > key) {
				high = high - 1;
			} else
				return mid; // found
		}
		return -1; // not found
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int index = binSearch(a, 0, 5, 6);
		if (index > -1)
			System.out.println("the key is found in " + index);
		else
			System.out.println("the key is not found ");

	}

}
