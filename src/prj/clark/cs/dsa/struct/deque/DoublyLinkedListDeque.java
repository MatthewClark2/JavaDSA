package prj.clark.cs.dsa.struct.deque;

public class DoublyLinkedListDeque implements Deque {
    private static class Node {
        String item;
        Node next;
        Node prev;

        Node(String item) {
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
    public String popBack() {
        if (size <= 0 || left == null) {
            return null;
        }

        String popped = left.item;
        left = left.next;

        size--;

        return popped;
    }

    @Override
    public String popFront() {
        if (size <= 0 || right == null) {
            return null;
        }

        String popped = right.item;
        right = right.prev;

        size--;

        return popped;
    }

    @Override
    public void pushBack(String elem) {
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
    public void pushFront(String elem) {
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
