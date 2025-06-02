class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BST {
    Node root;

    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public boolean isBST(Node node,int min,int max) {
        if (node==null)
            return true;
        if (node.data <= min || node.data >= max)
            return false;
        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }
}

public class Q3 {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = new Node(30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 102);
        tree.insert(tree.root, 12);
        boolean t=tree.isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(t);
    }
}
