package com.practice.misc;

public class TestMisc1 {

	static String mergeStrings(String a, String b) {
		StringBuilder merged = new StringBuilder();
		int n1 = a.length();
		int n2 = b.length();
		if (n1 == n2) {
			int i = 0;
			while (i < n1) {
				merged.append(a.charAt(i)).append(b.charAt(i));
				i++;
			}
		} else if (n1 > n2) {
			int i = 0;
			while (i < n2) {
				merged.append(a.charAt(i)).append(b.charAt(i));
				i++;
			}
			while (i < n1) {
				merged.append(a.charAt(i));
				i++;
			}
		} else if (n2 > n1) {
			int i = 0;
			while (i < n1) {
				merged.append(a.charAt(i)).append(b.charAt(i));
				i++;
			}
			while (i < n2) {
				merged.append(b.charAt(i));
				i++;
			}
		}
		return merged.toString();
	}

	/*
	 * Complete the function below.
	 */

	static String longestEvenWord(String sentence) {

		// find the words in the string
		String[] arr = sentence.split("\\s");
		int size = arr.length;
		System.out.println("the array length is " + size);
		int maxSize = 0;
		int maxIndex = 0;
		for (int i = 1; i <= size; i++) {
			int temp = arr[i - 1].length();
			if (temp % 2 == 0 && temp > maxSize) {
				maxSize = temp;
				maxIndex = i;
			}
		}
		if (maxIndex > 0)
			return arr[maxIndex - 1];
		else
			return "00";
	}

	public static void main(String[] args) {
		// System.out.println(mergeStrings("abcz", "defvv"));
		System.out.println(longestEvenWord("Time to write great code"));
	}

}
