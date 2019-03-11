
public class FindPairSum {

	private static void findpairSum(int[] arr, int sum){
		
		for(int a = 1;a<arr.length;a++)
		{int temp = sum - arr[a] ;
			int start = arr[a+1];
			int end = arr[arr.length-1];
			int mid = arr[arr.length-1/2];
			if (temp == mid){
				
				System.out.println("this pair is valid " + temp + "/t" +arr[a] );return ;
			}
				
			while(start > end )
			{
				
			}
					}
		
	}
	
	
	public static void main (String args[]){
		
		findpairSum(new int[] {1,2,3,9},8);
		findpairSum(new int[] {1,2,4,4},8);
		
	}
}
