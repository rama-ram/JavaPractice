
public class MergeLinkedList {

	// Java program to merge a linked list into another at
	// alternate positions
	
	    Node head;  // head of list
	 
	    /* Linked list Node*/
	    class Node
	    {
	        int data;
	        Node next;
	        Node(int d) {data = d; next = null; }
	    }
	 
	    /* Inserts a new Node at front of the list. */
	    void push(int new_data)
	    {
	        /* 1 & 2: Allocate the Node &
	                  Put in the data*/
	        Node new_node = new Node(new_data);
	 
	        /* 3. Make next of new Node as head */
	        new_node.next = head;
	 
	        /* 4. Move the head to point to new Node */
	        head = new_node;
	    }
	 
	    // Main function that inserts nodes of linked list q into p at
	    // alternate positions. Since head of first list never changes
	    // and head of second list/ may change, we need single pointer
	    // for first list and double pointer for second list.
	    void merge(MergeLinkedList q)
	    {
	        Node p_curr = head, q_curr = q.head;
	        Node p_next, q_next;
	 
	        // While there are available positions in p;
	        while (p_curr != null && q_curr != null) {
	 
	            // Save next pointers
	            p_next = p_curr.next;
	            q_next = q_curr.next;
	 
	            // make q_curr as next of p_curr
	            q_curr.next = p_next; // change next pointer of q_curr
	            p_curr.next = q_curr; // change next pointer of p_curr
	 
	            // update current pointers for next iteration
	            p_curr = p_next;
	            q_curr = q_next;
	        }
	        q.head = q_curr;
	    }
	 
	    /* Function to print linked list */
	    void printList()
	    {
	        Node temp = head;
	        while (temp != null)
	        {
	           System.out.print(temp.data+" ");
	           temp = temp.next;
	        }
	        System.out.println();
	    }
	
	 
	    /* Drier program to test above functions */
	    public static void main(String args[])
	    {
	    	MergeLinkedList llist1 = new MergeLinkedList();
	    	MergeLinkedList llist2 = new MergeLinkedList();
	        llist1.push(3);
	        llist1.push(2);
	        llist1.push(1);
	 
	        System.out.println("First Linked List:");
	        llist1.printList();
	 
	        llist2.push(8);
	        llist2.push(7);
	        llist2.push(6);
	        llist2.push(5);
	        llist2.push(4);
	 
	        System.out.println("Second Linked List:");
	 
	        llist1.merge(llist2);
	 
	        System.out.println("Modified first linked list:");
	        llist1.printList();
	 
	        System.out.println("Modified second linked list:");
	        llist2.printList();
	    }
	} /* This code is contributed by Rajat Mishra */


