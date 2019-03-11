package com.practice.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTests {

	static void numberTest(String text) {
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(text);
		while (m.find()) {
			System.out.println("Found a decimal .. " + m.group() + m.start());
		}
	}

	public static void main(String[] args) {

		String x = "12";
		System.out.println(x.substring(0, x.length() - 1));
		;
	}

}
