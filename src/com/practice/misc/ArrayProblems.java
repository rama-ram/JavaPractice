package com.practice.misc;

public class ArrayProblems {
//In an array the sum of even numbers and odd numbers found in the array
	
	static void findOddSum(int[] arr){
		
		int sumOdd=0,sumEven=0;
		
		for (int a: arr)
		{
			if (a%2 ==0)
			{
				sumEven=sumEven+a;
			}
			else
			{
				sumOdd=sumOdd+a;
			}
			}
		
	System.out.println("Sum odd is .." + sumOdd + " and Sum even is .." + sumEven);
	}
	
	static void segmentedSieve(int n){
		
		boolean[] arr = new boolean[n+1];//init all value to true
		for (int i=1;i<=n;i++){
			arr[i]=true;
		}
		for (int i=2; i*i<= n ;i++){
			
			if(arr[i]){
				
				for (int j=i*2;j<=n;j=j+i){
					arr[j] = false;
				}
			}
			
		}
		for (int i=0;i<n;i++){
			if(arr[i])
				System.out.println("this is a prim no." + i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
//		findOddSum(arr);
		segmentedSieve(20);
	}

}
