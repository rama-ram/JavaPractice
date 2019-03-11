import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixDiagonal {

	public static void findarrsum(int size, int[][] arr){
		
		 int primsum=0, secsum=0;
		 
		 for (int i=0;i<size;i++){
			 for (int j=0;j<size;j++)
			 {if(i==j)
				 primsum=primsum+arr[i][j];
			 if (j==size-1-i)
				 secsum=secsum+arr[i][j];
			 }
		 }
		 System.out.println("sec sum is.." + secsum +"primsum..........."+ primsum);
		 System.out.println(Math.abs(primsum-secsum));
	}
	static void getnewFormat(String oldformat)
    {StringBuilder build = new StringBuilder();int size = oldformat.length();
        if (oldformat.contains("PM")){
        String[] token = oldformat.split(":"); System.out.println("toekn array is .."+ token.length);
        token[2]=token[2].replace("PM","");
        if (Integer.parseInt(token[0])==12)
        	token[0]="12";
        else
        	token[0]=String.valueOf(Integer.parseInt(token[0])+12);            
        System.out.println(token[0]+":"+token[1]+":"+token[2]);
      }
else{
	if(oldformat.substring(0, 1).contains("12"))
//		oldformat.
	System.out.println(oldformat.replace("AM",""));
 
}
    }
    static void printstairs(int size){
        for(int i=1;i<=size;i++){
        int spacecount=i,hashcount=size-i;
        while(spacecount<size){
            System.out.print(" ");
            spacecount++;
        }
        while(hashcount<size)
        {System.out.print("#");
         hashcount++;
        }
            System.out.println();
    }
    }
    static void printstairs1(int size){
        for(int i=1;i<=size;i++){
        StringWriter st = new StringWriter(size);
        System.out.println(st.append(" ", 0, size-1-i).toString());
//        		+st.append("#",size-1-i, size-1).toString());
            System.out.println();
    }
    }
    static int fact(int i){
    	int result = 1;
    	if (i==1 || i==0)
    		return 1;
    	if (i>=1)
    		result = i*fact(i-1);
    	return result;
    	
    }
    static void removeduls(char [] arr){
    	int counter=0;char[] char1=new char[arr.length];
    	char1[0] = arr[0];System.out.print(char1[counter]);
    	for (int i=1;i<arr.length;i++){
    		if (char1[counter] != arr[i])
    			{ char1[++counter]= arr[i];
    			System.out.print(char1[counter]);
    			
    			}
    			}
    	
    	}
    static void removeduls1(char [] arr){
    	int counter=0;
    	System.out.print(arr[counter]);
    	for (int i=1;i<arr.length;i++){
    		if (arr[counter] != arr[i])
    			{ arr[++counter]= arr[i];
    			System.out.print(arr[counter]);
    			
    			}
    			}
    	
    	}	
    
  private static  void findAnts(String word){
    	if( word.isEmpty()){
    	System.out.println("no ants died ");return;}
    	Pattern p =  Pattern.compile(word);
    	Matcher m = p.matcher("a");
    	String [] arr=    	word.split("a");
    	System.out.println("array size is "+ arr.length) ;
    	String [] arr1=    word.split("ant");
    	System.out.println("array size is "+ arr1.length) ;
    	System.out.println("dead ants are "+( arr.length - arr1.length) );
    }
	public static void main (String[] args){
//		 int size = 3;int[] [] arr ={{11,2,4},{4,5,6},{10,8,-12}};
//		 String.valueOf(Integer.parseInt("word"));
////		 findarrsum(size,arr);
//		
//		 getnewFormat("07:05:45PM");
//		findAnts("ant anantt aantnt");
//		findAnts("ant ant .... a nt");
//		findAnts("ant ant ant ant");
//		findAnts("");
//		
//		System.out.println(fact(5));
//		printstairs1(6);
		removeduls1("addffvff".toCharArray());
	}
}
