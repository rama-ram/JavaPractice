package com.practice.cmp.vsa;

public class SubStringMatch {

	static int matchSubString(String text, String ss) {

		if (text != null && ss != null && !ss.isEmpty() && !text.isEmpty()) {
			int textSize = text.length();
			int ssSize = ss.length();

			if (ssSize <= textSize) {
				if (ss.equalsIgnoreCase(text)) {
					return 0;
				} else {
					int j = 0;
					for (int i = 0; i < textSize; i++) {
						if (text.charAt(i) == ss.charAt(j)) {
							j++;
							if (j == ssSize)
								return i - ssSize + 1;
						} else {
							j = 0;
							i = i - j + 1;
						}
					}

				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int result = matchSubString("this test has to be corrext", "tet");
		if (result == -1) {
			System.out.println("no match");
			return;
		}
		System.out.println("matching substirng index is " + (result + 1));
	}

}
