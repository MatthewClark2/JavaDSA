package prj.clark.cs.dsa.algo.sort.priority;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class UnorderedArrayPriorityQueueTest {
    private PriorityQueue<Integer> pq;

    @Before
    public void setUp() {
        pq = new UnorderedArrayPriorityQueue<>();
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyGetThrowsException() {
        pq.max();
    }

    @Test
    public void singleElementIsMax() {
        pq.insert(5);

        assertEquals((Integer) 5, pq.max());
    }

    @Test
    public void largestInsertionIsMax() {
        pq.insert(5);
        pq.insert(12);
        pq.insert(7);

        assertEquals((Integer) 12, pq.max());
    }

    @Test
    public void removingLargestChangesMax() {
        pq.insert(12);
        pq.insert(8);

        assertEquals((Integer) 12, pq.delMax());
        assertEquals((Integer) 8, pq.max());
    }

    @Test
    public void maxAndDelMaxSame() {
        pq.insert(0);

        assertEquals((Integer) 0, pq.max());
        assertEquals((Integer) 0, pq.delMax());
    }

    @Test
    public void newPriorityQueueEmpty() {
        assertTrue(pq.isEmpty());
    }

    @Test
    public void insertionMakesPriorityQueueNonEmpty() {
        pq.insert(1);

        assertFalse(pq.isEmpty());
    }

    @Test
    public void exhaustionMakesPriorityQueueEmpty() {
        pq.insert(1);
        pq.insert(2);

        assertFalse(pq.isEmpty());
        pq.delMax();

        assertFalse(pq.isEmpty());
        pq.delMax();

        assertTrue(pq.isEmpty());
    }

    @Test
    public void priorityQueueCanBeResizedUp() {
        for (int i = 0; i < 10000; ++i) {
            pq.insert(i);
        }
    }
}