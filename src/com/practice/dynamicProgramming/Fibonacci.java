package com.practice.dynamicProgramming;

public class Fibonacci {
	static int[] arr = new int[100];

	static void init() {

		for (int i = 0; i < 100; i++)
			arr[i] = -1;
	}

	static void print() {

		for (int i : arr)
			System.out.println(i);
	}

	static int fib(int n) {
		if (arr[n] == -1) {
			if (n <= 1)
				arr[n] = n;
			else
				arr[n] = fib(n - 1) + fib(n - 2);
		}
		return arr[n];

	}

	public static void main(String[] args) {
		init();
		System.out.println(fib(6));
	}

}
