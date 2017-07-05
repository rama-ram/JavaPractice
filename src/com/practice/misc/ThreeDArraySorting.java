package com.practice.misc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThreeDArraySorting {
//Problem: List of tuples given, Sort by first, second and third columns successively
	
	public static void matching(String input1)
    {String result="";
		ArrayList<String> arr1= new ArrayList<String>();
		ArrayList<String> arr2= new ArrayList<String>();

		Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(input1);
	   while(m.find()) {
	       System.out.println(m.group(1));    
	       arr1.add(m.group(1));
	     }
	   arr2.add((input1.split("\\("))[0]);
	   Matcher m1 = Pattern.compile("\\)([^)]+)\\(").matcher(input1)  ;
		  while(m1.find()) {
		       System.out.println(m1.group(1));
		       arr2.add(m1.group(1));
		     }
		  for (String a: arr1)
			  System.out.println("arr1 .." + a);
		  for (String a: arr2)
			  System.out.println("arr2 .." + a);
		  for(int j=0;j<arr2.size();j++){
			  System.out.println("starting to find likeness for "+ arr2.get(j));
			  String likeness="";
		  //compare the product priority
			  String[] temp =  arr1.get(j).split(",");
			  for (String a: temp)
			  System.out.println("after split into second arr.." + a);
		  	
		  //find max among odd
			  int max=Integer.parseInt(temp[1]),maxindex=1;
			  if(temp.length>2){
			  for (int k=3;k<temp.length;k=k+2){
			  if (Integer.parseInt(temp[k])>max)
			  {
				  max=Integer.parseInt(temp[k]);
				  maxindex=k;
			  }
			  
			  }
			  
			  }
			  likeness=temp[maxindex-1];
			  System.out.println("the product liked by "+arr2.get(j)+" is .."+likeness);
			  System.out.println("Max value for this customer is" + max + "and max index is"+maxindex);
			  result=result+"("+arr2.get(j)+","+likeness+")";
		  }
		  System.out.println("the reslt is .."+ result);
		  }
		  
	public static void sortString(String[][]  arr){
		Arrays.sort(arr, new Comparator<String[]>(){

		    @Override
		    public int compare(final String[] second, final String[] first){
		        
		    	if (second[0].equalsIgnoreCase(first[0]))
		    	{
		    				if(second[1]==first[1])
		    					
		    					return second[2].compareTo(
		    						(first[2]) );
		    										
		    			else
		    				return (Integer.valueOf(second[1])-(
		    						Integer.valueOf(first[1])));

		    	}
		    	else 
		    	return second[0].compareTo(
		            (first[0]));
		    }
		});
		System.out.println(Arrays.deepToString(arr));		
	}
	
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
String[][]  arr ={  
					{"John","111","August"},
					{"john", "111", "Aug"},
					{"John","4","Feb"}
				};
//ThreeDArraySorting.sortString(arr);

String test ="AbcdE";
int size = test.length();
char [] ar = test.toCharArray(); 
for (int i=0;i < ar.length;i++){
if(Character.isUpperCase(ar[i])){
	ar[i]=Character.toLowerCase(ar[i]);
	if(test.charAt(i)!=test.charAt(size-1-i))
	{
		
	}
			}
	else
		ar[i]=Character.toUpperCase(ar[i]);	

}
System.out.println("the string is "+String.valueOf(ar));

//	
//		ThreeDArraySorting.matching("C1(P2,5,P4,3)C2(P1,4,P2,6)C3(P1,7,p3,5,P4,6)C4(P4,10,P5,5)C5(P4,9,P5,3)");
		
//		String example = "United Arab Emirates Dirham (AED)";
//	     Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(example);
//	     while(m.find()) {
//	       System.out.println(m.group(1));    
//	     }
	     
	}

}


//C1(P2,5,P4,3)C2(P1,4,P2,6)C3(P1,7,p3,5,P4,6)C4(P4,10,P5,5)C5(P4,9,P5,3)

//28(C1,P2)(C2,P1)(C3,P3)(C4,P5)(C5,P4)