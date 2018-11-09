package prj.clark.cs.dsa.algo.sort;

import java.util.Comparator;

public interface Sorter {
    <T extends Comparable<T>> void sort(T[] objs);
    <T> void sort(T[] objs, Comparator<T> cmp);
}
