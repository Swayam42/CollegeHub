package Assignment_7;

import java.util.Scanner;

public class LinkedList {
    static Node head = null;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Creation
    static Node createNode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input data: ");
        int data = sc.nextInt();
        return new Node(data);
    }

    // Insertion of a new element at any given position
    static void InsPos(int p) {
        Node newNode = createNode();
        if (p == 1) { // Insert at head
            
            head = newNode;
        } else {
            Node temp = head;
            int count = 1;

            while (temp != null && count < p - 1) {
                temp = temp.next;
                count++;
            }

            if (temp == null) {
                System.out.println("Position out of bounds.");
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }

    // Deletion of an element from any given position
    static void delPos(int p) {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (p == 1) { // Delete head
            Node toDelete = head;
            head = head.next;
            toDelete.next = null;
        } else {
            Node temp = head;
            int count = 1;

            while (temp != null && count < p - 1) {
                temp = temp.next;
                count++;
            }

            if (temp == null || temp.next == null) {
                System.out.println("Position out of bounds.");
            } else {
                Node toDelete = temp.next;
                temp.next = toDelete.next;
                toDelete.next = null;
            }
        }
    }

    // Searching a given element
    static Node search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number to search: ");
        int data = sc.nextInt();
        Node temp = head;
        int position = 1;

        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Element " + data + " found at position: " + position);
                return temp;
            }
            temp = temp.next;
            position++;
        }

        System.out.println("Element " + data + " not found in the list.");
        return null;
    }

    static void reverse(){
        Node temp=null;
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head=prev;
    }

    // Display the linked list
    static void displayList() {
        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            Node temp = head;
            System.out.print("Linked List: ");
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at position");
            System.out.println("2. Delete at position");
            System.out.println("3. Search an element");
            System.out.println("4. Display the list");
            System.out.println("5. Reverse the list");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter position to insert: ");
                    int insPos = sc.nextInt();
                    InsPos(insPos);
                    break;
                case 2:
                    System.out.print("Enter position to delete: ");
                    int delPos = sc.nextInt();
                    delPos(delPos);
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    displayList();
                    break;
                case 5:
                    System.out.print("Before Reversing : ");
                    displayList();
                    System.out.print("After Reversing : ");
                    reverse();
                    displayList();  
                    break;  
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;    
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
