package prj.clark.cs.dsa.algo.select.heap;

import org.junit.Before;
import org.junit.Test;
import prj.clark.cs.dsa.algo.select.Selector;

import static org.junit.Assert.*;

public class HeapSelectTest {
    private Selector selector;

    @Before
    public void setUp() {
        selector = new HeapSelect();
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptySelectThrowsException() {
        selector.nthSmallest(new Integer[0], 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeSmallestThrowsException() {
        selector.nthSmallest(new Integer[0], -1);
    }

    @Test
    public void sortedElementsWork() {
        Integer[] data = new Integer[]{1, 2, 3};
        assertEquals((Integer) 1, selector.nthSmallest(data, 0));
    }

    @Test
    public void reversedElementsWork() {
        Integer[] data = new Integer[]{5, 4, 3, 2, 1};
        assertEquals((Integer) 2, selector.nthSmallest(data, 1));
    }

    @Test
    public void shuffledElementsWork() {
        Integer[] data = new Integer[]{16, 9, -3, 0, 11, 3};
        assertEquals((Integer) 0, selector.nthSmallest(data, 1));
    }

    @Test
    public void linearCheckOfAllElements() {
        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6};

        for (Integer i : data) {
            assertEquals((Integer) i, selector.nthSmallest(data, i - 1));
        }
    }
}