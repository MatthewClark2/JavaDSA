package prj.clark.cs.dsa.algo.select.quick;

import prj.clark.cs.dsa.algo.select.Selector;

import java.util.Comparator;

public class QuickSelect implements Selector {
    // This class utilizes a partitioning algorithm identical to the one used in quick sort, and uses that to partially
    // sort an array to find the nth largest element.

    @Override
    public <T extends Comparable<T>> T nthSmallest(T[] items, int n) {
        return nthSmallest(items, n, Comparator.naturalOrder());
    }

    @Override
    public <T> T nthSmallest(T[] items, int n, Comparator<T> cmp) {
        ensureValid(items, n);

        int lo = 0;
        int hi = items.length - 1;

        while (hi > lo) {
            int j = partition(items, lo, hi, cmp);

            // We're at the correct position already.
            if (j == n) {
                return items[n];
            } else if (j > n) {
                // Our pivot it higher than the key, so we discard the upper portion.
                hi = j - 1;
            } else {
                // Likewise for the lower portion.
                lo = j + 1;
            }
        }

        // We've ended up sorting the array, so we just spit it back.
        return items[n];
    }

    private void ensureValid(Object[] objs, int n) {
        if (n < 0 || n >= objs.length) {
            throw new IllegalArgumentException();
        }
    }

    // Copied from QuickSort.
    private <T> int partition(T[] elems, int lo, int hi, Comparator<T> cmp) {
        int i = lo;
        int j = hi + 1;
        T init = elems[lo];

        while (true) {
            // Find the first value greater than the initial.
            while(less(elems[++i], init, cmp) && i != hi);

            // Find the first value lesser than the initial.
            while(less(init, elems[--j], cmp) && j != lo);

            // If the pointers crossed, then we're done swapping.
            if (i >= j) {
                break;
            }

            // Otherwise, swap them.
            exch(elems, i, j);
        }

        // Swap the initial position with the new pivot point.
        exch(elems, lo, j);

        return j;
    }

    private static <T> void exch(T[] elems, int pos1, int pos2) {
        T tmp = elems[pos1];
        elems[pos1] = elems[pos2];
        elems[pos2] = tmp;
    }

    private static <T> boolean less(T t1, T t2, Comparator<T> cmp) {
        return cmp.compare(t1, t2) < 0;
    }
}
