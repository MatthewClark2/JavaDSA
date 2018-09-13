package prj.clark.cs.dsa.algo.sort;

import java.util.Collections;
import java.util.Comparator;

public interface Sorter {
    <T, U extends Comparable<T>> void sort(U[] objs);
    <T> void sort(T[] objs, Comparator<T> cmp);
}
