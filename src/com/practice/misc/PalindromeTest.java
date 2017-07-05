package com.practice.misc;

public class PalindromeTest {
	
	//problem: Given a string check whether it can be rearranged to form a palindrome or not
	static boolean  testPalindrome(String test){
		
		int size = test.length()-1;
		
		char[] arr = test.toCharArray();
		for (int i=0; i< size/2 ;i++)
		{
			if (arr[i] != arr[size-i])
				return false;
		}
		
		return true;
	}
	
public static void main(String args[] ){
	System.out.println("its a palindroam?" + PalindromeTest.testPalindrome("palindrome"));
	System.out.println("its a palindroam?" + PalindromeTest.testPalindrome("malayalam"));
}

}
