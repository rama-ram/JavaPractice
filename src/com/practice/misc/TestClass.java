package com.practice.misc;
import java.util.Scanner;

class TestClass {
    
    
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/
        //BufferedReader
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String line = br.readLine();
        // int N = Integer.parseInt(line);

        // //Scanner
        Scanner s = new Scanner(System.in);
        int iteration = s.nextInt();
        int[] arr = new int[iteration] ;
        for(int j=0;j<iteration;j++){
        arr[j]=       s.nextInt();
}
for(int j=0;j<iteration;j++){
        for (int i = 1; i <=arr[j]; i++) {
        if((i%3 ==0) && (i%5==0))
            System.out.println("FizzBuzz");
            else if (i%3 ==0)
                System.out.println("Fizz");
                else if (i%5 ==0)
                System.out.println("Buzz");
                else 
                System.out.println(i);
        }
        
}
        
    }
}
