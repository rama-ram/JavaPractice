package com.practice.cmp.ntnx;

public class SplitNumbersTest {

	// given a number 3 , print 1+1+1, 1+2, 2+1

	static void splitter(int number) {
		int temp = number - 1;
		StringBuilder word = new StringBuilder(String.valueOf(temp));
		while (temp > 1) {
			word = word.append("+").append(--temp);
		}
		System.out.println(word);

	}

	public static void main(String[] args) {
		splitter(3);
	}

}
