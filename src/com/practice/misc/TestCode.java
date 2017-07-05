package com.practice.misc;

public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello World";  
		String one = s.substring(0,s.length()); 
		String two = s.substring(0,s.length()); 
		 
		if(one == two) System.out.println("Same object. In pool");
		else System.out.println("not the same object. new String() called. Two objects on heap");
	}
}



