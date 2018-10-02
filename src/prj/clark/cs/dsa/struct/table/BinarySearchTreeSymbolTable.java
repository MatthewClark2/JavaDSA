package prj.clark.cs.dsa.struct.table;

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
    }

    private Node root;
    private int size;

    public BinarySearchTreeSymbolTable() {
        root = null;
    }

    private Optional<Node> findChild(Node node, K key) {
        if (node == null) {
            return Optional.empty();
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return findChild(node.left, key);
        } else if (cmp > 0) {
            return findChild(node.right, key);
        }

        return Optional.of(node);
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
        size++;
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    @Override
    public V get(K key) {
        Optional<Node> result = findChild(root, key);

        if (result.isPresent()) {
            return result.get().value;
        }

        throw new NoSuchElementException();
    }

    @Override
    public boolean contains(K key) {
        return findChild(root, key).isPresent();
    }

    @Override
    public void delete(K key) {
        if (contains(key)) {
            size--;

            root = delete(key, root);
        }
    }

    private Node delete(K key, Node node) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = delete(key, node.left);
        } else if (cmp > 0) {
            node.right = delete(key, node.right);
        } else {
            // If there is only one subtree, just return that.
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            }

            // Otherwise, start moving the node.
            Node copy = node;

            // Find the minimum viable node from the right subtree to ensure that all elements are still correctly
            // placed.
            node = min(copy.right);

            // Finds the parent of the smallest node on the right subtree.
            node.right = deleteMin(key, copy.right);

            // Update the left regularly.
            node.left = copy.left;
        }

        return node;
    }

    private Node deleteMin(K key, Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(key, node);
        return node;
    }

    private Node min(Node start) {
        if (start.left == null) {
            return start;
        }

        return min(start.left);
    }

    @Override
    public void clear() {
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
}
