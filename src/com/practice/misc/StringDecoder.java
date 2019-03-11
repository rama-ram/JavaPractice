import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDecoder {
	
	
	public static void stringDecoder(String word){
		String token = "WUB";
		String newword = word.replaceAll(token," ");
		String newword2 = newword.replaceAll("\\s+"," ");
		System.out.println("second method..........."+newword2.toString().trim());
			}
	public static int findIt(int[] A) {
		   Hashtable<Integer, Integer> map = new  Hashtable<Integer, Integer>();
		for (int i: A){
	 	    if (map.containsKey(i))
	 	    	map.put(Integer.valueOf(i),Integer.valueOf((map.get(i))+1));
	    for (int i=0;i<map.)
	    
	    
	  }
	}
	
	public static void main (String arges[]){
		
//		stringDecoder("WUBWEWUBAREWUBWUBTHEWUBCHAMPIONSWUBMYWUBFRIENDWUB");
//		System.out.println(calculateYears(1000,0.05,0.18,1100));
//		System.out.println(calculateYears(1000,0.01625,0.18,1200));
//		System.out.println(calculateYears(1000,0.05,0.18,1000));
//		sortPrimes(new int[] {1, 11, 5, 2, 3, 9, 22});
		System.out.println(getTickets(new int[] {100,25,25,25,25}));
	}
	public static int calculateYears(double principal, double interest,  double tax, double desired) {
	    // your code
	    int yearcounter=0;
	    if(desired == principal)
	    return 0;
	    else
	    
	    while (principal <desired )
	    {
	    double inter = (principal * interest) - ((principal * interest)*tax);
	    principal = principal + inter;
	    yearcounter++;
	    }
	    
	return yearcounter;
	}
	
	private static boolean isPrime(int a){
		for (int i=2;i<a/2;i++){
			if(a %2 ==0)
				return false;
		}
		return true;
	}
	private static void sortPrimes(int[] arr){
		ArrayList<Integer> list = new ArrayList<Integer> (); 
		for (int i : arr){
			if (i ==1 || i==2) {list.add(i) ; continue;}
			if (isPrime(i)){
				list.add(Integer.valueOf(i));
			}
			
		}
		System.out.println("the sorted set is:");
		Collections.sort(list);
		for (Integer i: list)
			System.out.print(i +"\t");
		
	}
	
	public static String getTickets(int[] peopleInLine)
	  {
	        //Your code is here...
	        int sum = 0;
	        if (peopleInLine[0]>25) return "NO"; else sum = peopleInLine[0];
	        for (int i=1;i< peopleInLine.length;i++)
	        {
	        if(peopleInLine[i]-25> sum)
	        return "NO";
	        else
	        sum=sum+peopleInLine[i]-(peopleInLine[i]-25);
	        }
	        return "YES";
	  }
	}



