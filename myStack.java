public class Node {
    int value;
    Node next;
    Node(int value) {
        this(value, null);
    }
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
    

public interface myStack {
    boolean isEmpty(); // Return true/false if myStack is/isn't empty
    int size(); // Computes and returns the number of elements in the stack
    void print(); // Prints each element in order, with some separator
    void push(int value); // Adds value to the top of the stack
    int pop(); // Removes the value at the top of the stack and returns it
    }

public class myLinkedList implements myStack {
    Node top = null;
    myLinkedList() {}
    myLinkedList(Node n) {
    top = n;
    }

    public boolean isEmpty() {
        return top == null;
        }
        
    public int size() {
        Node cursor = top;
        int i = 0;

        while (cursor != null) {
        cursor = cursor.next;
        i++;
        }
        return i;
    }
       
    public void print() {
        if(isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        String out = "";
        Node cursor = top;
        out += cursor.value + " -> ";
        while (cursor.next != null) {
            cursor = cursor.next;
            out += cursor.value + " -> ";
        }
        System.out.println(out);
    }
        
    public void push(int value) {
        Node newFirst = new Node(value);
        newFirst.next = top;
        top = newFirst;
    }
        
    public int pop() {
        exceptionIfEmpty();
        int val = top.value;
        top = top.next;
        return val;
    }
        
    void exceptionIfEmpty() {
        try {
            if (isEmpty()) {
                throw new Exception("List is empty: has no first element");
            }
        } catch(Exception e) {
        e.printStackTrace();
        }
    }
}
        