package com.practice.dataStructures.retake;

class CQ {

	int cap;
	int size;
	int top = 0, bottom = -1;
	int[] q;

	CQ(int cap) {
		this.cap = cap;
		q = new int[cap];
	}

	void enqu(int data) {
		System.out.println("Size is " + size);
		if (size >= cap && bottom == -1) {
			System.out.println("Qu overflow, cant insert!");
			return;
		}
		if (bottom != -1)
			bottom--;
		size++;
		q[(top + size - 1) % cap] = data;

	}

	int peek() {
		return q[top];

	}

	int deQ() {
		System.out.println("DQSize is " + size);
		if (size == 0) {
			System.out.println("Qu empty, nothing to retrieve!");
			return -1;
		}
		size--;
		bottom++;
		int temp = q[top];
		if (top < cap - 1)
			top++;
		else
			top = cap - top + 1;
		return temp;
	}

}

public class CircularQRetake {

	public static void main(String[] args) {

		CQ cq = new CQ(4);
		cq.enqu(1);
		System.out.println("Peek(): " + cq.peek());
		cq.enqu(2);
		System.out.println("Peek(): " + cq.peek());
		cq.enqu(3);
		System.out.println("Peek(): " + cq.peek());
		cq.enqu(4);
		System.out.println("Peek(): " + cq.peek());
		cq.enqu(5);
		// System.out.println("Peek(): " + cq.peek());
		cq.deQ();
		System.out.println("Peek(): " + cq.peek());
		cq.deQ();
		System.out.println("Peek(): " + cq.peek());
		cq.enqu(5);
		System.out.println("Peek(): " + cq.peek());
		cq.enqu(50);
		System.out.println("Peek(): " + cq.peek());
		cq.enqu(60);
		System.out.println("Peek(): " + cq.peek());
		cq.deQ();
		cq.enqu(60);
		System.out.println("Peek(): " + cq.peek());
	}

}
