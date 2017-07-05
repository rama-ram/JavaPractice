package com.practice.misc;
import java.util.ArrayList;

public class ArmsStrongNumbers {

	static void isArmStrong(int a){
		ArrayList <Integer> arr = new ArrayList();int power=0,sum=0;
		//split the no. and save to arr and find the power
		int temp = a;
		
		while(temp>0)
		{
			power++;
			arr.add(temp%10);
			temp=temp/10;
		}
		System.out.println("power is " + power);
		for(int b: arr)
			sum =sum+powerOf(b,power);
		if(a == sum)
			System.out.println("given no i"+a+"  s an armsrong no..");
		else
			System.out.println("given no is "+a+"  not an armsrong no..");
	}
	/* Function to calculate x raised to the
    power y */
 static int powerOf(int x, long y)
 {
     if( y == 0)
         return 1;
     if (y%2 == 0)
         return powerOf(x, y/2)*powerOf(x, y/2);
     return x*powerOf(x, y/2)*powerOf(x, y/2);
 }
	static void printArm(int a){
		
		
	}
	
	public static void main(String [] args){
		isArmStrong(123);
		isArmStrong(1634);
		isArmStrong(153);
	}
}
