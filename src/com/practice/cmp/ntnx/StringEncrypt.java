package com.practice.cmp.ntnx;

public class StringEncrypt {
	/*
	 * Encrypt string Given a simple sentence or string S, encrypt it using key
	 * K. K >= 0
	 * 
	 * When S="cat" and K is 1, the encrypted string is: "dbu".
	 */
	// Questions:
	// what if given letter is z and encryption code > 0
	// what if code > 26 is it cyclic rotation

	static String stringEncrypt(String original, int code) {
		char[] first = original.toCharArray();
		for (int i = 0; i < first.length; i++) {
			System.out.println((first[i]));
			first[i] = (char) (first[i] + code);
		}
		System.out.println("after encrypting..." + new String(first));
		return new String(first);

	}

	static void stringDecrypt(String original, int code) {
		char[] first = original.toCharArray();
		for (int i = 0; i < first.length; i++) {
			System.out.println((first[i]));
			first[i] = (char) (first[i] - code);

		}
		System.out.println("after decrypting..." + new String(first));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stringDecrypt(stringEncrypt("Z-*89", 10), 10);
	}

}
