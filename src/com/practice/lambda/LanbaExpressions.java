package com.practice.lambda;

interface A {

	public void toDo(String txt);
}

public class LanbaExpressions {

	void method1(String txc, A a) {
		a.toDo(txc);

	}

	public static void main(String[] args) {

		A test = txt -> System.out.println("This is from Lamda 1 " + txt);
		A test1 = txt -> System.out.println("This is from lambda 2 " + txt);

		LanbaExpressions l = new LanbaExpressions();
		l.method1("SAMPLETEST1", test);
		l.method1("SAMPLETEST2", test1);

		PerformOperation isOdd = a -> a % 2 == 1;
		MyMath math = new MyMath();
		System.out.println("IS This ODD ? " + math.checker(isOdd, 3));

		PerformOperation isPalindrome = new PerformOperation() {
			@Override
			public boolean check(int a) {
				int size = 0;
				int temp = a;
				// find number length
				while (temp > 10) {
					size++;
					temp = temp / 10;
				}
				System.out.println(" THE NUMBER SIZE IS ***" + size);
				// move so many bits
				int result = 0;
				int temp1 = a;
				// int result = a >> size;
				while (size >= 0) {
					result = (int) (result + ((temp1 % 10) * Math.pow(10, size)));
					temp1 = temp1 / 10;
					size--;

				}
				System.out.println("the turned number is " + result);
				if (a == result)
					return true;
				else
					return false;
			}

		};
		System.out.println("IS This PALINDROME ? " + math.checker(isPalindrome, 1321));
		PerformOperation isPrime = new PerformOperation() {
			@Override
			public boolean check(int a) {
				for (int i = 2; i < a; i++) {
					if (a % i == 0)
						return false;
				}
				return true;
			}

		};
		System.out.println("IS This PRIME ? " + math.checker(isPrime, 13));
	}
}

interface PerformOperation {
	boolean check(int a);

	default String getName() {
		return null;
	};

}

class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

}