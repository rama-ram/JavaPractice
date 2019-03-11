import java.util.Arrays;

public class RearrangeOddEven {

	
	public void arrangeArr(int[]arr){
		int [] even = new int[arr.length];
		int [] odd = new int[arr.length];
		int [] result = new int[arr.length];
		for (int i=0,j=0,k=0;i<arr.length;i++)
		{
			if(arr[i]%2 ==0)
			{
				System.out.println("this is even......"+arr[i]);
				even[j]=arr[i];
				j++;
			}
			else{
				System.out.println("this is odd......."+arr[i]);
				odd[k]=arr[i];
				k++;
			}
			
		}
		System.out.println("the sorted array");
		for (int  i: even)
			System.out.print(i+"\t");
		System.out.println("the sorted array");
		for (int  i: odd )
			System.out.print(i+"\t");
		System.out.println("the sorted array");
		
		for (int i=0,j=0,k=0;i<arr.length;i++)
		{
		if (i%2 == 0){
			result[i]=odd[j];
			j++;
		}
		else 
		{	result[i]=even[k];
		k++;}
		}
//		Arrays.sort(result);
		for (int  i: result)
			System.out.print(i+"\t");
		
	}
	
	public void diffarr(int k, int[] arr){
		
		for (int i=0;i<arr.length;i++){
			for (int j=0;j<arr.length;j++)
			{
			if(arr[j]-arr[i]==k)
				System.out.println("the numbers are "+ arr[i] +","+arr[j]+ "\t");
			}
		}
		
		
	}
	public void removeDuplicates(int[] arr){
		int result[]=new int[arr.length];
		int temp=arr[0],newarrcount=0;
		for(int i : arr){
			result[newarrcount]=temp;
			if (i!=temp){
				
				newarrcount++;
				temp=i;
			}
		
		}
		for (int i : result)
			System.out.print("\t"+i);
		
		
	}
	public static void main (String args[]){
		
//		int [] arr = {2,1,3,4,7,9,24,98};
//		new RearrangeOddEven().arrangeArr(arr);
		//[2,1,3,4,7,9,24,98]
		//1,2,3,4,7,24,9,98
//		Input :  [1, 4, 3, 5, 7, 6, 5, 9, 11, 8]
//		Number of pairs whose difference is 3 = 7
//		[(1, 4), (4, 7), (3, 6), (5, 8), (6, 9), (5, 8), (8, 11)]
		
//		new RearrangeOddEven().diffarr(3,new int[]{1, 4, 3, 5, 7, 6, 5, 9, 11, 8});
//		new RearrangeOddEven().removeDuplicates(new int[] {1,1,1,1,1,1,2,2,2,2,2,3,3,3,4,4,4,5,6,7,8,8,8,8});
		//Result : [1,2,3,4,5,6,7,8] ((E)
//		4. Given the number in binary form. Find if it is prime or not.
//		Example : 1001
//		Answer : Value is 7 which is prime number (E)
		findprime();
		
	}
}
