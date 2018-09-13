package prj.clark.cs.dsa.struct.table;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class BinarySearchTreeSymbolTable<K extends Comparable<K>, V> implements SymbolTable<K, V> {
    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        void addChild(Node child) {
            // Throw an exception if child is null.
            int cmp = child.key.compareTo(this.key);

            if (cmp < 0) {
                pushLeft(child);
            } else if (cmp > 0) {
                pushRight(child);
            } else {
                // The key is equivalent, so we copy it. In Rust or C++, this would be moved.
                this.key = child.key;
                this.value = child.value;
            }
        }

        private void pushLeft(Node child) {
            if (left == null) {
                left = child;
            } else {
                left.addChild(child);
            }
        }

        private void pushRight(Node child) {
            if (right == null) {
                right = child;
            } else {
                right.addChild(child);
            }
        }

        private Optional<Node> findChild(K key) {
            return findChild(this, key);
        }

        private Optional<Node> findChild(Node start, K key) {
            if (start == null) {
                return Optional.empty();
            }

            int cmp = key.compareTo(start.key);

            if (cmp == 0) {
                return Optional.of(start);
            } else if (cmp < 0) {
                return findChild(start.left, key);
            } else {
                return findChild(start.right, key);
            }
        }

        private void clear() {
            if (this.left != null) {
                left.clear();
            }

            if (this.right != null) {
                right.clear();
            }

            left = right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTreeSymbolTable() {
        root = null;
    }

    @Override
    public void put(K key, V value) {
        Node emplaced = new Node(key, value);
        if (empty()) {
            root = emplaced;
        } else {
            root.addChild(emplaced);
        }

        size++;
    }

    @Override
    public V get(K key) {
        Optional<Node> result = root.findChild(key);
        if (result.isPresent()) {
            return result.get().value;
        }

        throw new NoSuchElementException();
    }

    @Override
    public boolean contains(K key) {
        if (empty()) {
            return false;
        }

        Optional<Node> result = root.findChild(key);

        return result.isPresent();
    }

    @Override
    public void delete(K key) {
        // For now, we won't worry about it.
    }

    @Override
    public void clear() {
        // The JVM should clear all this memory by itself, but doing so explicitly helps us to reason about memory more
        // easily, and also makes it more similar to other languages.
        root.clear();
        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return empty();
    }

    private boolean empty() {
        return root == null;
    }

    private List<Node> allChildren(Node root) {
        if (root == null) {
            throw new NullPointerException();
        }

        return allChildren(new ArrayList<>(), root);
    }

    private List<Node> allChildren(List<Node> acc, Node root) {
        if (root == null) {
            return acc;
        }

        acc.add(root);

        if (root.left != null) {
            return allChildren(acc, root.left);
        }

        if (root.right != null) {
            return allChildren(acc, root.right);
        }

        return acc;
    }
}
