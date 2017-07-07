package com.practice.sorting;

public class InsertionSort {

	static void insertSort(int[] arr) {
		int size = arr.length;
		for (int i = 1; i < size; i++) {

			for (int j = 0; j < i; j++) {

				if (arr[i] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		System.out.println("sorted array is");
		for (int i : arr)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {

		insertSort(new int[] { 3, 6, 1, 4 });
	}

}
