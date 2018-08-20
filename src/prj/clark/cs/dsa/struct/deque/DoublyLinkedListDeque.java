package prj.clark.cs.dsa.struct.deque;

import java.util.Iterator;

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

        void append(Node next) {
            this.next = next;
            next.prev = this;
        }

        void prepend(Node prev) {
            this.prev = prev;
            prev.next = this;
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
        if (size <= 0) {
            return null;
        }

        T popped = left.item;
        left = left.next;

        size--;

        return popped;
    }

    @Override
    public T popRight() {
        if (size <= 0) {
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
        if (left == null && right == null) {
            left = right = new Node(elem);
        } else {
            Node pushed = new Node(elem);
            left.prepend(pushed);
            left = pushed;
        }

        size++;
    }

    @Override
    public void pushRight(T elem) {
        if (right == null && left == null) {
            left = right = new Node(elem);
        } else {
            Node pushed = new Node(elem);
            right.append(pushed);
            right = pushed;
        }

        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListDequeIterator();
    }

    private class DoublyLinkedListDequeIterator implements Iterator<T> {
        private Node curr;

        private DoublyLinkedListDequeIterator() {
            curr = left;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public T next() {
            T next = curr.item;
            curr = curr.next;

            return next;
        }
    }
}
