package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class SortStringTest {
	//Problem: Given a sorted list of words in an alien language, find the order of characters in lang
	
	static void getAplha(ArrayList<String > test){
		
		String alpha = "";
		for (String temp: test){
			char [] arr = temp.toCharArray();
			for (char ch: arr){
				if (alpha.indexOf(ch)==-1)
					alpha=alpha+ch;
			}
			
		}
		char []arr = alpha.toCharArray();
		 Arrays.sort(arr);
		 alpha = String.valueOf(arr);
		System.out.println("alphabets are.." + alpha);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("ab");
		list.add("bcde");
		list.add("ade");
		list.add("ghi");
		list.add("klmn");
		list.add("f");
		SortStringTest.getAplha(list);
	}

}
