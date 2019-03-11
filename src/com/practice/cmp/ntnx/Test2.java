package com.practice.cmp.ntnx;

import java.io.IOException;

class Test2 {

	public static String functionx(String number) {
		StringBuilder result = new StringBuilder();

		char repeat = number.charAt(0);
		number = number.substring(1) + " ";
		int times = 1;

		for (char actual : number.toCharArray()) {
			if (actual != repeat) {
				result.append(repeat + "" + times);
				times = 1;
				repeat = actual;
			} else {
				times += 1;
			}
		}
		return result.toString();
	}

	public static String pernixSequence(String number, int count) {
		while (count > 1) {
			number = functionx(number);
			count--;
		}
		return number;
	}

	public static void main(String[] args) throws IOException {
		String output = pernixSequence("500055", 3);
		System.out.println(output);
	}

}