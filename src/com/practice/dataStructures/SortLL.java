package com.practice.dataStructures;

//RECHECK,..NOT WORKING AS EXPECTED
public class SortLL {
	// Given a linked list which is sorted, how will you insert in sorted way
	Node head;

	void insert(int value) {

		if (head == null) {
			head = new Node(value);
			System.out.println("Head node inserted" + head.value);
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(value);
	}

	void insertSort(int value) {

		if (head == null) {
			head = new Node(value);
			System.out.println("Head node inserted" + head.value);
			return;
		}

		Node current = head;
		while (current.next != null && current.next.value < value) {
			current = current.next;
		}
		Node temp = new Node(value);
		temp.next = current.next;
		current.next = temp;
		System.out.println("node inserted" + current.value);
	}

	void print() {

		if (head == null) {
			return;
		}
		Node current = head;
		while (current != null) {
			System.out.println("current node is .." + current.value);
			current = current.next;
		}
	}

	static class Node {

		Node next;
		int value;

		Node(int data) {
			next = null;
			value = data;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortLL llist = new SortLL();
		llist.insertSort(5);
		llist.insertSort(10);
		llist.insertSort(7);
		llist.insertSort(3);
		llist.insertSort(1);
		llist.insertSort(9);

		System.out.println("Created Linked List");
		llist.print();
	}

}
