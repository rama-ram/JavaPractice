package com.practice.cmp.ntnx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {
	//
	// back reference ([A-Z][a-z]*)\s\1--> matches when first name and last name
	// are Mark
	// []*[] [dd&&[]]
	// x?, x*, x+, X{n}, x{n,m}
	// boundary: ^, $
	static void decimalTest(String decimal) {
		Pattern p = Pattern.compile("(9){3}");
		Matcher m = p.matcher(decimal);
		System.out.println(m.pattern());
		while (m.find()) {
			System.out.println("pattern is :" + m.group() + m.start() + m.end());

		}
	}

	static void nameTest(String name) {// check if first name and last name are
										// same
		Pattern p = Pattern.compile("([A-Z][a-zA-Z]*)\\s\\1");
		Matcher m = p.matcher(name);
		System.out.println(m.pattern());
		while (m.find()) {
			System.out.println("pattern is : " + m.group() + m.start() + m.end());
		}
	}

	static void charTest(String decimal) {
		Pattern p = Pattern.compile("[a-t&&[^s-t]]");
		Matcher m = p.matcher(decimal);
		System.out.println(m.pattern());
		while (m.find()) {
			System.out.println("pattern is : " + m.group() + m.start() + m.end());
		}
	}

	// ^(?:4[0-9]{12}(?:[0-9]{3})?
	// ^(\d)(?!\1+$)\d*$
	private static void creditCardTest(String cardno) {
		/*
		 * A valid credit card from ABCD Bank has the following characteristics:
		 * 1) It must start with a 4,5 or 6 . 2) It must contain exactly 16
		 * digits. 3) It must only consist of digits (0-9). 4) It may have
		 * digits in groups of 4, separated by one hyphen "-". 5) It must NOT
		 * use any other separator like ' ' , '_', etc. 6) It must NOT have 4 or
		 * more consecutive repeated digits. Write regular expressions to
		 * validate the card number. If all criteria are met, print "Valid" else
		 * print the number of criteria which was not met. Examples: Credit card
		 * number: "4253625879615786" Expected output: "Valid" Credit card
		 * number: "42536258796157867" - This does not meet the 2nd criteria
		 * above - "It must contain exactly 16 digits" Expected output: "2"
		 */
		// [a-z&&[def]]
		int count = 0;
		// check for 16 digit number
		// if (cardno.length() != 16) {
		// System.out.println("card length is not equal to 16");
		// count++;
		// }
		// check for number starting within 3-6
		Pattern p = Pattern.compile("^[3-6][0-9]{15}$");
		Matcher m = p.matcher(cardno);
		if (!m.find()) {
			System.out.println("card number does not start within 3-6");
			count++;
		} // check for digit matches
			// p = Pattern.compile("0-9");
			// m = p.matcher(cardno);
			// if (!m.find()) {
			// System.out.println("card number has other than digits");
			// count++;
			// } // check for digit matches
			// System.out.println("mis matches are " + count);
			// // 4) It may have * digits in groups of 4, separated by one
			// hyphen
			// "-".
		p = Pattern.compile("[3-6][0-9]{3}(-?[0-9]{4})-?[0-9]{4}-?[0-9]{4}");
		m = p.matcher(cardno);
		if (!m.find()) {
			System.out.println("card number has other - in it..");
			count++;
		} // check for digit duplicates
		p = Pattern.compile("^(\\d)\\1+$");
		m = p.matcher(cardno);
		if (!m.find()) {
			System.out.println("card number has repeated digits");
			count++;
		}
		System.out.println("mis matches are " + count);

	}

	public static void main(String[] args) {
		// System.out.println("*******Decimal Test");
		// decimalTest("991009199");
		// System.out.println("*******char Test");
		// charTest("trrs");
		// nameTest("Mark Frank");
		creditCardTest("3121345678905432");
	}

}
