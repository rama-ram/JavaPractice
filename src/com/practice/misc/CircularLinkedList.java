


public class CircularLinkedList {
Node head;

CircularLinkedList(Node a){
	
	head = a;
			
}
	
	
public static void  main (String args[]){
	LinkedList links = new LinkedList(new Node (9));
	
}
class Node{
	int value;
	Node next;
	
	Node(int a){
		value = a;
		next=head.next;
	}
	 public Integer getValue() {
         return value;
     }
     public void setValue(Integer value) {
         this.value = value;
     }
     public Node getNext() {
         return next;
     }
     public void setNext(Node next) {
         this.next = next;
     }
	
}
}


