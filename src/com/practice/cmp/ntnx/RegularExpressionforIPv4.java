package com.practice.cmp.ntnx;

import java.util.regex.Pattern;

public class RegularExpressionforIPv4 {
	static void isIpv4(String ip) {
		try {
			String[] arr = ip.split("\\.");
			if (arr.length != 4) {
				System.out.println("invalid ipv4 format");
				return;
			}
			// check if all are less than or equal to 255
			for (String c : arr) {
				if (Integer.valueOf(c) <= 255) {
					continue;
				} else {
					System.out.println("invalid ipv4 format");
					return;
				}
			}
			System.out.println("VALID ipv4 format");
		} catch (NumberFormatException e) {
			System.out.println("invalid ipv4 format");
		}
	}

	static void isIpv4RegEx(String ip) {
		String s = "259.0.010.010";
		boolean test = s.matches(
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.[0-9]?[0-9]?[0-9]\\.[0-9]?[0-9]?[0-9]\\.[0-1]?[0-9]?[0-9]");

		// Pattern p =
		// Pattern.compile("(0-2)?(0-9)?(0-9)?\\.[0-2][0-9][0-9]\\.[0-2][0-9][0-9]\\.[0-2][0-9][0-9]");
		Pattern p = Pattern.compile("\\d+");
		System.out.println(p.matcher(ip));
		// Matcher match = ip.matcher(p);
		boolean res = ip.matches("(0-2)?(0-9)?(0-9)?\\.[0-2][0-9][0-9]\\.[0-2][0-9][0-9]\\.[0-2][0-9][0-9]");

	}

	public static void main(String[] args) {
		isIpv4RegEx("192.168.1.1");
		isIpv4("192.168.1.1");
		isIpv4("255.255.255.0");
		isIpv4("test affress");
	}

}
