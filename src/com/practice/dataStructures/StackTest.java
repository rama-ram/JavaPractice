package com.practice.dataStructures;

public class StackTest {
	static int  top=-1;
static  int size;
static int [] arr;
static void init(int a){
	arr = new int[a];
	size=a;
}
static void push(int a){
	if (top == size-1){
		System.out.println("stack overfloowing...");
		return;
	}
	arr[++top]=a;
	System.out.println("inserted element"+a);
}
static int peek(){
	if (top == -1){
		System.out.println("stack is empty...");
		return 0;
	}
	System.out.println("peeking top element"+arr[top]);
	return arr[top]; 
}

static int pop(){
	if (top == -1){
		System.out.println("stack is empty...");
		return 0;
	}
	System.out.println("popping top element"+arr[top]);
	return arr[top--]; 
}
static void reverse(){
	if(top>-1){
	int a = peek();
	pop();
	reverse();
	reversePush(a);
	}
	
}
static void reversePush(int a){
	if (top == size-1){
		System.out.println("stack overfloowing...");
		return;
	}
	if(top == -1){
		push(a);
	}
	int x = peek();
	pop();
	reversePush(a);
	push(x);
}
static void printStack(){
	if (top==-1)
		System.out.println("stack is empty...");
	for (int i=top;i>=0;i--)
		System.out.println("stack element is..." + arr[i]);
}
public static void main (String [] args){
	init(4);
	push(1);
	push(2);
	push(3);
	push(4);
	peek();
//	pop();
//	peek();
	printStack();
//	reverse();
	peek();
	printStack();
}
}
	

