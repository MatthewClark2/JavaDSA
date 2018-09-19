package prj.clark.cs.dsa.algo.sort.priority;

import java.util.NoSuchElementException;

// Note that the class is a glorified binary heap.
public class UnorderedArrayPriorityQueue<K extends Comparable<K>> implements PriorityQueue<K> {
    private static final double MINIMUM_LOAD = 0.25;
    private static final double MAXIMUM_LOAD = 1.0;
    private static final int MINIMUM_CAPACITY = 16;

    // Common representation is a heap structure. The parent of a node at point k is at k/2.
    // The children of a node positioned at k are at 2k and 2k+1 respectively.
    // Parents are larger than both of their children. There is no ordering to the children.
    // For the sake of simplicity, we begin at index 1, and waste index 0.
    private K[] elems;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public UnorderedArrayPriorityQueue() {
        capacity = MINIMUM_CAPACITY;
        size = 0;
        elems = (K[]) new Comparable[capacity];
    }

    @Override
    public K max() {
        ensureNonEmpty();
        return elems[1];
    }

    @Override
    public void insert(K value) {
        if (sizeRatio() >= MAXIMUM_LOAD) {
            resizeBuffer((capacity *= 2));
        }

        // Add the node at the end, and then push it up.
        // Increment first due to the 1 indexing.
        elems[++size] = value;
        raise(size);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public K delMax() {
        ensureNonEmpty();
        K max = elems[1];

        // Exchange the root with the end, and then sink the new root back down.
        exch(1, size);
        sink(1);

        // Prevent loitering.
        elems[size--] = null;

        if (capacity > MINIMUM_CAPACITY && sizeRatio() <= MINIMUM_LOAD) {
            resizeBuffer((capacity /= 2));
        }

        return max;
    }

    private void exch(int a, int b) {
        K tmp = elems[a];
        elems[a] = elems[b];
        elems[b] = tmp;
    }

    private void sink(int k) {
        int j;
        while ((j = 2*k) <= size) {
            if (j < size && less(j, j+ 1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            k = j;
        }
    }

    private void raise(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k /= 2;
        }
    }

    private boolean less(int a, int b) {
        return elems[a].compareTo(elems[b]) < 0;
    }

    @SuppressWarnings("unchecked")
    private void resizeBuffer(int newSize) {
        K[] copy = (K[]) new Comparable[newSize];
        System.arraycopy(elems, 0, copy, 0, Math.min(elems.length, newSize));

        elems = copy;
    }

    private double sizeRatio() {
        return ((double) size + 1) / capacity;
    }

    private void ensureNonEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }
}
