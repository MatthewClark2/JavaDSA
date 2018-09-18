package prj.clark.cs.dsa.algo.sort.merge;

import prj.clark.cs.dsa.algo.sort.Sorter;

import java.util.Comparator;

public class MergeSort implements Sorter {
    private void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; ++k) {
            // Copy a into aux.
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] objs) {

    }

    @Override
    public <T> void sort(T[] objs, Comparator<T> cmp) {

    }
}
