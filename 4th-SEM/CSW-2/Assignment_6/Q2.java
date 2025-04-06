package Assignment_6;
/*Construct a binary search tree from the given array of elements: {10, 20, 30, 40, 50, 60, 
70, 80, 90, 100}. Include a method called CreateTree to construct the binary search 
tree from a sorted array. This method takes an array of integers as input and constructs 
the tree recursively using a binary search algorithm. */
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
    }
}
class BSTree{
    Node root;

    public void CreateTree(int val[]){
        this.root = createBST(val, 0, val.length - 1);
    }

    public Node createBST(int val[],int first,int last){
        if(first>last){
            return null;
        }
        int mid=(first+last)/2;
        Node n=new Node(val[mid]);
        n.left=createBST(val, first, mid-1);
        n.right=createBST(val,mid+1,last);
        return n;
    }

    public void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}


public class Q2 {
    public static void main(String[] args){
        int val[]={2,5,7,23,75,124,54,113};
        BSTree tree=new BSTree();
        tree.CreateTree(val);
        tree.inorder(tree.root);
    }
}
