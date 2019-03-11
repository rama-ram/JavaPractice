package com.practice.dataStructures;

public class CircluarQueue {
	int[] arr;
	static int size;
	static int rear = -1;
	static int front = -1;

	CircluarQueue(int value) {
		size = value;
		arr = new int[size];
	}

	void insert(int value) {
		if (front == 0 && rear == (size - 1) || front == (rear + 1)) {
			System.out.println("the Q is full...cannot insert any more");
			return;
		} else if (front == -1) // first insert
		{
			front = rear = 0;
			arr[rear] = value;
		} else if (rear == (size - 1) && front != 0)
		// rear is at last place and front is not at first place
		{
			rear = 0;
			arr[rear] = value;
		} else {
			rear++;
			arr[rear] = value;
		}

	}

	int delete() {
		if (front == -1) {// nothing to delete;
			System.out.println("the Q is empty");
			return 0;
		}
		int value = arr[front];
		if (front == rear) {// there is only one element in Q

			front = rear = -1;
		} else if (front == (size - 1)) {
			front = 0;
		} else
			front++;

		return value;

	}

	public static void main(String[] args) {

	}

}
