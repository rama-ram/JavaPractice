package com.practice.cmp.amzon;

public class LLAddition {

	Node root;

	void add(int value) {
		if (root == null) {
			root = new Node(value);
			return;
		}
		Node temp = root;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(value);
	}

	void addition(LLAddition l1, LLAddition ll2) {
	}

	public class Node {
		int data;
		Node next;

		Node(int value) {
			this.data = value;
			this.next = null;
		}

	}

	public static void main(String[] args) {
		LLAddition ll1 = new LLAddition();
		ll1.add(1);
		ll1.add(2);
		ll1.add(3);
		LLAddition ll2 = new LLAddition();
		ll2.add(9);
		ll2.add(8);
		ll2.add(7);

	}

}
