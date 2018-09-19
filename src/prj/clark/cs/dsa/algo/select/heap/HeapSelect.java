package prj.clark.cs.dsa.algo.select.heap;

import prj.clark.cs.dsa.algo.select.Selector;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSelect implements Selector {

    @Override
    public <T extends Comparable<T>> T nthSmallest(T[] items, int n) {
        return nthSmallest(items, n, Comparator.naturalOrder());
    }

    @Override
    public <T> T nthSmallest(T[] items, int n, Comparator<T> cmp) {
        ensureValid(items, n);
        // We use Java's built in priority queue because our current one does not support Comparators. It also has the
        // convenience of sorting smaller elements at the head as opposed to larger ones.
        PriorityQueue<T> pq = new PriorityQueue<>(cmp);

        Collections.addAll(pq, items);

        for (int i = 0; i < n; ++i) {
            pq.poll();
        }

        return pq.poll();
    }

    private static void ensureValid(Object[] objs, int n) {
        if (n < 0 || n >= objs.length) {
            throw new IllegalArgumentException();
        }
    }
}
