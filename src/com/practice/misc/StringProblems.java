package com.practice.misc;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProblems {
//string split - done
	//regex match
	//use isupper and ten concatenate
	//there is a alpha numeric string Ex:1ABC34D768 the output shd be…  be… the output shd be… (1+34+768)
	
	static void removeAlpha1(String text){
		
		Pattern p = Pattern.compile("^[0-9]");
				Matcher m = p.matcher(text);
				System.out.println(Pattern.matches("^[0-9]", text));
		if(Pattern.matches("[A-Z]",text)){
			System.out.println("the matches are ..." + m.groupCount());
		}
		
	}
	
static void removeAlpha2(String text){
		String temp = new String("");
		String[] arr = text.split("[A-Z]");
		for(int i=0;i<arr.length;i++){
			System.out.println("array is .."+ arr[i]);
			if (!arr[i].isEmpty())
				temp=temp+arr[i]+"+"	;
		}
		System.out.println("final Text is ..("+temp.substring(0,temp.length()-1)+")");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeAlpha2("1ABC34D768");
	
//		removeAlpha1("1ABC34D768");
		}

}
