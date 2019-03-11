package com.practice.cmp.ntnx;

import java.util.ArrayList;
import java.util.List;

public class SumString {
	// Given a string determine whether it is a ‘sum-string’. A string is called
	// a sum-string if it satisfies the following properties:
	// len(s)>3
	// sub-string(i,x) + sub-string(x+1,j) = sub-string(j,l)
	// example:
	// “12358” is a sum string. Explanation : 1+2 = 3 ; 2+3 = 5 ; 3+5 = 8
	// “199100199” is a sum string. Explanation: 1+99 = 100 ; 99+100 = 199
	// “2368” is not a sum string.
	// Question 2:
	// Given 2 strings s1 and s2 determine whether s2 is a shuffle of s1. Where
	// shuffle is defined as an operation that switches 2 children of a node in
	// a binary tree.
	// Example:
	// s1 = great
	// s2 = taerg
	//
	// binary tree for s1
	// great
	// / \
	// gr eat
	// / \ / \
	// g r e at
	//
	// after shuffle we obtain,
	// great
	// / \
	// eat gr (shuffle gr and eat as they are children of great node)
	// / \ / \
	// at e r g
	// / \
	// t a
	//
	// Round 2:
	// I was asked to solve a Dynamic Programming problem. Given a string of
	// digits separated by operators ( + and *) only. Then parenthesize the
	// string in such a way that first we get the max value possible and then we
	// get the least value possible from the string. Return the difference of
	// the two values calculated. I had to solve this problem on a paper sheet
	// and explain the whole approach. I took 30 min to complete the code on
	// paper along with the explanation. Then the interviewer tested my code for
	// some simple cases : 2*2+2 => max is 2*(2+2) = 8 and min is (2*2)+2 = 6.
	// Then he asked me if I had any questions for him.
	// He was impressed by my solution and coding style, clean and neat with
	// comments and camel case of variables.
	// In total 6 students were shortlisted for the 3rd round including me.
	//
	//
	// Round 3:
	// Interviewer asked me to debug a code involving reader – writer locks. It
	// was an OS question, modified version of readers-writers problem. I
	// pointed out 5 problems with the code, syntactical and logical both. There
	// was a deadlock condition, write after write inconsistency, read after
	// write inconsistency, wrong if then else and a syntax error.
	//

	// Given the final score of a game of Sports, how many ways could you
	// arrange the order in which the points are scored such that you secure a
	// stress-free or stressful win?
	// Note – Output two integers – one each for stress-free and stressful
	// victory.
	//
	// Answer – http://codeforces.com/blog/entry/15881 (See solution of Winning
	// at sports).
	//
	//
	// Q-2. Given a sorted dictionary (array of words) of an alien language,
	// find order of characters in the language.
	//
	// Examples:
	//
	// Input: words[] = {"baa", "abcd", "abca", "cab", "cad"}
	// Output: Order of characters is 'b', 'd', 'a', 'c'
	// Note that words are sorted and in the given language "baa"
	// comes before "abcd", therefore 'b' is before 'a' in output.
	// Similarly we can find other orders.
	//
	// Input: words[] = {"caa", "aaa", "aab"}
	// Output: Order of characters is 'c', 'a', 'b
	//
	// Solution –
	// http://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
	//
	// 1. Given an array of integers and an integer X, find all subsets of the
	// array whose sum of elements is equal to the integer X.
	//
	// Solution – Recur for two cases – one including current element and other
	// excluding current element.
	//
	// 2. You have two integer arrays – WELL and DISC. Each integer of WELL
	// represents the maximum width of a disc that can pass through it in left
	// to right direction. Given a series of discs of varying width, find out
	// how many discs can be fit in the WELL until the WELL gets full.
	//
	// E..g. Say WELL array is {10, 8, 9, 5, 4, 1, 2} and DISC array is {1, 6,
	// 9, 5, 4, 11}
	//
	// The answer in this case is 3 –
	//
	// 1. disc 1 can pass through all elements in left to right direction.
	//
	// 2. disc 6 can pass through only 10, 8 and 9. Hence, it will fall at
	// position of width 9.
	//
	// 3. disc 9 can pass through only 10. Hence, it will fall at position of
	// width 10.
	//
	// Since the WELL is full at the topmost level, we cannot fit in anymore
	// discs. Hence, we stop and print the answer as 3.
	// Solution – Preprocess the WELL array to output the answer in O(m+n).
	//
	// Round 4 – F2F 2
	// This round had only one question. There was a variant of the classic
	// bounded buffer problem and we were asked to synchronize it.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arr = new ArrayList<String>();
		arr.add(new String("TEST"));
	}

}
