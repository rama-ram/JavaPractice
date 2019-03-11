package com.practice.dataStructures.retake;

class Myll {
	LLNode root;

	Myll(int data) {
		if (root == null) {
			root = new LLNode(data);
			return;
		}
		addNode(data);

	}

	void addNode(int data) {
		LLNode temp = root;
		while (temp != null) {
			if (temp.next == null) {
				temp.next = new LLNode(data);
				return;
			}
			temp = temp.next;
		}
	}

	void removeNode(int data) {
		LLNode temp = root;
		if (root.value == data) {
			root = null;
			return;
		}
		while (temp != null) {
			if (temp.next.value == data) {
				temp.next = temp.next.next;
				return;
			}
			temp = temp.next;
		}
	}

	void getNode(int data) {
		LLNode temp = root;
		while (temp != null) {
			if (temp.value == data) {
				System.out.println("Node found in the LL");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Node not found inthe LL");
	}

	public String toString() {

		LLNode temp = root;
		String res = "";
		while (temp != null) {
			res = res + " " + temp.value;
			temp = temp.next;
		}
		return res;

	}
}

class LLNode {

	int value;
	LLNode next;

	LLNode(int data) {
		value = data;
		this.next = null;
	}
}

public class LinkedListRetake {

	public static void main(String[] args) {
		Myll ll = new Myll(10);
		ll.addNode(5);
		ll.addNode(100);
		ll.addNode(200);
		ll.addNode(30);
		System.out.println(ll);
		ll.removeNode(200);
		System.out.println(ll);
		ll.getNode(200);
		ll.getNode(5);
	}

}
