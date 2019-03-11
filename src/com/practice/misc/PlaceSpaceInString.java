package com.practice.misc;

public class PlaceSpaceInString {
	static void placeSpace(String text) {
		int len = text.length();
		char[] buf = new char[2 * len];
		buf[0] = text.charAt(0);

		printbuf(text, buf, 1, 1, len);
	}

	static void printbuf(String text, char[] buf, int i, int j, int len) {

		if (i == len) {
			buf[j] = '\0';
			System.out.println(buf);
			return;
		}
		buf[j] = text.charAt(i);
		printbuf(text, buf, i + 1, j + 1, len);

		buf[j] = ' ';
		buf[j + 1] = text.charAt(i);

		printbuf(text, buf, i + 1, j + 2, len);

	}

	public static void main(String[] args) {
		String str = "ABCD";
		placeSpace(str);
	}

}
