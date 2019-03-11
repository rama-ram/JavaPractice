package com.practice.cmp.amzon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

//Simple programs related to number reversal without using Array, Finding the pairs forming a particular sum from a given array.
public class Arrays {

	static void findPair1(int[] arr, int value) {
		int size = arr.length;
		HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < size; i++) {
			int temp = 1;
			if (map.putIfAbsent(arr[i], temp) == null)
				map.put(arr[i], temp);
			else
				map.put(arr[i], (map.get(arr[i])) + 1);

		}
		for (int i = 0; i < size; i++) {
			if (map.get(value - arr[i]) != null) {
				System.out.println(arr[i] + "  " + (value - arr[i]));
				map.remove(arr[i]);
			}
		}

	}

	static void findPair2(int[] arr, int value) {
		int size = arr.length;
		ArrayList<Integer> map = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			map.add(arr[i]);
		}
		for (int i = 0; i < size; i++) {
			if (map.contains(value - arr[i])) {
				System.out.println(arr[i] + "  " + (value - arr[i]));
				map.remove(Integer.valueOf(arr[i]));
			}
		}

	}

	static void findPair(int[] arr, int value) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			if (arr[i] < value) {
				for (int j = i + 1; j < size; j++) {
					if (arr[i] + arr[j] == value)
						System.out.println(arr[i] + "  " + arr[j]);
				}
			}
		}
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, -3, 4, 5, 9 };
		findPair(arr, 6);
		findPair1(arr, 6);
		findPair2(arr, 6);
	}
}
