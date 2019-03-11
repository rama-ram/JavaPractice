	class Node {

        int data;
        Node next;
        Node (int value){
        	data = value;
	
}	}
class Linked{
	Node head;
	
Linked(Node node){
head = node;
head.next=null;
}	
boolean hasCycle(Node head) {
    if(head == null)
        return false;
    else{
        Node temp = head ;
        while (head.next != null) {
            if(head.next != temp)
                head = head.next;
            else
                return true;
        }
    }
return false;
}
public void insertNode(Node node){
	if (head != null) {
		Node temp = head;
	head = node;
	head.next = temp;
	}
}	public void traverse(){
	Node temp = head;
	while (temp != null)
					{
		System.out.println(temp.data);
					temp = temp.next;
				
				}
			}
public void insertcircular(Node node){
	if (head != null) {
		Node temp = head, parent = null;
	head = node;
	head.next = temp;
	while (temp != null)
					{
		System.out.println(temp.data);
		parent = temp;			
		temp = temp.next;
				
				}
	parent.next=head;
	
	}
}
	public static void main(String args[]){
	
	Linked link = new Linked(new Node(1));
	link.insertNode(new Node(4));
	link.insertNode(new Node(10));
	link.insertNode(new Node(90));
	link.traverse();
	link.insertcircular(new Node(900));
}
}
