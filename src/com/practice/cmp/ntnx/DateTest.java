package com.practice.cmp.ntnx;

public class DateTest {

	static void timeTest() {
	}

	public static void main(String[] args) {
		int i = 3;
		while (i > 0) {
			long start = System.currentTimeMillis();
			System.out.println(start);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long end = System.currentTimeMillis();
			System.out.println(end);
			System.out.println((end - start) / 1000);
			i--;
		}
	}

}
