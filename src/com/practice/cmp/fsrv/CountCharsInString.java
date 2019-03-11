package com.practice.cmp.fsrv;

import java.util.HashMap;
import java.util.Map;

public class CountCharsInString {
	static void countCharsM2(String word) {
		char[] arr = word.toCharArray();
		int[] arr1 = new int[Character.MAX_VALUE];
		for (int i = 0; i < arr.length; i++) {
			arr1[arr[i]]++;
		}

		System.out.println("charachters and their occurences are :");
		for (int i = 0; i < arr.length; i++) {
			if (arr1[arr[i]] > 0)
				System.out.println("char " + arr[i] + " is found " + arr1[arr[i]] + " many times");
		}

	}

	static void canFormPalindrome(String word) {
		char[] arr = word.toCharArray();
		int[] arr1 = new int[Character.MAX_VALUE];
		for (int i = 0; i < arr.length; i++) {
			arr1[arr[i]]++;
		}
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr1[arr[i]] == 1 || arr1[arr[i]] % 3 == 0) {
				counter++;
			}
			if (counter > 1) {
				System.out.println("word cannot be rearranged to form a palindrome");
				return;
			}
		}
		System.out.println("word can be rearranged to form a palindrome");

	}

	static void countCharsM1(String word) {
		char[] arr = word.toCharArray();
		HashMap<Character, Integer> treemap = new HashMap<Character, Integer>(Math.min(word.length(), 27));
		for (char c : arr) {
			if (treemap.containsKey(c)) {
				treemap.put(c, (treemap.get(c)) + 1);
			} else {
				treemap.put(c, 1);
			}
		}

		System.out.println("charachters and their occurences are :");
		for (Map.Entry<Character, Integer> m : treemap.entrySet()) {
			System.out.println("key is " + m.getKey() + "  value is " + m.getValue());
		}

	}

	static void countCharsM3(String word, char c) {
		char[] arr = word.toCharArray();
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == c)
				counter++;
		}
		System.out.println("charachters occurences :" + counter + " times");
	}

	static void reverseString(String word) {
		char[] arr = word.toCharArray();
		int counter = 0;
		for (int i = arr.length - 1; i > 0; i--) {
			System.out.print(arr[i] + " ");
		}

	}

	public static void main(String[] args) {
		// countCharsM1("this is a test word");
		// countCharsM2("this is a test word");
		// countCharsM3("this is a test word", 't');
		canFormPalindrome("geeksforgeeks");
		canFormPalindrome("geeksogeeks");
		reverseString("this is a test");
	}

}
