package com.practice.dataStructures.retake;

class MyStack {
	int cap;
	int size;
	int[] s;
	int tos;

	MyStack(int data) {
		cap = data;
		s = new int[cap];
	}

	void push(int data) {
		if (size >= cap) {
			System.out.println("Stack overflow!");
			return;
		}
		s[size++] = data;
	}

	int pop() {
		if (size == 0) {
			System.out.println("Stack Empty!");
			return -1;
		}
		int temp = s[cap - 1];
		for (int i = cap - 1; i < (cap - size); i--) {
			s[i] = s[i - 1];
		}
		size--;
		return temp;
	}

	public String toString() {
		String temp = "";
		for (int i = cap - 1; i < (cap - size); i--) {
			temp = temp + " " + s[i];
		}
		return temp;
	}

	public void peek() {
		System.out.println(s[cap - 1]);
	}

}

public class StackRetake {

	public static void main(String[] args) {
		MyStack stk = new MyStack(4);
		stk.pop();
		stk.push(20);
		stk.push(10);
		stk.push(30);
		stk.push(50);
		stk.push(60);// overflow condition
		System.out.println("Stack :" + stk);
		stk.peek();// wil show 50
		stk.pop();// removed 50
		System.out.println("Stack :" + stk);
		stk.peek();// will show 30
		stk.push(500);
		System.out.println("Stack :" + stk);
		stk.peek();// will show 500
	}

}
