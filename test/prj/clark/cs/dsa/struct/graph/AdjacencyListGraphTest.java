package prj.clark.cs.dsa.struct.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class AdjacencyListGraphTest {
    private Graph g;
    private static final int VERTICES = 20;

    private static <T> boolean contains(Iterable<T> iter, T key) {
        for (T t : iter) {
            if (t.equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Before
    public void setUp() {
        g = new AdjacencyListGraph(VERTICES);
    }

    @Test
    public void makingLinksDoesNotFail() {
        g.addEdge(0, 1);
        assertTrue(contains(g.adjacent(0), 1));
        assertTrue(contains(g.adjacent(1), 0));

        g.addEdge(5, 12);
        assertTrue(contains(g.adjacent(5), 12));
        assertTrue(contains(g.adjacent(12), 5));
    }

    @Test(expected = NoSuchElementException.class)
    public void negativeVerticesFail() {
        g.addEdge(-1, 2);
    }

    @Test(expected = NoSuchElementException.class)
    public void tooLargeVerticesFail() {
        g.addEdge(5, VERTICES + 1);
    }
}