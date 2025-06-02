class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

}

class BST {
    Node root;

    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public Node delete(Node root, int data) {

        if (root.data < data) {
            root.right = delete(root.right, data);
        } else if (root.data > data) {
            root.left = delete(root.left, data);
        }

        else {
            // case 1 : no child
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 :
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 :
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;
    }

    public Node inorderSuccessor(Node root) {
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    // Simple search method for a value in BST
    public boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }
}

public class Q5 {
    public static void main(String[] args) {
        BST tree = new BST();
        int arr[] = { 1, 4, 6, 3, 5, 10, 11, 14 };
        Node main = new Node(8);
        tree.root = main;
        for (int i = 0; i < arr.length; i++) {
            tree.root = tree.insert(tree.root, arr[i]);
        }
        tree.inorder(tree.root);
        tree.root = tree.delete(tree.root, 11);
        System.out.println();
        tree.inorder(tree.root);
    }
}
