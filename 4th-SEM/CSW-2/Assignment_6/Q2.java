class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
    }

}

class BST{
    Node root;

    public void createTree(int a[]){
        this.root=createBST(a,0,a.length-1);
    }

    public Node createBST(int a[],int first,int last){
            if(first>last){
                return null;
            }
            int mid=(first+last)/2;
            Node n=new Node(a[mid]);
            n.left=createBST(a,first,mid-1);
            n.right=createBST(a, mid+1,last);
            return n;

    }
    public void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}

public class Q2 {
    public static void main(String[] args) {
        int a[]={10,20,30,40,50,60,70,80,90,100};
        BST tree=new BST();
        tree.createTree(a);
        tree.preorder(tree.root);
    }
}
