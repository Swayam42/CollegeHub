class Country{
    String name;
    long population;
    public Country(String name,long population){
        this.name=name;
        this.population=population;
    }

    public String toString(){
        return "Name : "+this.name+" Population : "+this.population;
    }

}
class Node{
    Country data;
    Node left;
    Node right;

    public Node(Country data){
        this.data=data;
    }

}

class BSTCountry{
    Node root;
    public BSTCountry(){
        this.root=null;
    }

    public void insert(Country c){
        root=insertRec(root,c);
    }

    public Node insertRec(Node root,Country c){
        if(root==null){
            root=new Node(c);
            return root;
        }
        if(c.population<root.data.population){
            root.left=insertRec(root.left,c);
        }else{
            root.right=insertRec(root.right,c);
        }
        return root;
    }

    public void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data.toString()+" ");
        inorder(root.right);
    }

    public Country findMin(){
        if(root==null){
            return null;
        }

        Node curr=root;
        while(curr.left!=null){
            curr=curr.left;
        }
        return curr.data;
    }

    public Country findMax(){
        if(root==null){
            return null;
        }
        Node curr=root;
        while(curr.right!=null){
            curr=curr.right;
        }
        return curr.data;
    }

}
public class Q4 {
    public static void main(String[] args) {
        BSTCountry tree=new BSTCountry();
        tree.insert(new Country("India", 1400000000));
        tree.insert(new Country("USA", 331000000));
        tree.insert(new Country("China", 1440000000));
        tree.insert(new Country("Brazil", 213000000));
        tree.insert(new Country("Australia", 25600000));
        tree.inorder(tree.root);
        System.out.println("Min Population Country : ");
        System.out.println(tree.findMin().toString());
        System.out.println("Max Population Country : ");
        System.out.println(tree.findMax().toString());
    }
}
