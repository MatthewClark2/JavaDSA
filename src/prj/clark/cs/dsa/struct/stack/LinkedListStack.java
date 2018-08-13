package prj.clark.cs.dsa.struct.stack;

public class LinkedListStack implements Stack {
    private class Node {
        String item;
        Node next;

        Node(String item) {
            this(item, null);
        }

        Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node current;
    private int size;

    public LinkedListStack() {
        current = null;
        size = 0;
    }

    public void push(String elem) {
        if (current == null) {
            current = new Node(elem);
        } else {
            Node pushed = new Node(elem);
            pushed.next = current;
            current = pushed;
        }

        size++;
    }

    public String pop() {
        if (current == null) {
            // TODO (matthew-c21) Have some sort of real behavior.
            return null;
        }

        size--;

        String popped = current.item;
        current = current.next;

        return popped;
    }

    public int size() {
        return size;
    }
}
