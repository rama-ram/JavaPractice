package com.practice.algos.sorting;

public class MergeSort {

	static void mrgSrt(int[] arr) {
		msort(arr, 0, arr.length - 1);
		print(arr);
	}

	static void msort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) >>> 1;
			// int mid = left + (right - left) / 2;
			msort(arr, left, mid);
			msort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	static void merge(int[] arr, int l, int m, int r) {
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;

		/* create temp arrays */
		int[] L = new int[n1];
		int[] R = new int[n2];

		/* Copy data to temp arrays L[] and R[] */
		for (i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for (j = 0; j < n2; j++)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays back into arr[l..r] */
		i = 0;
		j = 0;
		k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy the remaining elements of L[], if there are any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy the remaining elements of R[], if there are any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	static void print(int[] arr) {
		for (int c : arr)
			System.out.print(c + "  ");
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 2, 6, 1, 5 };
		mrgSrt(arr);
	}
}
