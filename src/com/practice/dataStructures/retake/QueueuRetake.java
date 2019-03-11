package com.practice.dataStructures.retake;

class MyQu {
	int cap;
	int size;
	int top = 0;
	int[] q;

	MyQu(int cap) {
		this.cap = cap;
		q = new int[cap];
	}

	void enqu(int data) {

		if (size >= cap) {
			System.out.println("Qu overflow, cant insert!");
			return;
		}
		q[size++] = data;

	}

	int peek() {
		return q[top];

	}

	int deQ() {
		if (size == 0) {
			System.out.println("Qu empty, nothing to retrieve!");
			return -1;
		}
		size--;
		return q[top++];
	}

}

public class QueueuRetake {

	public static void main(String[] args) {
		MyQu qq = new MyQu(10);
		qq.deQ();
		qq.enqu(2);
		qq.enqu(10);
		qq.enqu(5);
		qq.enqu(6);
		qq.enqu(11);
		qq.enqu(12);
		System.out.println(qq.peek());
		System.out.println(qq.deQ());
		System.out.println(qq.peek());
		System.out.println(qq.deQ());
		System.out.println(qq.peek());
		System.out.println(qq.deQ());
		System.out.println(qq.deQ());
		System.out.println(qq.deQ());
		System.out.println(qq.deQ());
		System.out.println(qq.deQ());
	}

}
