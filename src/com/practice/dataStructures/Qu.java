package com.practice.dataStructures;

public class Qu {
	int qsize;
	int capacity = 100;
	int index;
	int[] arr;
	int head = 0;

	public Qu(int size) {
		qsize = size;
		if (qsize >= capacity) {
			System.out.println("Queue is overloaded");
			return;
		}
		arr = new int[qsize];
	}

	void enqu(int value) {

		if (index >= qsize) {
			System.out.println("Queue is overloaded");
			return;
		}
		arr[index] = value;
		index++;
		System.out.println("value added to the Queue..." + value);
	}

	int front() {
		System.out.println("he head is now at.." + arr[head]);
		return arr[head];
	}

	void dq() {

		System.out.println("value renoved from the Queue.." + arr[head]);
		head++;
		qsize--;
	}

	void capacity() {
		System.out.println("the Q capacity is " + qsize);
	}

	public static void main(String[] args) {

		Qu stk = new Qu(10);
		stk.enqu(1);
		stk.enqu(2);
		stk.enqu(3);
		stk.enqu(4);
		stk.capacity();
		stk.front();
		stk.dq();
		stk.capacity();
		stk.front();

	}

}