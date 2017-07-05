package com.practice.sorting;

public class MergeSortedLinkedList {

	Node head = null;

	static class Node {
		int value;
		Node next;

		public Node(int data) {
			value = data;
		}
	}

	void push(int value) {
		if (head == null)
			head = new Node(value);
		else {
			Node current = head;
			while (current.next != null)
				current = current.next;
			current.next = new Node(value);
		}
	}

	public Node sort(Node h) {
		if (h == null || h.next == null)
			return h;
		Node mid = getMid(h);
		Node midNext = mid.next;

		mid.next = null;
		// sort left list
		Node left = sort(h);
		Node right = sort(midNext);
		Node sortedList = merge(left, right);
		return sortedList;
	}

	public Node getMid(Node h) {
		if (h == null)
			return h;
		Node slow = h;
		Node fast = h.next;
		while (fast != null && fast.next != null) {
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		return slow;
	}

	public Node merge(Node l, Node r) {
		Node result = null;
		/* Base cases */
		if (l == null)
			return r;
		if (r == null)
			return l;

		/* Pick either a or b, and recur */
		if (l.value <= r.value) {
			result = l;
			result.next = merge(l.next, r);
		} else {
			result = r;
			result.next = merge(l, r.next);
		}
		return result;
	}

	void print(Node h) {
		if (h == null)
			System.out.println("the LL is empty...nothing to print");
		else {
			Node current = h;
			while (current != null) {
				System.out.println("node is " + current.value);
				current = current.next;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortedLinkedList li = new MergeSortedLinkedList();
		/*
		 * Let us create a unsorted linked lists to test the functions Created
		 * lists shall be a: 2->3->20->5->10->15
		 */
		li.push(15);
		li.push(10);
		li.push(5);
		li.push(20);
		li.push(3);
		li.push(2);
		System.out.println("Linked List without sorting is :");
		li.print(li.head);

		// Apply merge Sort
		li.head = li.sort(li.head);
		System.out.print("\n Sorted Linked List is: \n");
		li.print(li.head);
	}
}
