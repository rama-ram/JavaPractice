package com.practice.dataStructures;

import java.util.HashMap;

public class TrieTest {
	private final TrieNode root;

	TrieTest() {

		root = new TrieNode((char) 0);
	}

	public void insert(String name) {
		System.out.println("adding nodes..." + name);
		TrieNode temp = root;
		int size = name.length();
		for (int i = 0; i < size; i++) {

			if (!temp.children.containsKey(name.charAt(i))) {
				TrieNode node1 = new TrieNode(name.charAt(i));
				temp.children.put(name.charAt(i), node1);
				temp = node1;
			} else {
				temp = temp.children.get(name.charAt(i));
				temp.endWord = false;
			}

		}
		temp.endWord = true;
	}

	public String getMatchingPrefix(String name) {
		TrieNode temp = root;

		int size = name.length();
		int lastIndex = 0;
		for (int i = 0; i < size; i++) {

			if (temp.children.containsKey(name.charAt(i))) {
				temp = temp.children.get(name.charAt(i));
				lastIndex = i;
			} else if (i == 0) {
				return "";
			}
		}
		return name.substring(0, lastIndex + 1);
	}

	private class TrieNode {

		private boolean endWord;
		HashMap<Character, TrieNode> children;
		char text;

		TrieNode(char ch) {
			text = ch;
			children = new HashMap<Character, TrieNode>();
			endWord = false;
		}

	}

	public static void main(String[] args) {
		TrieTest dict = new TrieTest();
		dict.insert("are");
		dict.insert("area");
		dict.insert("base");
		dict.insert("cat");
		dict.insert("cater");
		dict.insert("basement");

		// String input = "caterer";
		// System.out.print(input + ": ");
		// System.out.println("the matching prefi is :......" +
		// dict.getMatchingPrefix(input));
		//
		// input = "basement";
		// System.out.print(input + ": ");
		// System.out.println("the matching prefi is :........." +
		// dict.getMatchingPrefix(input));
		//
		// input = "are";
		// System.out.print(input + ": ");
		// System.out.println("the matching prefi is :........." +
		// dict.getMatchingPrefix(input));
		//
		// input = "arex";
		// System.out.print(input + ": ");
		// System.out.println("the matching prefi is :..........." +
		// dict.getMatchingPrefix(input));
		//
		// input = "basemexz";
		// System.out.print(input + ": ");
		// System.out.println("the matching prefi is :..............." +
		// dict.getMatchingPrefix(input));

		String input = "rea";
		System.out.print(input + ":   ");
		System.out.println("the matching prefi is :..............." + dict.getMatchingPrefix(input));
	}

}
