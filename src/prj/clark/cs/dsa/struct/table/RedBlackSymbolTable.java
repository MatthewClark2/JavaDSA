package prj.clark.cs.dsa.struct.table;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Balanced implementation of the {@link BinarySearchTreeSymbolTable}. This works similarly to a
 * Two-Three Symbol Table, but uses "red" links as glue instead of directly joining nodes to form three nodes due
 * to the complexity of representation.
 * Red links follow given rules:
 * - No node has two red links.
 * - Every path from the root to a terminal node has the same number of black links.
 * - Red links lean left.
 * Search is equivalent.
 * @param <K> type of the key in entry pairs.
 * @param <V> type of the value stored by each key.
 */
public class RedBlackSymbolTable<K extends Comparable<K>, V> implements SymbolTable<K, V> {
    private enum Color { RED, BLACK }

    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        // Refers to the color of the parent link.
        Color color;

        Node(K key, V value, Color color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private Node root;
    private int size;

    private boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    /**
     * If a right leaning red node is produced, it must be shifted into becoming a left leaning tree.
     * @param node the left node of an offending right leaning red pair.
     * @return the new root after rotation.
     */
    private Node rotateLeft(Node node) {
        assert isRed(node.right);

        // Move the nodes by copying the appropriate values.
        Node root = node.right;
        node.right = root.left;
        root.left = node;
        root.color = node.color;

        // We only rotate "glued" nodes, so we have to set the color appropriately.
        node.color = Color.RED;

        // Return the new root of the rotation.
        return root;
    }

    private Node rotateRight(Node node) {
        assert isRed(node.left);

        Node root = node.left;
        node.left = root.right;
        root.right = node;
        root.color = node.color;
        node.color = Color.RED;

        return root;
    }

    /**
     * This is done to split up a temporarily created 4 node.
     * @param node the node whose colors are to be flipped.
     */
    private void flipColors(Node node) {
        assert !isRed(node);
        assert isRed(node.left);
        assert isRed(node.right);

        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
        root.color = Color.BLACK;
        size++;
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value, Color.RED);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        // Here's all the new RB tree stuff for management.
        // Each of the following conditions can occur while attempting to fix the structure of the tree. Note that the
        // order is important in this case.
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    @Override
    public V get(K key) {
        Optional<Node> result = find(root, key);

        if (result.isPresent()) {
            return result.get().value;
        }

        throw new NoSuchElementException();
    }

    private Optional<Node> find(Node node, K key) {
        if (node == null) {
            return Optional.empty();
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return find(node.left, key);
        } else if (cmp > 0) {
            return find(node.right, key);
        } else {
            return Optional.of(node);
        }
    }

    @Override
    public boolean contains(K key) {
        return find(root, key).isPresent();
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
            node.right = deleteMin(copy.right);

            // Update the left regularly.
            node.left = copy.left;

            // RBT rebalancing.
            if (isRed(node.right) && !isRed(node.left)) {
                node = rotateLeft(node);
            }

            if (isRed(node.left) && isRed(node.left.left)) {
                flipColors(node);
            }

            if (isRed(node.left) && isRed(node.right)) {
                node = rotateRight(node);
            }
        }

        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node);
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
        // The garbage collector will eventually clear out all old references.
        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}
