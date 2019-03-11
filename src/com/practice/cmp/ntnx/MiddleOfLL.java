package com.practice.cmp.ntnx;

import java.util.HashMap;

public class MiddleOfLL {
	static Node head;

	MiddleOfLL(int value) {
		head = new Node(value);
	}

	static class Node {
		Node next;
		int value;

		Node(int data) {
			value = data;
		}
	}

	static void addNode(int value) {
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(value);
	}

	static void getMiddle() {
		Node slow = head, speed = head;
		while (slow != null && speed != null && speed.next != null) {
			slow = slow.next;
			speed = speed.next.next;
		}
		System.out.println(" The middle Node is " + slow.value);

	}

	static void getLoop() {
		Node slow = head, speed = head;
		while (slow != null && speed != null && speed.next != null) {
			slow = slow.next;
			speed = speed.next.next;
			if (slow == speed) {
				System.out.println("Loop detected @ " + slow.value);
				return;
			}
		}
		System.out.println("There is no Loop detected ");
	}

	static void setNextNode(Node node1, Node node2) {
		node1.next = node2;

	}

	static Node getNode(int data) {
		Node current = head;
		while (current != null && current.value != data) {
			current = current.next;
		}
		return current;
	}

	public static void main(String[] args) {
		MiddleOfLL mll = new MiddleOfLL(1);
		mll.addNode(2);
		mll.addNode(3);
		mll.addNode(4);
		mll.addNode(5);
		mll.addNode(6);
		getMiddle();
		setNextNode(getNode(6), getNode(3));
		getLoop();

		HashMap<String, String> test = new HashMap<String, String>();
		test.put("1", "test1");
		test.put("2", "test2");
		test.put("3", "test3");

		for (String m : test.values()) {

		}

	}

}
