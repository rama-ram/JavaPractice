package com.practice.algos.sorting;

public class TimSort {

	static void timSrt(int[] arr, int run) {
		if (run <= 32) {
			// perform insertion sort
			System.out.println("insertion  sort is selected..");
			insertionSort(arr);
			print(arr);
			return;
		}
		System.out.println("merge sort is selected..");
		MergeSort.mrgSrt(arr);
	}

	static void print(int[] arr) {
		for (int c : arr)
			System.out.print(c + "  ");
	}

	static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int key = arr[i];
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 2, 6, 1, 5 };
		timSrt(arr, 40);
	}

}
