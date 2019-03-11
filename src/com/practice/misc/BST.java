import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BST {


	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
//        in.nextline();
            int newArr[] = new int[n];
        for(int i=0; i < n; i++){
            a[i] = in.nextInt();
        }//read the array
       for(int i=0; i <n; i++){
            newArr[(n-k+i)%n] = a[i];
        }
        
    }
    boolean checkBST(Node root) {
        Node parent=null;
        if (root == null)
            return false;
        else { //traverse left first
            while(root.left !=null)
            {
            if (root.left != null && root.left.data < root.data )
                {
                parent = root;
                root = root.left;                   
            }
                else 
                return false;

            }
            root = parent;
                        
        while(root.right !=null)
            {//traverse right
            if ( root.right != null && root.right.data > root.data)
                {
                parent = root;
                root = root.right;                   
            }
            else 
                return false;
            
            }
            if(checkBST(root.left) || checkBST(root.right));
            }
        return true;
            }
        
    
    
    public void addNode(int value, Node node){
    	if (node == null)
    			node = new Node(value);
    	node.addNode(value);
    }
    public class Node{
    	private Node left; private Node right;
    	int data;
    	
    	Node(int data){
    		this.data = data;
    	}
    	
    	
    	public void addNode(int value){
    		if (this != null)
    		{
    			
    		}
    		
    	}
    	
    }    
}
