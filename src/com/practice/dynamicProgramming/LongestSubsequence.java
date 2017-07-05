/**
 * 
 */
package com.practice.dynamicProgramming;

/**
 * @author ramaram
 *
 */
public class LongestSubsequence {

	/**
	 * @param args
	 */

	int longestss(char[] X, char[] Y, int n1, int n2) {

		if (n1 == 0 || n2 == 0)
			return 0;
		if (X[n1 - 1] == Y[n2 - 1])
			return 1 + longestss(X, Y, n1 - 1, n2 - 1);
		else
			return max(longestss(X, Y, n1, n2 - 1), longestss(X, Y, n1 - 1, n2));
	}

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static void main(String[] args) {
		/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
		{
			LongestSubsequence lcs = new LongestSubsequence();
			String s1 = "AGGTAB";
			String s2 = "GXTXAYB";

			char[] X = s1.toCharArray();
			char[] Y = s2.toCharArray();
			int m = X.length;
			int n = Y.length;

			System.out.println("Length of LCS is" + " " + lcs.longestss(X, Y, m, n));
		}

	}

}
