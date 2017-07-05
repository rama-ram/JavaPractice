package com.practice.misc;

public class AccessControlTest {

	public void process(int i) {
		i = i + 2;
		System.out.println("I chaned the value of i to " + i);

	}

	public static void main(String[] args) {
		int i = 2;
		AccessControlTest a = new AccessControlTest();
		a.process(i);
		System.out.println("after test i" + i);
	}

}
