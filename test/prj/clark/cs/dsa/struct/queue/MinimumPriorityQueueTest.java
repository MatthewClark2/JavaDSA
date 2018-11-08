package prj.clark.cs.dsa.struct.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MinimumPriorityQueueTest {
    private PriorityQueue<Integer> pq;

    @Before
    public void setUp() {
        pq = MinimumPriorityQueue.create();
    }

    @Test
    public void newPQEmpty() {
        assertTrue(pq.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyPeekThrows() {}

    @Test(expected = NoSuchElementException.class)
    public void emptyRemoveThrows() {}

    @Test
    public void headUpdatesCorrectly() {
        pq.insert(5);
        assertEquals((Integer) 5, pq.head());

        pq.insert(4);
        assertEquals((Integer) 4, pq.head());

        pq.insert(6);
        assertEquals((Integer) 4, pq.head());

        pq.insert(2);
        assertEquals((Integer) 2, pq.head());
    }

    @Test
    public void removingHeadUpdatesCorrectly() {
        pq.insert(5);
        pq.insert(4);
        pq.insert(6);
        pq.insert(3);
        pq.insert(2);

        assertEquals((Integer) 2, pq.deleteHead());
        assertEquals((Integer) 3, pq.deleteHead());
        assertEquals((Integer) 4, pq.deleteHead());
        assertEquals((Integer) 5, pq.deleteHead());
        assertEquals((Integer) 6, pq.deleteHead());
    }

    @Test
    public void innerSizeUpdates() {
        for (int i = 0; i < 100; ++i) {
            assertEquals(i, pq.size());
            pq.insert(i);
        }

        for (int i = 0; i < 100; ++i) {
            assertEquals(100 - i, pq.size());
            assertEquals((Integer) i, pq.deleteHead());
        }
    }
}