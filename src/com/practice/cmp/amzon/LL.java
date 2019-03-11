package com.practice.cmp.amzon;

import com.practice.dataStructures.LLreverse;

public class LL {
	// write algorithm for sum and multiply two linked list value
	// 1)Merging of two sorted arrays
	// 2)Parenthesis matching
	// Sort the digits of a number in efficient manner,
	// Given a linked list with N nodes, Reverse the list in a group of 'k'
	// nodes.
	// Polynomial addition using linked list
	// Convert BST to dll
	// Convert a binary tree into a doubly linked list
	// In a tree node, there is an extra pointer called random. Point random of
	// each node to the next node in that level, NULL if it is the right most
	// node.
	// Given a tree, make the left and right pointers such that it acts as a
	// doubly linked list in spiral level order. ?

	// Precisely, the first question was to Print the list of numbers in an
	// array fall beyond the average of the total numbers of the same array. And
	// generate the test cases assuming it is a black box.
	// (Intention here is to generate the exhaustive test cases)

	// And another question is Design and code An API takes following parameters
	// as input and inserts them into a relational database table. Of these
	// parameters, few of them are mandatory fields.
	// How would you implement your API?

	//
	// TestcaseId, TestCaseName, TestCase Description, TestCaseExecutionId,
	// TestCaseExecutionStatus, TestSteps, TestLabels, IsActive, IsAutomated,
	// TestPriority
	//
	// TestcaseId, TestCaseExecutionId and TestCaseExecutionStatus are mandatory
	// fields. How do you handle this?

	// 3. You are given two binary tree and write algorithm to check
	// Are two Binary…tree mirror image of other
	//

	// Take a integer as a input and replace all the '0' with '5'
	// For example:
	// 102 - 152
	// 1020 - 1525
	// (Do not use any array for replacing the '0' to '5')
	//

	// level-order-tree-traversal reversr level order traversal
	// Write a program to find a missing number in 100gb of numbers in constant
	// time

	// sort a given set of a deck of cards based on the card which you choose
	// randomly

	// EX: Input "AABC32DE4P%@23Pu" output should be 32+4+23 = 59

	// inorder traversal without recursion

	// common ancestor in a binary tree

	// merge 2 sorted LL

	// programming questions
	// 1) Given a number, find out how many times each digit is repeated in it.
	// 2) Given a number, sum its digits till the sum becomes a single digit.
	// eg. 12345-15-6
	// Optimize it to O(n) complexity.
	// 3) Given two roman numbers, sum them and print the sum in roman.
	// eg. X+IV=XIV
	//
	// test case
	// 1) list test cases for phone alarm system.
	//
	// process
	// 1) explain the steps that happen after a url is entered on the address
	// bar of a browser and enter is pressed.
	//
	// like wise in the face to face interview the algorithmic questions
	// difficulty level increases and even for the test cases and test
	// automation framework.Show Less
	//
	// Interview Questions
	//
	// Given that you are working for amazon, you want to know the response time
	// of amazon web page for each customer or user who opens it. By response
	// time i mean the moment the user enters the website url and presses enter
	// and till the web page opens, time interval between pressing enter and
	// received web page. How will you calculate the time interval for each user
	// or customer ?
	//

	LLreverse reverse(LLreverse root) {
		LLreverse.Node node = root.getHead();
		if (node == null)
			return null;

		LLreverse.Node temp = node, previous = null, next = null;
		while (temp != null) {
			next = temp.next;
			temp.next = previous;
			previous = temp;
			temp = next;
		}

		root.setHead(previous);
		return root;

	}

	void printLL(LLreverse root) {
		LLreverse.Node node = root.getHead();
		if (node == null)
			return;

		while (node != null) {
			System.out.println(" node value is " + node.data);
			node = node.next;
		}
	}

	public static void main(String[] args) {
		LL test = new LL();
		LLreverse ll = new LLreverse();
		ll.addLL(1);
		ll.addLL(2);
		ll.addLL(3);
		ll.addLL(4);
		ll.addLL(5);
		ll.addLL(6);
		System.out.println("before reverse ........");
		test.printLL(ll);

		ll = test.reverse(ll);
		System.out.println("after reverse ........");
		test.printLL(ll);
	}

}
