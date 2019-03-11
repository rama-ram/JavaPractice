import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;



class BinaryTestTree {
		BSTNode root;
		
	BinaryTestTree(){
		root = null;
	}
	public BSTNode insert(int data){
		BSTNode newNode = new BSTNode (data);
		if (root == null){
			System.out.println("BSt is empty, inserting the first node..." + data);
			return root=newNode;
		}
			
		else
			return addNode(newNode,root);
	
		
	}
	
	void  countLeave(){
		System.out.println("leaves count............" +countLeave(root));
		
	}
	int maxDepth(BSTNode node) 
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
    }
	
	int countLeave(BSTNode node){
		int left,right;
		if (node == null)
			return 0;
		else if(node.left == null)
				return 1;
		else if(node.right == null)
			return 1;
		else{
			left = countLeave(node.left);
			right =  countLeave(node.right);
		}
		System.out.println("the value is "+ ( left+right));	
		return  left+right ;
		
		
	}
	int treeHeight(BSTNode node){
		
		if (node == null)
			return 0;
		else {
		int left =  treeHeight(node.left);
		
		int right=  treeHeight(node.right);
		
		if (left > right)
			return (left+1);
		else
			return (right+1);
			
		}
		
	}

	void inorderTraversal(){
		inorder(root);
	}
	void preorderTraversal(){
		preorder(root);
	}
	void postorderTraversal(){
		postorder(root);
	}
	void levelorderTraversal(){
		for (int i=1;i<=3;i++)
		levelOrder(root,i);
		System.out.println("the second methd");
		levelOrder(root);
	}
	void inorder(BSTNode node){
//		System.out.println("inorder.........");
		if (root == null){
			System.out.println("BSt is empty, nothoign to traverse...");
			return;}
			if (node!=null){
			
				inorder (node.left);
				System.out.println(" node is " + node.data);
			inorder (node.right);}		
			
	}
	void preorder(BSTNode node){
		
	
		if (root == null){
			System.out.println("BSt is empty, nothoign to traverse...");
			return;}
			if (node!=null){
				System.out.println(" node is " + node.data);
				preorder (node.left);
				preorder (node.right);
			
			}		
			
	}
	

	
	void postorder(BSTNode node){
		
//		System.out.println("post-order.........");
		
		if (root == null){
			System.out.println("BSt is empty, nothoign to traverse...");
			return;}
			if (node!=null){
		
				postorder (node.left);
				postorder (node.right);
				System.out.println(" node is " + node.data);
			}		
			
	}
	
void levelOrder(BSTNode node,int level){
		
//		System.out.println("post-order.........");
	
		if (root == null){
			System.out.println("BSt is empty, nothoign to traverse...");
			return;
			}
		if (level == 1 && node !=null){
			System.out.println("level 1..." + node.data);
		return;}
		else if (level >1 && node !=null){
				levelOrder(node.left,level-1);
				levelOrder(node.right,level-1);
		}
				
			
	}
		

void levelOrder(BSTNode node){
		
//		System.out.println("post-order.........");
	
	Queue<BSTNode> queue = new LinkedList<BSTNode>();
	while(node != null){
		System.out.println(node.data);
	if (node.left != null)
	queue.add(node.left);
	if (node.left != null)
	queue.add(node.right);
	node = queue.poll();
	}
	
	
				
			
	}
		
		
	 public BSTNode addNode(BSTNode newNode,BSTNode root){
			if ( newNode.data < root.data){
				if (root !=null && root.left !=null)
					addNode(newNode,root.left);
					
				else{
					System.out.println("inserting the node to left of ..." + newNode.data);
					root.left=newNode;
					return newNode;
					}
				}
			else{
				if (root !=null && root.right !=null)
					addNode(newNode,root.right);
					
				else{
					System.out.println("inserting the node to rigth of ..." + newNode.data);
					root.right=newNode;
					return newNode;
					}
		}
			return newNode;	
		}
		
	

	class BSTNode{
		int data ; public BSTNode left; public BSTNode right;
		BSTNode (int a){
			
			this.data = a; 
			
		}
		 }
	
		 public static void main(String[] args){
			 
			 BinaryTestTree bst = new BinaryTestTree();
//			 bst.insert(4);
//			 bst.insert(5);
//			 bst.insert(2);
//			 bst.insert(3);
//			 bst.insert(1);
//			bst.insert(5);
//			bst.insert(1);
//			bst.insert(3);
//			bst.insert(6);
//			bst.insert(8);
//			bst.insert(7);
//			bst.insert(9);
//			bst.insert(3);
//			bst.insert(2);
			 bst.insert(10);
			 bst.insert(1);
			 bst.insert(2);
			 bst.insert(5);
			 bst.insert(3);
			 bst.insert(6);
			 bst.insert(12);
			
			System.out.println("in-order.........");
			 bst.inorderTraversal();
			 
			 System.out.println("pre-order.........");
			 
			 bst.preorderTraversal();
			 System.out.println("post-order.........");
			 bst.postorderTraversal();
			 System.out.println("level-order.........");
			 bst.levelorderTraversal();
			 System.out.println("left height of the tree.........");
			 System.out.println("left height of the tree........."+bst.maxDepth(bst.root));
			 System.out.println("count of the tree........."+bst.countLeave(bst.root));
		 bst.countLeave();
		 }
		 
	




}

