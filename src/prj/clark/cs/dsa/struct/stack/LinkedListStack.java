package prj.clark.cs.dsa.struct.stack;

public class LinkedListStack<T> implements Stack<T> {
    private static class Node<T> {
        T item;
        Node next;

        Node(T item) {
            this(item, null);
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<T> current;
    private int size;

    public LinkedListStack() {
        current = null;
        size = 0;
    }

    public void push(T elem) {
        if (current == null) {
            current = new Node<>(elem);
        } else {
            Node<T> pushed = new Node<>(elem);
            pushed.next = current;
            current = pushed;
        }

        size++;
    }

    public T pop() {
        if (current == null) {
            return null;
        }

        size--;

        T popped = current.item;
        current = current.next;

        return popped;
    }

    public int size() {
        return size;
    }
}
