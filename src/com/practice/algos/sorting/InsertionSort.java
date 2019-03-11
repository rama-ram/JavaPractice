package com.practice.algos.sorting;

public class InsertionSort {
	static void insertionSrt(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];// compare this card with all other present cards,
								// and insert in proper space
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}

		for (int c : arr)
			System.out.print(c + "  ");
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 2, 6, 1, 5 };
		insertionSrt(arr);

	}

}
