package BST;
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
	public void insertIterative(int data) {
		Node newNode=new Node(data);
		if(root==null) {
			root=new Node(data);
			return;
		}
		Node curr=root;
		Node parent=null;
		while(true) {
			parent=curr;
			if(data<curr.data) {
				curr=curr.left;
				if(curr==null) {
					parent.left=new Node(data);
					return;
				}
			}else {
				curr=curr.right;
				if(curr==null) {
					parent.right=new Node(data);
					return;
				}
			}
		}
	}
	
	public void inorder(Node node) {
		if(node==null) 
			return;
		inorder(node.left);
		System.out.println(node.data);
		inorder(node.right);
	}
	
	
}
public class Main {

	public static void main(String[] args) {
		BST tree=new BST();
		int arr[]= {10,6,4,8,2};
		for(int i:arr) {
			tree.insertIterative(i);
		}
		
		System.out.println("Inorder Traversal : ");
		tree.inorder(tree.root);

	}

}
