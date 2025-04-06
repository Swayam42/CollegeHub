package Assignment_6;

/*Design a class BSTNode in Java with a member variable info to store an integer and 
two references, left and right, to represent its left and right children. Implement a 
constructor to initialize these attributes. Develop a method to insert a node while 
maintaining the properties of a binary search tree. Extend this implementation by 
adding methods for traversing the tree using pre-order, in-order, and post-order 
techniques. Finally, add a main method to create a binary search tree, insert multiple 
nodes, and invoke the traversal methods to display the tree structure. */
class BSTNode {
    int info;
    BSTNode left;
    BSTNode right;

    public BSTNode(int info) {
        this.info = info;                                
    }

}

class BSTtree {
    BSTNode root = null;

    public static BSTNode insert(BSTNode root, int val) {
        if (root == null) {
            root = new BSTNode(val);
            return root;
        }

        if (val < root.info) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(BSTNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.info + " ");
        inorder(root.right);
    }

    public static void preorder(BSTNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.info + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(BSTNode root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.info + " ");
    }
}

public class Q1 {
    public static void main(String[] args) {
        int val[] = { 5, 1, 3, 4, 2, 7 };
        BSTtree tree = new BSTtree();

        for (int i : val) {
            tree.root = BSTtree.insert(tree.root, i);
        }
        System.out.println("Inorder : ");
        tree.inorder(tree.root);

        System.out.println("\nPreorder : ");
        tree.preorder(tree.root);

        System.out.println("\nPostorder : ");
        tree.postorder(tree.root);
    }
}
