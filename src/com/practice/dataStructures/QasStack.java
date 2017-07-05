package com.practice.dataStructures;
import java.util.Stack;

public class QasStack {
	
	protected Stack<Integer> S1, S2;
	int size;
	
	QasStack(){
		
		S1=new Stack<Integer>();
		S2=new Stack<Integer>();
	}
	
	void enqu(int a){
		
			S1.push(a);
			
		
	}
int deq(){
		
	while (!S1.isEmpty())
	{
		int b = S1.pop();
		S2.push(b);
		
	}
	int temp = S2.pop();
	
	while (!S2.isEmpty())
	{
		int x = S2.pop();
		S1.push(x);
		
	}
	return temp;
	}
int  peek(){
	
	while (!S1.isEmpty())
	{
		int b = S1.pop();
		S2.push(b);
		
	}
	int temp = S2.peek();
	
	while (!S2.isEmpty())
	{
		int x = S2.pop();
		S1.push(x);
		
	}
	System.out.println("peeked top of Q "+temp);
	return temp;
	}
	
void println(){
for (int i=0; i<=S1.size()-1;i++)
	System.out.println(S1.get(i));
}
	public static void main(String[]  args){
		QasStack qu = new QasStack();
		qu.enqu(1);
		qu.enqu(2);
		qu.enqu(3);
		qu.enqu(4);
		qu.enqu(5);
		qu.peek();
		qu.println();
		qu.deq();
		qu.peek();
		qu.println();
	}
	
}
