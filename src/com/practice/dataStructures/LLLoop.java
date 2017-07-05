package com.practice.dataStructures;

public class LLLoop {

	Node head=null;
	
	LLLoop(int value){
head = new Node(value);
System.out.println("added head Node " + value);
	}
	
	public void addCircular(int value){
		head.addCircularNode(value);
		System.out.println("added Node .."+ value);
		
	}
	public void add(int value){
	head.addNode(value);
	System.out.println("added Node .."+ value);
	}
	
	static void intersection(LLLoop l1, LLLoop l2){
		
		Node temp = l1.head;
		
		while (temp!=null){
			temp.isVisited=true;
			System.out.println("visited node..." + temp.value);
			temp =temp.next;
			
		}
		System.out.println("reached end of LL1");
		temp = l2.head;
		while(temp!=null){
			if(temp.isVisited){
				System.out.println("found the interssectin point..." + temp.value);
				return;
			}
			
			temp=temp.next;
		}
	}
	public void fetch(int value){
		if (head == null){
			System.out.println("The list is empty");
			return;
			}
		if (head.value==value)
		{
			System.out.println("foudn the Node.." + head.value);
		}
		Node temp = head.next;
		while(temp != null && temp.value != value){
			System.out.println("examining  Node.."+ temp.value);
			if(temp ==head || temp.next == null)
			{
				System.out.println("Node not found");
				return;
			}
				temp = temp.next;
		}
		System.out.println("fetched Node.."+ temp.value);
		
		
	}
	public void reverse(){
		
		if(head == null){
			System.out.println("the list is empty");
			return;
		}
		Node node = head,next=null,previous=null;
		while(node.next !=null){
			next=node.next;
			node.next=previous;
			previous=node;
			node=next;
		}
		node.next=previous;
		head=node;
		System.out.println("reverselist complete");
	}
	public void subReverse(int a){
		reverse(head,a);
	}
public Node reverse(Node node,int k){
		
		Node next=null,previous=null;
		int count=0;
		 System.out.println("node value is ..."+node.value);
		while(k > count && node!=null){
			next=node.next;
			node.next=previous;
			previous=node;
			node=next;
			count++;
		}
		
		if (next != null) 
	          node.next = reverse(next, k);
		return previous;
		}

	public void findMiddle(){
		Node turtle=head,hare=head.next.next;
		while(hare!=null){
			if(hare.next== null)
			{
				System.out.println("middle element  detected.." + turtle.next.value);
				return;
			}
			System.out.println("turtle is.." + turtle.value);
			System.out.println("hare is .." + hare.value);
			turtle=turtle.next;
			hare= hare.next.next;
			
		}
		System.out.println("LL is not symmetrical ....");
	}
	
	public void printll(){
		Node temp = head;
		if (head==null)
			System.out.println("LL is empty");
		else{
			while(temp!=null){
				System.out.println("node is "+ temp.value);
				temp=temp.next;
	}
	
	}
	}
	public void printllCircular(){
		Node temp = head;
		if (head==null)
			System.out.println("LL is empty");
		else{
			while(temp!=null){
				
				System.out.println("node is "+ temp.value);
				temp=temp.next;
				if(temp ==head){
					System.out.println("reached the beginning of the LL "+ temp.value);	
					break;
	}}
	
	}
	}
	
	public void findLoop(){
		Node turtle=head,hare=head.next.next;
		while(turtle != null && hare!=null && hare.next!=null && hare.next.next!=null){
			if(turtle == hare)
			{
				System.out.println("loop detected.." + turtle.next.value);
				return;
			}
			System.out.println("turtle is.." + turtle.value);
			System.out.println("hare is .." + hare.value);
			turtle=turtle.next;
			hare= hare.next.next;
			
		}
		System.out.println("No loop detected...");
		
	}
	public class Node{
		Node next;	
		int value;
		boolean isVisited=false;
		Node(int data){
			this.value=data;
			this.next=null;
		}
		public void addNode(int value){
			
			Node temp = head;
			if (head==null)
				head = new Node(value);
			else{
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=new Node(value);
		}
		}
		
public void addCircularNode(int value){
			
			Node temp = head;
			if (head==null)
				head = new Node(value);
			else{
		while(temp.next!=null && temp.next !=head){
			temp=temp.next;
		}
		temp.next=new Node(value);
					}
			temp.next.next=head;
		}
public void reverse(){
	
}


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LLLoop ll = new LLLoop(5);
		ll.add(4);
		ll.add(3);
		ll.add(2);
		ll.add(1);
		ll.add(0);
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.printll();
		ll.head=ll.reverse(ll.head, 3);
		ll.printll();
		//		LLLoop l2 = new LLLoop(90);
//		l2.add(40);
//		l2.add(60);
//		l2.add(1);
//		l2.add(0);
//		l2.add(10);
		
		
//		ll.addCircular(10);
//		ll.addCircular(20);
//		ll.printllCircular();
//		ll.findLoop();
//		ll.fetch(20);
//		ll.findMiddle();
//		ll.reverse();
//		ll.printll();
//		ll.subReverse(3);
//		ll.printll();
//		intersection(ll,l2);
		
	}

}
