public class Stack {
    int stack[];
    int top;
    int size;

    public Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = value;
            System.out.println(value + " pushed to stack");
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("Element popped: " + stack[top--]);
        }
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top];
    }

    public void size() {
        System.out.println("Size: " + (top + 1));
    }

    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(30);
        s.push(12);
        s.push(5);
        s.pop();
        s.size();
    }
}
