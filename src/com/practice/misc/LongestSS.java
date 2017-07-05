package com.practice.misc;

public class LongestSS {
	
	
	
static void lss(String a, String b){
	char[] arr;int counter=0;
	int size1=a.length();
	int size2=b.length();
	arr=new char[size2];
	if(size1>size2){
		
		int temp = 0;
		for (int i=0;i< size1;i++)
		{
			for (int j=temp;j<size2;j++){
				if(a.charAt(i)==b.charAt(j))
				{
					arr[counter]=a.charAt(i);
					temp=j+1;
					counter++;
					break;
				}
					
				}
			}
	}
	else{int temp = 0;
	for (int i=0;i< size2;i++)
	{
		for (int j=temp;j<size1;j++){
			if(b.charAt(i)==a.charAt(j))
			{
				arr[counter]=b.charAt(i);
				temp=j+1;
				counter++;
				break;
			}
				
			}
		}}
	System.out.println("the LSS s ..." + String.valueOf(arr));
	
}
	
	 public static void main(String args[]){
		 
		 lss("ABCDGH","AEDFHR");
		 lss("AGGTAB","GXTXAYB");
	 }

}
