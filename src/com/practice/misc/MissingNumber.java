import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

import java.util.Map.Entry;
import java.util.Stack;

public class MissingNumber {

	
	public static void findMissingNumber(int[] arr){
		int sum=0;int originalSum= arr[arr.length-1]*(arr[arr.length-1]+1)/2;
		System.out.println("original sum is..."+ originalSum);
		sum = Arrays.stream(arr).sum();
		System.out.println("missing no is..."+ (originalSum - sum));		
	}
	
	public static void reverseString(String word){
	char[] charrarr = word.toCharArray();
	Stack mystack= new Stack();
	
	for (char c : charrarr)
		mystack.push(c);
	System.out.println("reversed word is ..." );
	StringBuilder buff = new StringBuilder();
	for (int i=0;i< word.length();i++)
		buff.append(mystack.pop().toString());
	System.out.println(buff);
	
	}
	
    private static  void  findNthLongestElement(List<String> list, int n){
    	
    	Hashtable <Integer, ArrayList <String>> table1= new Hashtable<Integer, ArrayList<String>>();
    	
    	for (String word: list){
    		int wordlen=word.length()-1;
    		if(table1.containsKey(wordlen)){
    			ArrayList<String> temp = table1.get(wordlen); 
    		temp.add(word);
    			table1.put(wordlen,temp);
    		}
    		else {
    			ArrayList<String> temp = new ArrayList<String>(); 
        		temp.add(word);
        			table1.put(wordlen,temp);
    		}
    		
    	}int i=1;
    	for (Entry<Integer, ArrayList<String>> e: table1.entrySet()){
    		System.out.println("the length of the "+i+"th largest word and the word ..." + e.getKey()+"\t" + e.getValue());
    		i++;
    	}
//    	return table1.get( table1.descendingKeySet().toArray()[n-1] );
    }
    		
    private static void removeDuplicates(String word){
    	StringBuilder arr= new StringBuilder();
    	
    	
    	char[] chararr =  word.toLowerCase().toCharArray(); 
    	char temp = chararr[0];
    	arr = arr.append(chararr[0]);
    	for ( int i=1;i<=word.length()-1;i++){
    		while (chararr[i] != temp){
    			arr=arr.append(chararr[i]);
    			temp=chararr[i] ;
    		}
    		}
    		System.out.println("the converted ar is \t"+arr.toString());
    		//solved using regex
//    		  {
//    		        String input = "Good Oops, Bad Oops";
//    		        String output = input.replaceAll("(?i)(\\p{L})\\1", "$1");
//    		        System.out.println(output);
//    		    }
//    		  
    	}
    	
    private static  void distinctDuplicates(ArrayList<Integer> list){
    	HashSet<Integer>  set1 = new HashSet<Integer> ();
    	HashSet<Integer>  set2 = new HashSet<Integer> ();
    	
    	for (Integer a : list )
    	{
    		if(!set1.add(a))
    		set2.add(a);
    		
    	}
    	for (Integer i:set2)
    		System.out.println(i + "\t");
    }
    		
	public static void main(String ars[])
	{
//		findMissingNumber(new int[] {1,2,3,5});
//		reverseString("test this case");
		 int n = 0;
	        List<String> list = new ArrayList<String>();
	        list.add("Yuri");
	        list.add("Ron");
	        list.add("Interview");
	        list.add("Longest");
	        list.add("List");
	        list.add("Contain");
	        ArrayList<Integer> list1 = new ArrayList<Integer>();
	        list1.add(4);
	        list1.add(4);
	        list1.add(7);
	        list1.add(8);
	        list1.add(8);
	        list1.add(9);
//		findNthLongestElement(list, n) ;
//		removeDuplicates("Good Oops, Bad Oops");
		distinctDuplicates (list1);	
	}
	
}
