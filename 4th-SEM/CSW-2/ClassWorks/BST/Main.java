package BST;
import java.util.*;

//Blueprint of Node for BST :
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data=data;
	}
}

class BST{
	Node root;
	
	//Iterative Insertion Method
	public void insertIterative(int data) {
		Node newNode=new Node(data);
		if(root==null) {
			root=newNode;
			return;
		}
		
		Node curr=root;
		Node parent=null;
		while(true){
			parent=curr;
			if(data<curr.data) {
				curr=curr.left;
				if(curr==null) {
					parent.left=newNode;
					return;
				}
			}else {
				curr=curr.right;
				if(curr==null) {
					parent.right=newNode;
					return;
				}
			}
		}
	}
	
	//In-order Traversal Method
	public void inorder(Node node) {
		if(node==null) 
			return;
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
	
	//Deletion Method
	public void delete(int data) {
		root=deleteNode(root,data);
	}
	//Helper Method for delete()
	public Node deleteNode(Node root,int data) {
		if(root==null) {
			return root;
		}
		if(data<root.data){ //Move to left subtree
			root.left=deleteNode(root.left,data);
		}else if(data>root.data){ //Move to right subtree
			root.right=deleteNode(root.right,data);
		}else{
			
			//CASE 1 :Node having one child
			if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
			//CASE 2 :Node having 2 children  
			 root.data = minSuccessor(root);
	         root.right = deleteNode(root.right, root.data);
	         
	         //CASE 3 :Node having no child (Leaf Node)
	         if(root.left==null&&root.right==null) {
	        	 return null;
	         }
		}
		
		return root;
		
	}
	
	//Smallest Node in the right subtree
	public int minSuccessor(Node root) {
		root=root.right;
		int min=root.data;
		while(root.left!=null) {
			min=root.left.data;
			root=root.left;
		}
		return min;
	}
	
	//Search Node :
	
	public boolean SearchNode(int data) {
		return search(root,data);
	}
	
	public boolean search(Node root,int data) {
		if(root==null) {
			return false;
		}
		else if(root.data==data) {
			return true;
		}
		else if(data<root.data) {
			return search(root.left,data);
		}else {
			 return search(root.right,data);
		}
	
		
	}
	
	
}
public class Main {

	public static void main(String[] args) {
		BST tree=new BST();
		int arr[]= {45,10,90,7,12,50};
		for(int i:arr) {
			tree.insertIterative(i);
		}
		
		System.out.print("Inorder Traversal : ");
		tree.inorder(tree.root);
		
		//Deletion of Node :
		int delData=45;
		tree.delete(delData);
		System.out.print("\nAfter Deleting 45 :");
		tree.inorder(tree.root);
		System.out.println();
		System.out.println(tree.SearchNode(3));

	}

	

}
