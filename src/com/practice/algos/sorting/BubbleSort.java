package com.practice.algos.sorting;

public class BubbleSort {

	static void bubbleSrt(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			for (int i = 1; i < arr.length; i++) {
				if (arr[i - 1] > arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}

			}
		}
		for (int c : arr)
			System.out.print(c + "  ");
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 2, 6, 1, 5 };
		bubbleSrt(arr);
	}

}
