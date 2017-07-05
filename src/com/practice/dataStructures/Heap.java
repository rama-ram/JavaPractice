package com.practice.dataStructures;

public class Heap {

	int size;
	int capacity;
	int[] arr;
	static final int INT_MIN = -1;
	static final int INT_MAX = 100;

	// constructor
	Heap(int value) {
		capacity = value;
		arr = new int[capacity];
	}

	void insertKey(int i) {

		if (size == capacity) {
			System.out.println("head overflow..");
			return;
		}
		size++;
		int temp = size - 1;
		arr[temp] = i;

		// Fix the min heap property if it is violated
		while (temp != 0 && arr[parent(temp)] > arr[temp]) {
			swap(arr[temp], arr[parent(temp)]);
			temp = parent(temp);

		}
	}

	// A utility function to swap two elements
	void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}

	void deleteKey(int i) {
		decreaseKey(i, INT_MIN);
		extractMin();
	}

	void decreaseKey(int i, int new_val) {
		arr[i] = new_val;
		while (i != 0 && arr[parent(i)] > arr[i]) {
			swap(arr[i], arr[parent(i)]);
			i = parent(i);
		}
	}

	int parent(int i) {
		return (i - 1) / 2;
	}

	int left(int i) {
		return (2 * i + 1);
	}

	int right(int i) {
		return (2 * i + 2);
	}

	int extractMin() {
		if (size <= 0)
			return INT_MAX;
		if (size == 1) {
			size--;
			return arr[0];
		}

		// Store the minimum value, and remove it from heap
		int root = arr[0];
		arr[0] = arr[size - 1];
		size--;
		minHeapify(0);

		return root;
	}

	int getMin() {
		return arr[0];
	}

	void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if (l < size && arr[l] < arr[i])
			smallest = l;
		if (r < size && arr[r] < arr[smallest])
			smallest = r;
		if (smallest != i) {
			swap(arr[i], arr[smallest]);
			minHeapify(smallest);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap h = new Heap(11);
		h.insertKey(3);
		h.insertKey(2);
		h.deleteKey(1);
		h.insertKey(15);
		h.insertKey(5);
		h.insertKey(4);
		h.insertKey(45);
		System.out.println("the extracted min is" + h.extractMin());
		System.out.println("the min in the head is" + h.getMin());
		h.decreaseKey(2, 1);
		System.out.println("the min in the head is" + h.getMin());
	}

}
