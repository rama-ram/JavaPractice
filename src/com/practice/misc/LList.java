import java.util.Stack;

public class LList {

	Node head=null;
	Stack<Node> stack = new Stack<Node>();
	
	public LList(int value){
	Node newNode =new Node(value); 
		if (head==null){
		head= newNode;
			}
	else{
		newNode.nextNode=head;
		head = newNode;
			
	}
		System.out.println("node " + value +" is added to the ll..");;
		System.out.println("ll head is  " + head.data +" ..");;
	}
	public void addNode( int value){
		
		Node newNode =new Node(value); 
		if (head==null){
		head= newNode;
			}
	else{
		newNode.nextNode=head;
		head = newNode;
		System.out.println("head is..."+head.data);
		System.out.println("head next is is..."+head.nextNode.data);
	}
		System.out.println("node " + value +" is added to the ll..");;
		System.out.println("ll head is  " + head.data +" ..");;
	}
	class Node{
		
		private int data;
		private Node nextNode;
		
		public Node(int data){
			
			this.data=data;
			this.nextNode=null;
		}
		
		
	}
	
	public void fetchNode(int value)
	{
		if (head == null)
			System.out.println("list is empty");
		else{
			Node temp = head;
		
			while(temp !=null){
			if(temp.data == value)
				{
				System.out.println("value found...");
				return;}
			temp=head.nextNode;
			
				}
			System.out.println("value not found...");
			return;
			}
			}
	
	public void reverse(){
		if (head == null)
				return;
		
		Node current=head,next=null,previous=null;
		while (current!=null)
		{//10--7--6--5
			next=current.nextNode;//7..6...5..null
			current.nextNode = previous;//null..10..7..6
			previous=current;//10..7..6..5
			current=next;//7..6..5..null
			
			System.out.println("revesed");
		}
		
		head=previous;
	}
	
	public void addNum(int a){
		if (head == null)
			return;
		Node temp=head;
		while((a+temp.data) >= 10){
			temp.data= 10 -(a+temp.data);
			a=1;
			temp=temp.nextNode;
			if (temp==null){
				temp=new Node(0);temp.nextNode=null;
				addNode(0);
				
			}
		}
		
		temp.data=(a+temp.data);
	}
	public void reverseRecurse(Node node){
		if (head == null)
				return;
		Node current=node,next=current.nextNode,previous=null;
		reverseRecurse(current.nextNode);
		
		
			current.nextNode = previous;
			previous=next;
			current=current.nextNode;
			
		
		
	}
	
	public void moveLastToFirst(){
		if (head == null)
			return;
		Node temp = head,previous=null;
		
		while ( temp.nextNode != null )
		{
//			System.out.println("traversed1..."+temp.data);
			previous = temp;
			temp = temp.nextNode;
//			System.out.println("traversed2..."+temp.data);
		}
		
			previous.nextNode=null;
			temp.nextNode=head;
		head=temp;
		
	}
public void pushToStack(){
		
		if (head == null)
				return;
		Node current = head;
		while (current!=null)
		{
			System.out.println("pushed data ..." +current.data );
			stack.push(current);
			current = current.nextNode;
			
		}
		
	}
public void isPali(){
	pushToStack();
	if (head == null)
		return;
Node current = head;int i=0;
while (current!=null && i <=stack.size()/2)
{
	System.out.println("data in LL data ..." +current.data );
	if (stack.pop().data!=current.data){
		System.out.println("not a palindrome");
		return;}
	current = current.nextNode;
	i++;
	
}
System.out.println("data in LL is a palindeom ...");
}
	public void pirntLL(){
		
		if (head == null)
				return;
		Node current = head;
		while (current!=null)
		{
			System.out.println("data is ..." +current.data );
			current = current.nextNode;
			
		}
		
	}
	public void removeDuplicatesInSorted(){
		
		if (head == null)
			return;
	Node current = head;
	while (current!=null && current.nextNode !=null)
	{
		if (current.data == current.nextNode.data){
			System.out.println("detected dupicate..." +current.data );
			current.nextNode=current.nextNode.nextNode;
		}
		
		else
			current = current.nextNode;
		
	}
		
	}
	
	public void removeDuplicatesInUnsorted(){
		
		if (head == null)
			return;
	Node current = head;
	while (current!=null && current.nextNode !=null)
	{
		if (current.data == current.nextNode.data){
			System.out.println("detected dupicate..." +current.data );
			current.nextNode=current.nextNode.nextNode;
		}
		
		else
			current = current.nextNode;
		
	}
		
	}
public void getIntersectionNode(LList ll1,LList ll2 ){
		
	
	Node current = ll1.head;
	
	//find ll length
	int ll1size=0,ll2size=0;;
	while (current!=null && current.nextNode !=null)
	{
		ll1size++;
		current=current.nextNode.nextNode;
	} current = ll2.head;
	while (current!=null && current.nextNode !=null)
	{
		ll2size++;
		current=current.nextNode.nextNode;
	}
	if (ll2size < ll1size)
	{System.out.println("smaller list is LL2...." + ll2size);
	current = ll1.head; Node ll2current=ll2.head;
	while(current!=null){
		while(ll2current!=null){
		if (current.data == ll2current.data){
			System.out.println("intersection found" + current.data);
			return;
		}
		System.out.println(ll2current.data);
		ll2current= ll2current.nextNode;
		}
		current= current.nextNode;
	}
	}
	else if (ll2size==ll1size)
		System.out.println("lists are of equal size" +ll2size );
	//to do 
	
	else
	{System.out.println("smaller list is LL1...." + ll1size);
	current = ll2.head; Node ll2current=ll1.head;
	while(current!=null){
		while(ll2current!=null){
		if (current.data == ll2current.data){
			System.out.println("intersection found" + current.data);
			return;
		}
		System.out.println(ll2current.data);
		ll2current= ll2current.nextNode;
		}
		current= current.nextNode;
	}
	}

		
	}
	
	public static void main (String arrges[])
	{
		LList ll = new LList(9);
		ll.addNode(2);
		ll.addNode(1);
		
		
//		ll.fetchNode(5);
		ll.pirntLL();
//		ll.isPali();
//		ll.reverse();
//		ll.pirntLL();
//		System.out.println("adding no. "+ 1 +" to the linked list");
//		ll.addNum(1);
//		ll.pirntLL();
//		ll.reverse();
//		ll.pirntLL();
//		ll.moveLastToFirst();
//		ll.moveLastToFirst();
//		ll.pirntLL();
//		
//		LList ll1 = new LList(11);
//		ll1.addNode(11);
//		ll1.addNode(11);
//		ll1.addNode(21);
//		ll1.addNode(43);
//		ll1.addNode(43);
//		ll1.addNode(60);
//		ll1.pirntLL();
//		ll1.removeDuplicatesInSorted();
//		ll1.pirntLL();
		

		LList ll1 = new LList(11);
		ll1.addNode(12);
		ll1.addNode(13);
		ll1.addNode(15);
		ll1.pirntLL();
		LList ll2 = new LList(10);
		ll2.addNode(15);
		ll2.addNode(9);
		ll2.pirntLL();
		ll1.getIntersectionNode(ll1,ll2);
		
	}
	
	}
	
	

