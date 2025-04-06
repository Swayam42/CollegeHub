package Assignment_6;

/*Design a Java program to manage country data using a binary search tree (BST). 
Create a class Country with members for name and population, along with a 
constructor and necessary methods. Define a class BNode to store a Country object and 
maintain references to its left and right children. Implement a class BSTCountry with 
a root node, a constructor, and a method to insert countries into the tree based on their 
population. Extend the BST by adding methods for in-order traversal, finding the 
country with the maximum population (findMax), and finding the country with the 
minimum population (findMin). Finally, develop a main method to create a BST, 
insert country nodes, and invoke these methods to display the results. */

class Country {
    String name;
    long population;

    public Country(String name, long population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return name + " (" + population + ")";
    }
}

class BNode {
    Country data;
    BNode left;
    BNode right;

    public BNode(Country data) {
        this.data = data;
    }
}

class BSTCountry {
    BNode root;

    public BSTCountry() {
        this.root = null;
    }

  
    public void insert(Country country) {
        root = insertRec(root, country);
    }

    private BNode insertRec(BNode root, Country country) {
        if (root == null) {
            return new BNode(country);
        }
        if (country.population < root.data.population) {
            root.left = insertRec(root.left, country);
        } else {
            root.right = insertRec(root.right, country);
        }
        return root;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(BNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.data);
            inOrderRec(root.right);
        }
    }


    public Country findMin() {
        if (root == null) {
            return null;
        }
        BNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public Country findMax() {
        if (root == null) {
            return null;
        }
        BNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }
}

public class Q4 {
    public static void main(String[] args) {
        BSTCountry tree = new BSTCountry();

        tree.insert(new Country("India", 1400000000));
        tree.insert(new Country("USA", 331000000));
        tree.insert(new Country("China", 1440000000));
        tree.insert(new Country("Brazil", 213000000));
        tree.insert(new Country("Australia", 25600000));

        System.out.println("In-order Traversal (Countries by Population):");
        tree.inOrder();

        System.out.println("\nCountry with Minimum Population:");
        System.out.println(tree.findMin());

        System.out.println("\nCountry with Maximum Population:");
        System.out.println(tree.findMax());
    }
}
