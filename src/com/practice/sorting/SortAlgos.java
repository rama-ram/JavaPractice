package com.practice.sorting;

public class SortAlgos {

	// Bubble Sort is the simplest sorting algorithm that works by repeatedly
	// swapping the adjacent elements if they are in wrong order.
	static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {

			for (int j = i; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println("array element is .." + arr[i]);
		}

	}

	// Insertion sort is a simple sorting algorithm that works the way we sort
	// playing cards in our hands
	static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= i - 1; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println("array element is .." + arr[i]);
		}
	}

	// In every iteration of selection sort, the minimum element (considering
	// ascending order) from the unsorted subarray is picked and moved to the
	// sorted subarray.
	static void selectionSort(int[] arr) {
		for (int k = 0; k < arr.length; k++) {
			int temp = arr[k];
			int index = 0;
			boolean ischanged = false;
			for (int i = k + 1; i < arr.length; i++) {
				if (arr[i] < temp) {
					temp = arr[i];
					index = i;
					ischanged = true;

				}
			}
			if (ischanged) {
				temp = arr[index];
				arr[index] = arr[k];
				arr[k] = temp;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println("array element is .." + arr[i]);
		}
	}

	public void mergeSort(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		if (left < right) {
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	public void merge(int[] arr, int left, int mid, int right) {
		// find the array size to me merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		// initiatlise 2 arrays to merge
		int[] L = new int[n1];
		int[] R = new int[n2];

		// insert values to the 2 arrasy
		for (int i = 0; i < n1; i++)
			L[i] = arr[i + left];
		for (int i = 0; i < n2; i++)
			R[i] = arr[mid + i + 1];

		// merge the 2 arrys

		int i = 0, j = 0, k = left;

		while (i < n1 && j < n2) {
			if (L[i] >= R[j]) {
				arr[k] = R[j];
				k++;
				j++;
			} else {
				arr[k] = L[i];
				k++;
				i++;
			}
		}
		while (i < n1) {
			arr[k] = L[i];
			k++;
			i++;
		}
		while (j < n2) {
			arr[k] = R[j];
			k++;
			j++;
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("array element is .." + arr[i]);
		}
	}

	// QUICK SORT:
	// picks an element as pivot and partitions the given array around the
	// picked pivot
	/*
	 * Target of partitions is, given an array and an element x of array as
	 * pivot, put x at its correct position in sorted array and put all smaller
	 * elements (smaller than x) before x, and put all greater elements (greater
	 * than x) after x
	 */
	public static void quickSort(int[] arr, int left, int right) {

		if (left < right) {
			int part = getPart(arr, left, right);
			quickSort(arr, left, part - 1);
			quickSort(arr, part + 1, right);

		}
	}

	static int getPart(int[] arr, int left, int right) {
		int pi = arr[right];
		int i = (left - 1);

		for (int j = left; j < right; j++) {
			if (arr[j] <= pi) {
				i++;
				// swap
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

			}

		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[right];
		arr[right] = temp;

		return i + 1;

	}

	public static void main(String[] args) {
		int[] arr = { 12, 11, 13, 5, 6 };// {5,1,4,2,0};
		// bubbleSort(arr);
		// insertionSort(arr);
		// selectionSort(arr);

		System.out.println("\nUNSorted array");
		print(arr);
		// new SortAlgos().mergeSort(arr, 0, arr.length - 1);
		quickSort(arr, 0, arr.length - 1);
		System.out.println("\nSorted array");
		print(arr);
	}

}
