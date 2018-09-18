package prj.clark.cs.dsa.algo.sort.insert;

import prj.clark.cs.dsa.algo.sort.Sorter;

import java.util.Comparator;

public class InsertionSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] objs) {
        sort(objs, Comparator.naturalOrder());
    }

    @Override
    public <T> void sort(T[] objs, Comparator<T> cmp) {
        for (int i = 0; i < objs.length; ++i) {
            for (int j = i; j > 0; --j) {
                if (cmp.compare(objs[j], objs[j - 1]) < 0) {
                    exch(objs, j, j - 1);
                } else {
                    break;
                }
            }

            int k = i;
            while (k > 0 && cmp.compare(objs[k], objs[k - 1]) < 0) {
                exch(objs, k , --k);
            }
        }
    }

    private static <T> void exch(T[] objs, int a, int b) {
        T tmp = objs[a];
        objs[a] = objs[b];
        objs[b] = tmp;
    }
}
