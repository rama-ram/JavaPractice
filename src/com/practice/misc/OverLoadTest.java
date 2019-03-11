package com.practice.misc;

public class OverLoadTest {
	static void print(String msg) {
		System.out.println(msg);
	}

	static void print(String msg, int i) {
		while (i != 0) {
			System.out.println(msg);
			i--;
		}
	}

	static int print(String msg, int i, boolean flag) {
		System.out.println(msg);
		if (flag)
			return i;
		return 0;
	}

	public static void main(String args[]) {
		print("This is a test message");
		print("This is a test message with i", 2);
		System.out.println("printed the message ," + print("This is a test message ", 2, true) + " number of times");

	}
}
