package com.practice.algos.sorting;

public class SelectionSort {
	static void selectionSrt(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			arr[index] = arr[i];
			arr[i] = min;
		}

		for (int a : arr)
			System.out.print(a + "  ");
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 2, 6, 1, 5 };
		selectionSrt(arr);
	}

}
