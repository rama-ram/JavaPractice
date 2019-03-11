package com.practice.dataStructures;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<T>> {

	private ArrayList<T> items;

	public MinHeap() {
		items = new ArrayList<T>();
	}

	public void insert(T item) {
		items.add(item);
		siftUp();

	}

	public void siftUp() {
		int size = items.size() - 1;
		while (size > 0) {
			int parent = (size - 1) / 2;
			T temp = items.get(size);
			if (items.get(parent).compareTo(temp) > 0) {
				// swap
				items.set(size, items.get(parent));
				items.set(parent, temp);
				size = parent;

			} else {
				break;
			}
		}
	}

	public void siftDown() {
		int k = 0;
		int l = 2 * k + 1;

		while (l < items.size()) {
			int min = l, r = l + 1;
			if (r < items.size()) {
				if (items.get(r).compareTo(items.get(l)) < 0) {
					min++;
				}
			}
			if (items.get(min).compareTo(items.get(k)) < 0) {
				// swap
				T temp = items.get(min);
				T temp2 = items.get(k);
				items.set(min, temp2);
				items.set(k, temp);
				k = min;
				l = 2 * k + 1;
			} else {
				break;
			}
		}
	}

	public T delete() throws NoSuchElementException {
		if (items.size() == 0) {
			throw new NoSuchElementException();
		}
		if (items.size() == 1) {
			return items.remove(0);
		}
		T hold = items.get(0);
		items.set(0, items.remove(items.size() - 1));
		siftDown();
		return hold;
	}

	public String toString() {
		return items.toString();
	}

	public static void main(String[] args) {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		heap.insert(5);
		heap.insert(6);
		heap.insert(2);
		heap.insert(1);
		heap.insert(-8);
		heap.delete();
		System.out.println("The heap is:  " + heap.items.toString());

	}

}
