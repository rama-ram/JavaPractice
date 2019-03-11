package com.practice.algos.search;

public class ExponentialSearch {
	// combination of jump search + binary search
	// jump i, i*2, i*4 ranges to find the search range, if at any point i> key,
	// then bo binary search between i/2 and i-2;

	static int expSearch(int[] ar, int key) {
		int i = 1;

		while (i < ar.length && ar[i] < key) {
			i = 2 * i;
		}
		// do binary search for ranges i/2 to size -1;

		int low = i / 2;
		int high = ar.length - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (ar[mid] < key) {
				low = low + 1;
			}
			if (ar[mid] > key) {
				high = high - 1;
			} else if (ar[mid] == key)
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int index = expSearch(a, 9);
		if (index > -1)
			System.out.println("the key is found in " + index);
		else
			System.out.println("the key is not found ");
	}

}
