package prj.clark.cs.dsa.struct.deque;

public class DoublyLinkedListDeque<T> implements Deque<T> {
    private class Node {
        T item;
        Node next;
        Node prev;

        Node(T item) {
            this.item = item;

            next = null;
            prev = null;
        }
    }

    private Node left;
    private Node right;
    private int size;

    public DoublyLinkedListDeque() {
        left = null;
        right = null;

        size = 0;
    }

    @Override
    public T popLeft() {
        if (size <= 0 || left == null) {
            return null;
        }

        T popped = left.item;
        left = left.next;

        size--;

        return popped;
    }

    @Override
    public T popRight() {
        if (size <= 0 || right == null) {
            return null;
        }

        T popped = right.item;
        right = right.prev;

        size--;

        return popped;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void pushLeft(T elem) {
        if (left == null) {
            left = new Node(elem);
            left.next = right;
        } else {
            Node pushed = new Node(elem);
            pushed.prev = null;
            pushed.next = left;
            left = pushed;
        }

        size++;
    }

    @Override
    public void pushRight(T elem) {
        if (right == null) {
            right = new Node(elem);
            right.prev = left;
        } else {
            Node pushed = new Node(elem);
            pushed.next = null;
            pushed.prev = right;
            right = pushed;
        }

        size++;
    }

    @Override
    public int size() {
        return size;
    }
}
