package prj.clark.cs.dsa.algo.sort.quick;

import prj.clark.cs.dsa.algo.sort.Sorter;

import java.util.Comparator;

public class QuickSort implements Sorter {
    @Override
    public <T, U extends Comparable<T>> void sort(U[] objs) {

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
        while (true) {
            while (less(cmp, a[++i], a[lo]) && i != hi);  // Find item on left to swap.
            while (less(cmp, a[--j], a[lo]) && j != lo);  // Find item on right to swap.

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
