package com.practice.cmp.ntnx;

public class StringRotation {
	// When a string "EXAMPLE" is given a command "R:3", it will be rotated
	// right 3 times in the following manner:

	// test cases that can be handled:
	// code = 0 and 7 are the same and no action needed
	// code > 7 has to be mod of 7
	static void rotator(String text, String code) {
		// get the direction and rotation count
		String[] arr = code.split(":");
		for (String s : arr)
			System.out.println("split strings are " + s);
		int count = Integer.parseInt(arr[1]);
		if (count > text.length())
			count = count % text.length();
		if (arr[0].equalsIgnoreCase("R")) {

			System.out.println("Its a right rotation with count " + count + " rotation!");
			String right = text.substring(0, text.length() - count);
			String prefix = text.substring(text.length() - count, text.length());
			System.out.println("The rotated String is " + prefix + right);

		}
	}

	public static void main(String[] args) {
		rotator("EXAMPLE", "R:8");
	}

}
