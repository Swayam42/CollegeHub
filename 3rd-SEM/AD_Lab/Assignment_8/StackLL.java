package Assignment_8;

public class StackLL {
     Node top;
     int size;

   
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

 
    public StackLL() {
        top = null;
        size = 0;
    }

 
    public void push(int value) {
        Node newNode = new Node(value);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
        System.out.println(value + " pushed to stack");
    }

   
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("Element popped: " + top.data);
            top = top.next;
            size--;
        }
    }

  
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1; 
        }
        return top.data;
    }


    public boolean isEmpty() {
        return top == null;
    }

    public void size() {
        System.out.println("Size: " + size);
    }

    public static void main(String[] args) {
        StackLL s = new StackLL();
        s.push(23);
        s.push(46);
        s.push(81);
        s.push(5);
        s.pop();
        s.size();
    }
}
