package com.practice.files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileProblems {
	// VMWares
	//// Find last 10 lines in a file in most optimized way. -- DONE
	// n prime no. -- DONE ...optimised way need to search --SEGMNTED SIEVE
	//// APPROACH..DONE
	// Find a loop in linked list and can go to any other element --- DONE
	// Circular linked list.---DONE
	//
	// Process block elements -- NO IDEA
	//// find middle element in a LL in one pass --DONE
	// there is a alpha numeric string Ex:1ABC34D768 the output shd be… be… the
	//// output shd be… (1+34+768) --DONE
	// In an array the sum of even numbers and odd numbers found in the array
	//// --DONE
	// Given BST, find the pairs whose sum is equal to given number--DONE
	// Binary Search -- DONE
	// Reverse the elements in stack-inplace. No extra memory should be used.
	//// --CANT DO IT
	// intersection of 2 LL -- DONE
	// delete tree -- DONE
	// armstrong numbers..within a given max no. or find if a number is an
	//// Armstrnig no.--DONE
	// Implement Q using stack --DONE
	// Reverse every k nodes in linked list --DONE
	// Longest Common Subsequence - NOT OPTIMISED..DONE
	// infix to postfix conversion-- NO IDEA

	// elevators design
	// quick sort,all sorts

	public static void findPrimes(int lastnumber) {

		System.out.println("the number is a prime" + 1);
		for (int i = 2; i <= lastnumber; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}

			}
			if (isPrime)
				System.out.println("the number is a prime" + i);
		}

	}

	public static void extractNLines(int lines, String filename) {
		File file = new File(filename);
		try {
			Scanner in = new Scanner(file);
			// Reader fin = new FileReader(file);
			// BufferedReader bufin = new BufferedReader(fin);
			int totalLines = 0;
			// in.useDelimiter("\\n");
			while (in.hasNext()) {
				in.nextLine();
				totalLines++;
			}

			System.out.println("the total number of lines in the file.." + totalLines);

			int temp = 0;
			in = new Scanner(file);
			while (temp < (totalLines - lines)) {
				in.nextLine();
				temp++;
			}
			while (in.hasNextLine()) {
				System.out.println("the lines in the file:" + in.nextLine());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// FileProblems.findPrimes(20);
		extractNLines(10, "D:/TestFile");

	}
}
