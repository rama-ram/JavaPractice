package com.practice.dataStructures;
import java.util.ArrayList;
import java.util.HashSet;

public class TreeProblems {
	
	//count leaves in  a binary tree
	
	 static Node root;
	
	TreeProblems(){
		root=null;
		
	}
	public void deleteTree(){
		
		deleteTree(root);
		root=null;
	}
	public void addNode(int value){
		if (root==null){
			root=new Node(value);
			System.out.println("added head node..." + root.data);	
		}
		else
			root.add(root,value);
		
		
	}
	public void inorder(){
		if (root == null)//empty tree
		{System.out.println("the tree is emoty");
			return;
		}
			root.inOrderTraversal(root);
		}
		public void preorder(){
			if (root == null)//empty tree
			{System.out.println("the tree is emoty");
				return;
			}
				root.preOrderTraversal(root);
			}
		public void postorder(){
			if (root == null)//empty tree
			{System.out.println("the tree is emoty");
				return;
			}
				root.postOrderTraversal(root);
			}
		public void deleteTree(Node node){
			if(node == null)
				return;
			deleteTree(node.left);
			deleteTree(node.right);
			System.out.println("deleting the node" + node.data);
			node=null;
			
		}
		public void findPairs(int sum){
			//compliment array and push to HashSet
			
			ArrayList <Integer >arr = new ArrayList<Integer >();
			arr=root.inOrderTraversalArr(root,arr);
			System.out.println("the BST in array form of size  " + arr.size());
			for (int a: arr)
				System.out.println(a);
			HashSet set = new HashSet(arr);
			for (int a: arr){
				int comp = sum-a;
				if (a >comp) break;
				if(comp !=a && !set.add(comp)){
					System.out.println("the pairs are : " + a +"  "+comp);
				}
				
				
			}
			
		}	
		
		
	 class Node{
		
		 Node right;
		 Node left;
		 int data;
	Node(int value){
		data=value;
		right=null;
		left=null;
	}
	
	private void add(Node node,int value){
		if (value >node.data){
			if( node.right == null)
		{
			node.right = new Node(value);
			System.out.println("added to right...."+node.right.data);
			return;
		}
			else
				add(node.right,value);
				
		}
		else
			if(value <node.data){
				if( node.left == null)
			{
				node.left = new Node(value);
				System.out.println("added to left...."+node.left.data);
				return;
			}
				else
					add(node.left,value);
					
			}
	}
	

	public void inOrderTraversal(Node node){
		if (node ==null)
			return;
		
		
		inOrderTraversal(node.left);
		System.out.println(node.data);
		inOrderTraversal(node.right);
	}
	public ArrayList inOrderTraversalArr(Node node,ArrayList arr){
		if (node ==null)
			return null;
		
		
		inOrderTraversalArr(node.left,arr);
		arr.add(node.data);
		
		inOrderTraversalArr(node.right,arr);
		return arr;
	}
	public void preOrderTraversal(Node node){
		if (node ==null)
			return;
		System.out.println(node.data);
		inOrderTraversal(node.left);
		
		inOrderTraversal(node.right);
	}
	public void postOrderTraversal(Node node){
		if (node ==null)
			return;
		
		inOrderTraversal(node.left);
		System.out.println(node.data);
		inOrderTraversal(node.right);
		
	}
	}
	 
	 
	 
	 
	 public static void main(String arrgs[]){
		 
		 TreeProblems newTree = new TreeProblems();
		 newTree.addNode(5);
		 newTree.addNode(3);
		 newTree.addNode(7);
		 newTree.addNode(10);
		 newTree.addNode(6);
		 newTree.addNode(2);
		 newTree.addNode(4);
		 newTree.addNode(1);
		 System.out.println("in order traversal...");
		 newTree.inorder();
		 System.out.println("pre order traversal...");
		 newTree.preorder();
		 System.out.println("post order traversal...");
		 newTree.postorder();
		 //find the pairs whose sum is equal to given number
		 newTree.findPairs(10);
		 newTree.deleteTree();
		 System.out.println("in order traversal...");
		 newTree.inorder();
	 }
}
	


