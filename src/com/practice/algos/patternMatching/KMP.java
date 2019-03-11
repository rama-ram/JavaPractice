package com.practice.algos.patternMatching;

public class KMP {

	static void matchSubString(String text, String ss) {
		int[] lps = lstArr(ss);
		int size = text.length();
		int j = 0;
		int i = 0;
		int sSize = ss.length();
		while (i < size) {
			if (text.charAt(i) == ss.charAt(j)) {
				i++;
				j++;
				if (j == sSize) {
					System.out.println("pattern found at index  " + (i - j));
					j = lps[j - 1];
				}
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else
					i++;

			}
		}
	}

	static int[] lstArr(String ss) {
		int size = ss.length();
		int[] arr = new int[size];
		int j = 0;
		arr[0] = 0;
		int i = 1;
		while (i < size) {
			if (ss.charAt(i) == ss.charAt(j)) {
				j++;
				arr[i] = j;
				i++;
			} else {
				if (j > 0) {
					j = arr[j - 1];

				} else {
					arr[i] = j;
					i++;
				}

			}
		}
		for (int a : arr)
			System.out.print(a + "  ");
		System.out.println();
		return arr;
	}

	public static void main(String[] args) {
		lstArr("AAAA");
		lstArr("ABCDE");
		lstArr("AABAACAABAA");
		lstArr("AAACAAAAAC");
		lstArr("AAABAAA");
		matchSubString("ABABDABACDABABCABAB", "ABABCABAB");
	}

}
