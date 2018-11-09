package prj.clark.cs.dsa.algo.sort.quick;

import prj.clark.cs.dsa.algo.sort.Sorter;

import java.util.Comparator;

/**
 * Quick sort is the de facto best sorting algorithm available for the general case. It works by using a divide and
 * conquer strategy, partitioning the array into somewhat organized subarrays until the array is in order. The average
 * running time is O(n log(n)), although the worst case is O(n^2). For this reason, you may see some implementations
 * initially shuffle the underlying array in order to avoid the worst case of a sorted array. There are also other
 * implementations that each have their own runtime quirks, but this is the classical rendition. The sort is done in
 * place, and is not stable.
 */
public class QuickSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] objs) {
        sort(objs, Comparator.naturalOrder());
    }

    @Override
    public <T> void sort(T[] a, Comparator<T> cmp) {
        quicksort(cmp, a, 0, a.length - 1);
    }

    private static <T> void quicksort(Comparator<T> cmp, T[] a, int lo, int hi) {
        if (lo >= hi) return;

        int j = partition(a, lo, hi, cmp);
        quicksort(cmp, a, lo, j - 1);
        quicksort(cmp, a, j + 1, hi);
    }

    private static<T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
        return partition(a, lo, hi, Comparator.naturalOrder());
    }

    private static <T> int partition(T[] a, int lo, int hi, Comparator<T> cmp) {
        int i = lo;
        int j = hi + 1;
        T init = a[lo];
        while (true) {
            while (less(cmp, a[++i], init) && i != hi);  // Find item on left to swap.
            while (less(cmp, init, a[--j]) && j != lo);  // Find item on right to swap.

            if (i >= j) break;  // Check if the two values have crossed.

            exchange(a, i, j);
        }

        exchange(a, lo, j);
        return j;
    }

    private static<T extends Comparable<T>> boolean less(T a, T b) {
        return less(Comparator.naturalOrder(), a, b);
    }

    private static<T> boolean less(Comparator<T> cmp, T a, T b) {
        return cmp.compare(a, b) < 0;
    }

    private static<T> void exchange(T[] elems, int a, int b) {
        T tmp = elems[a];
        elems[a] = elems[b];
        elems[b] = tmp;
    }
}
