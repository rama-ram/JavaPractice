package com.practice.cmp.amzon;

public class Triangle {
	// Given sides of a triangle write a function which could say it is
	// equilateral , isosceles or scalene. Give Test data for the solution you
	// give

	void findTriangle(int a, int b, int c) {
		if (a == b && b == c)
			System.out.println("Equilateral");
		if (a != b || b != c || a != c)
			System.out.println("scalene");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
