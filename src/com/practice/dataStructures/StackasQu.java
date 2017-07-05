package com.practice.dataStructures;
import java.util.PriorityQueue;
import java.util.Queue;

public class StackasQu {

	
	protected Queue<Integer> Q1, Q2;
	
	StackasQu(){
		Q1 = new PriorityQueue<Integer>();
		Q2 = new PriorityQueue<Integer>();
			}
	
	void push(int a ){
		
		Q1.offer(a);
	}
	int peek(){
		while(!Q1.isEmpty()){
			int x = Q1.poll();
			Q2.offer(x);
			
		}
		int temp = Q2.element();
		while(!Q2.isEmpty()){
			int x = Q2.poll();
			Q1.offer(x);
			
		}
		System.out.println("the Queue element peeked is " + temp);
		return temp;
		}
	int pop(){
		while(!Q1.isEmpty()){
			int x = Q1.poll();
			Q2.offer(x);
			
		}
		int temp = Q2.poll();
		while(!Q2.isEmpty()){
			int x = Q2.poll();
			Q1.offer(x);
			
		}System.out.println("the Queue element popped is " + temp);
		return temp;
		}
	void println(){
		
		while(!Q1.isEmpty()){
			int x = Q1.poll();
			Q2.offer(x);
			System.out.println("the Queue element is " + x);
			
		}
		int temp = Q2.peek();
		while(!Q2.isEmpty()){
			int x = Q2.poll();
			Q1.offer(x);
			
		}
	}
	public static void main(String[] args) {
		StackasQu stk = new StackasQu();
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		stk.peek();
		stk.println();
		stk.pop();
		stk.peek();
		stk.println();
		
	}

}
