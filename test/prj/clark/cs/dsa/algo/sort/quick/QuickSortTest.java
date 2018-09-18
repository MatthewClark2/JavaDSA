package prj.clark.cs.dsa.algo.sort.quicksort;

import org.junit.Test;
import prj.clark.cs.dsa.algo.sort.Sorter;
import prj.clark.cs.dsa.algo.sort.quick.QuickSort;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;

public class QuickSortTest {
    private Sorter getSorter() {
        return new QuickSort();
    }

    private static <T extends Comparable<T>> void sorted(T[] elems) {
        if (elems.length > 1) {
            T curr = elems[0];
            for (T elem : elems) {
                assertTrue("Expected something less than " + curr + ". Found " + elem,
                        curr.compareTo(elem) <= 0);
                curr = elem;
            }
        }
    }

    @Test
    public void emptyArraySorted() {
        String[] strs = new String[]{};
        getSorter().sort(strs, Comparator.naturalOrder());

        sorted(strs);
    }

    @Test
    public void orderedArraySorted() {
        String[] strs = new String[]{"a", "b", "c"};
        getSorter().sort(strs, Comparator.naturalOrder());

        sorted(strs);
    }

    @Test
    public void singleElementSorted() {
        String[] strs = new String[]{"a"};
        getSorter().sort(strs, Comparator.naturalOrder());

        sorted(strs);
    }

    @Test
    public void reversedElementsSorted() {
        String[] strs = new String[]{"c", "b", "a"};
        getSorter().sort(strs, Comparator.naturalOrder());

        sorted(strs);
    }

    @Test
    public void randomElementsSorted() {
        String[] strs = new String[]{"d", "a", "g", "r", "b", "b"};
        getSorter().sort(strs, Comparator.naturalOrder());

        sorted(strs);
    }
}