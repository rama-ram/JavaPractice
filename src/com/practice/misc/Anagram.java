package com.practice.misc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class Anagram {
	public static int numberNeeded(String first, String second) {
		int[] lettercounts = new int[26];
		for (char c : first.toCharArray()) {
			lettercounts[c - 'a']++;
		}
		for (char c : second.toCharArray()) {
			lettercounts[c - 'a']--;
		}
		int result = 0;
		for (int i : lettercounts) {
			result += Math.abs(i);
		}
		return result;
	}

	public static void isAnagram(String word1, String word2) {
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		char[] arr1 = word1.toCharArray();
		char[] arr2 = word2.toCharArray();
		int[] counter1 = new int[258];
		int[] counter2 = new int[258];
		// Arrays.sort(arr1);
		// Arrays.sort(arr2);

		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		// insert in hashmap and find if they are equal
		for (int i = 0; i < word1.length(); i++) {
			if (map1.containsKey(word1.charAt(i))) {
				int value = map1.get(word1.charAt(i));
				map1.put(word1.charAt(i), value++);
			}

		}

	}

	public static void isAnagramBySort(String word1, String word2) {
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		char[] arr1 = word1.toCharArray();
		char[] arr2 = word2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		System.out.println(arr1);
		System.out.println(arr2);
		System.out.println("is anagram ? " + Arrays.equals(arr1, arr2));
	}

	public static void isAnagramByCounting(String word1, String word2) {
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		// insert in hashmap and find if they are equal
		for (int i = 0; i < word1.length(); i++) {
			if (map1.containsKey(word1.charAt(i))) {
				int value = map1.get(word1.charAt(i));
				map1.put(word1.charAt(i), value++);
			} else {
				map1.put(word1.charAt(i), 1);
			}

		}
		for (int i = 0; i < word2.length(); i++) {
			if (map2.containsKey(word2.charAt(i))) {
				int value = map2.get(word2.charAt(i));
				map2.put(word2.charAt(i), value++);
			} else {
				map2.put(word2.charAt(i), 1);

			}

		}
		System.out.println("the hashmaps are compared and the result is ..." + map1.equals(map2));

		int counter = 0;
		for (Entry<Character, Integer> firstEntry : map1.entrySet()) {

			if (map2.get(firstEntry.getKey()) == null)
				counter = counter + map1.get(firstEntry.getKey());
			else if (map2.get(firstEntry.getKey()) != map1.get(firstEntry.getKey())) {
				System.out.println("not an anagram");
				counter = counter + Math.abs(map2.get(firstEntry.getKey()) - map1.get(firstEntry.getKey()));
			}
			System.out.println("counter value is " + counter);
		}

	}

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		String a = "stoone";
		String b = "onejh";
		// System.out.println(numberNeeded(a, b));
		// int x=a.compareTo(b);
		// System.out.println("the number is " + x);
		// isAnagram("listen","silent");
		// isAnagram("control","after");
		// isAnagram("Triangle","Integral");
		//
		// isAnagramByCounting("listen","silent");
		// isAnagramByCounting("control","after");

		Date data = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z");
		System.out.println(format.format(data));

		isAnagramBySort("Triangle", "Integral");

		int inarr1[] = { 1, 2, 3 };
		int inarr2[] = { 1, 2, 3 };
		Object[] arr1 = { inarr1 }; // arr1 contains only one element
		Object[] arr2 = { inarr2 }; // arr2 also contains only one element
		Object[] outarr1 = { arr1 }; // outarr1 contains only one element
		Object[] outarr2 = { arr2 }; // outarr2 also contains only one element
		if (Arrays.deepEquals(outarr1, outarr2))
			System.out.println("Same");
		else
			System.out.println("Not same");

	}
}