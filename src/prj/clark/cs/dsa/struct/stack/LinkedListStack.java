package prj.clark.cs.dsa.struct.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<T> implements Stack<T> {
    private class Node {
        T item;
        Node next;
        Node prev;

        Node(T item) {
            this(item, null);
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;

            // If it is null, then we don't have to set anything since there is nothing there.
            if (next != null) {
                next.prev = this;
            }
        }
    }

    private Node current;
    private int size;

    public LinkedListStack() {
        current = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T elem) {
        current = new Node(elem, current);

        size++;
    }

    @Override
    public T pop() {
        if (current == null) {
            throw new NoSuchElementException();
        }

        size--;

        T popped = current.item;
        current = current.next;

        return popped;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListStackIterator();
    }

    private class LinkedListStackIterator implements Iterator<T> {
        private Node node;

        LinkedListStackIterator() {
            node = findRoot();
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            if (! hasNext()) {
                throw new NoSuchElementException();
            }

            T next = node.item;
            node = node.prev;
            return next;
        }

        private Node findRoot() {
            if (current == null) {
                return null;
            }

            Node root = current;
            while (root.next != null) {
                root = root.next;
            }

            return root;
        }
    }
}
