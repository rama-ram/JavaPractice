package com.practice.misc;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RemoveWhiteSpaceTest {
	//problem: Remove whitespaces in str
public static void removeWhiteSpaceTest(String test){
		
//	System.out.println("Cleaned String is." + test.replaceAll("\\s+", "")+"...");
//	char[] arr = test.toCharArray();
//	int size = arr.length -1;
//	for (int i=size;i>=0;i--)
//		System.out.print(arr[i]);
	char []arr = test.toCharArray();
	 Arrays.sort(arr);
	int size=arr.length-1;
	 for (int i=size;i>=0;i--)
			System.out.print(arr[i]);
		 char max,maxchar; int counter = 0, maxfreq=0, index = size;
		 

		 String temp = String.valueOf(arr);
		 maxchar=temp.charAt(index);
		 while (index>=0){
			 max=temp.charAt(index);
			 String sub = temp.substring(0, index);
			 int ind =temp.substring(0, index).indexOf(max); 
			 if (ind!=-1)
			 {
				 counter = (index - ind) +1; 
				 index =ind;
				 
				 if (counter > maxfreq){
					 maxfreq = counter;
				 maxchar = max;}
				 
				 
			 }
			 else index--;
			 
		 }
		 
		 System.out.println("max char is ..."+ maxchar);
	}


	static void removeWhiteSpaceTest1(String test){
		char[] arr = test.toCharArray();Arrays.sort(arr);String temp=String.valueOf(arr);
		 int size = test.length();int counter=0,max=0;
		char c = test.charAt(0),maxchar = c;
		
		char t='\0';
		
		while (size >1){
			c=temp.charAt(0);
			temp=temp.replace(String.valueOf(c),"");  
			counter = size - temp.length();
			if (counter >max){
				max = counter;
				maxchar = c;
			}
			
			size=temp.length();
		}
		System.out.println("max car is .." + maxchar);
		
	}
	public static void main(String args[] ){
		RemoveWhiteSpaceTest.removeWhiteSpaceTest1("zaraz");
//		Scanner s = new Scanner(System.in);
		
	}
}
