package com.practice.algos.search;

public class RadixSort {

	static int getMax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;

	}

	static void print(int[] arr) {
		for (int c : arr)
			System.out.print(c + "  ");
	}

	static void radixSort(int[] arr) {
		int max = getMax(arr);// to see the max digits to do countingsort
		for (int i = 1; max / i > 0; i = i * 10) {
			countingSort(arr, i);
			// countSort(arr, arr.length, i);
		}
		print(arr);
	}

	static void countingSort(int[] arr, int n) {
		// count the occurences of each digits in the
		int[] count = new int[10];
		int output[] = new int[arr.length]; // output array
		for (int i = 0; i < arr.length; i++) {
			count[(arr[i] / n) % 10]++;
		}
		// sum the value with the next pos in the count array
		for (int i = 1; i < 10; i++) {
			count[i] = count[i] + count[i - 1];
		}
		// form the new array based on the count arr
		for (int i = 0; i < arr.length; i++) {
			output[count[(arr[i] / n) % 10] - 1] = arr[i];
			count[(arr[i] / n) % 10]--;
		}
		for (int i = 0; i < arr.length; i++)
			arr[i] = output[i];
	}

	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		// Arrays.fill(count, 0);

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to curent digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		radixSort(arr);
	}

}
