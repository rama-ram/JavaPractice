package com.practice.misc;

public class Fibo {

	static int n1 = 1, n2 = 1, result;

	public static int fibonacci(int n) {
		// Complete the function.

		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;

		result = n1 + n2;
		n1 = n2;
		n2 = result;
		fibonacci(n - 1);
		// System.out.println("result is ...." + result);
		return result;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		System.out.println(fibonacci(6));

		// Date data = new Date();
		// Calendar cal= Calendar.getInstance();
		// SimpleDateFormat format = new SimpleDateFormat("YYY-MM-DD");
		//
		//
		//
		//
		// System.out.println(format.format(data));
	}
}
