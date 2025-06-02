class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

class BST{
    Node root=null;
    public  Node insert(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(data<root.data){
            root.left=insert(root.left, data);
        }else{
            root.right=insert(root.right,data);
        }
        return root;
    }

    public void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public  void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }
}
public class Q1 {
    public static void main(String[] args) {
        int a[]={5,1,3,4,2,7};
        BST tree=new BST();
        for(int i=0;i<a.length;i++){
            tree.root=tree.insert(tree.root,a[i]);
        }

        tree.inorder(tree.root);
    }
}
