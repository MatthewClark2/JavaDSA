package prj.clark.cs.dsa.algo.select;

import java.util.Comparator;

public interface Selector {
    /**
     * Obtain the nth smallest element of an unsorted array. Note that this method makes no guarantees that the
     * underlying array will not be implemented. Additionally, duplicate values not accounted for. Should this behavior
     * be required, this does not fulfill that role.
     * @param items the array of elements to be parsed.
     * @param n corresponds to the nth smallest desired element. This should be zero-indexed.
     * @param <T> the type of element being used. If a {@link Comparator} is not provided, this type must extend
     * {@link Comparable<T>}.
     * @return the nth largest element.
     * @throws IllegalArgumentException if n is negative or greater than the size of the array.
     */
    <T extends Comparable<T>> T nthSmallest(T[] items, int n);

    <T> T nthSmallest(T[] items, int n, Comparator<T> cmp);
}
