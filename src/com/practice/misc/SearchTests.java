package com.practice.misc;

public class SearchTests {

	static void binSearch(int[] arr, int key){
		
		int start =0 , middle = (arr.length-1)/2,end = arr.length-1;
		while(end >start){
		if(arr[middle]==key || arr[start]==key || arr[end]==key){
			System.out.println("number s in the list...");
			return;
		}
		
		if(key>arr[middle]){
			start = middle+1;
			middle=(end-start)/2;
			end = end -1;
					
			
		}
		else{
			end = middle-1;
			middle=(end-start)/2;
			start=start+1;
		}
		}
		System.out.println("number s not in the list..");
	}
	
	
	
	public static void main(String[]  args){
	int [] arr = {1,2,3,4,5,6,7,8};	
	binSearch(arr,30);
	}
}
