
import java.util.ArrayList;
import java.util.List;




public class RootToLeafToSum {

    public class Node{
    	private Node left; private Node right;
    	int data;
    	
    	Node(int data){
    		this.data = data;
    		    	}
    	public boolean addNode(int value){
    		boolean isAdded =false;
    		if (this == null)
    			this.data= value;
    		else{
    			if (value < this.data)
    				if (this.left ==null)
    					{this.left = new Node(value);
    					 return true;
    					 }
    				else
    					{
    					this.left.addNode (value);
    					isAdded = true;
    					}
    			else if (value > this.data)
        				if (this.right ==null)
        					{this.right = new Node(value);
        					 return true;
        					 }
        				else
        					{
        					this.right.addNode (value);
        					isAdded = true;
        					}
    			}
    		return isAdded;
    		}
    		
    	
    	
    }   
    public boolean printPath(Node root, int sum, List<Node> path){
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            if(root.data == sum){
                path.add(root);
                return true;
            }else{
                return false;
            }
        }
        if(printPath(root.left, sum-root.data, path) || printPath(root.right, sum - root.data, path)){
            path.add(root);
            return true;
        }
        return false;
    }
    
    int findHeight(Node node){
    	if (node == null)
    		return 0;
    	
int leftHeight = findHeight(node.left);
int rightHeight = findHeight(node.right);
return 1+ Math.max(leftHeight, rightHeight);
    	
    }
    
    
    void createMirrorTree(Node node){
    	
    	if (node == null) return;
    	
    	createMirrorTree(node.left);
    	createMirrorTree(node.right);
    	
    	if (node.left != null && node.right != null)
    	{
    		Node temp = node.left;
    		node.left = node.right;
    		node.right = temp;
    		
    	}
    	
    }
    
    int getSizeOfTree(Node node){
    	if (node == null )return 0;
    			
    			int leftsize =  getSizeOfTree(node.left);
    			int rightsize =  getSizeOfTree(node.right);
    			
    			return leftsize + rightsize +1; 
    	
    	
    }
    
    boolean findSumPath(Node node, int sum, ArrayList<Integer> arr){
    	
    	if (node == null) return false;
    	if (node.left ==null && node.right == null){
    		if(node.data== sum)
    			{
    			arr.add(node.data);
    			return true;
    			}
    		else{
    			if ((findSumPath(node.left, sum-node.data, arr)||(findSumPath(node.right, sum-node.data, arr))))
    					return true;
    			}
    	}
    	return false;
    }
    
    
    
    public static void main(String args[]){
        RootToLeafToSum rtl = new RootToLeafToSum();
        BST bt = rtl.new BST();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);
        head = bt.addNode(19, head);
        head = bt.addNode(20, head);
        head = bt.addNode(4, head);
        head = bt.addNode(3, head);
        List<Node> result = new ArrayList<>();
        boolean r = rtl.printPath(head, 22, result);
        if(r){
            result.forEach(node -> System.out.print(node.data + " "));
        }else{
            System.out.println("No path for sum " + 22); 
        }
    }
    
    public class BST {
    	Node root;
    	BST(){
    			root = null;
    	}
    	public Node addNode(int value, Node node){
    		node = new Node (value);
    		if (root == null)
    			root=node;
			return node;
    	}
    }
    
}