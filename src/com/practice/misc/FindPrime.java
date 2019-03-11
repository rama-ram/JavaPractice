package com.practice.misc;

public class FindPrime {

	static void isPrime(int[] arr) {
		for (int c : arr) {
			boolean isPrime = true;
			if (c <= 0 || c == 1) {
				System.out.println("Not prime");
				isPrime = false;
				continue;
			}

			for (int i = 2; i <= (int) (Math.sqrt(c)); i++) {
				if (c % i == 0 && c != i) {
					System.out.println("Not prime");
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println("Prime");
			}

		}
	}

	public static void main(String[] args) {
		isPrime(new int[] { 1, 2, 0, 3, 4, 3057601, 289, -8, -17, 5, 7 });
	}
	// public static void main(String[] args) {
	// Scanner in = new Scanner(System.in);
	// int p = in.nextInt();
	// int [] arr;
	// for(int a0 = 0; a0 < p; a0++){
	// int arr[a0] = in.nextInt();
	// }
	// isPrime(arr);
	// }
}
