package prj.clark.cs.dsa.algo.mst;

import org.junit.Test;
import prj.clark.cs.dsa.struct.graph.Edge;
import prj.clark.cs.dsa.struct.graph.EdgeWeightedGraph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.Assert.*;

public class EdgeWeightedGraphTest {
    EdgeWeightedGraph g;

    private static Edge edge(int v, int w, double weight) {
        return new Edge(v, w, weight);
    }

    public void init(int vertices) {
        g = new EdgeWeightedGraph(vertices);
    }

    @Test
    public void emptyGraphHasNoEdges() {
        for (int i = 0; i < 10; ++i) {
            init(i);
            assertEquals(0, g.getEdges());
        }
    }

    @Test
    public void addingEdgesIncreasesEdgeCount() {
        init(20);

        assertEquals(0, g.getEdges());
        g.addEdge(edge(1, 3, 1.5));

        assertEquals(1, g.getEdges());
        g.addEdge(edge(3, 19, 12.7));

        assertEquals(2, g.getEdges());
    }

    @Test
    public void adjacentProducesCorrectValues() {
        Edge[] data = {
                edge(1, 3, 1.0),
                edge(1, 4, 1.0),
                edge(1, 2, 1.0),
                edge(1, 10, 1.0)
        };

        Set<Edge> expected = new HashSet<>(Arrays.asList(data));

        init(11);
        for (Edge e : data) {
            g.addEdge(e);
        }

        // Add some garbage data.
        g.addEdge(edge(5, 6, 1.2));
        g.addEdge(edge(7, 9, 2.3));

        for (Edge e : g.adjacents(1)) {
            assertTrue(expected.contains(e));
            expected.remove(e);
        }

        assertEquals(0, expected.size());
    }

    @Test
    public void edgesYieldsAllEdgesOnce() {
        Edge[] data = {
                edge(1, 2, 3.0),
                edge(2, 5, 1.7),
                edge(12, 8, 0.4),
                edge(1, 7, 7.2),
                edge(4, 3, 0.1)
        };

        Set<Edge> expected = new HashSet<>();
        init(13);

        for (Edge e : data) {
            g.addEdge(e);
            expected.add(e);
        }

        for (Edge e : g.edges()) {
            assertTrue(expected.contains(e));
            expected.remove(e);
        }

        assertEquals(0, expected.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void invalidEdgeThrowsException() {
        init(10);
        g.addEdge(edge(10, -1, 0.0));
    }

    @Test(expected = NoSuchElementException.class)
    public void invalidAdjacentCheckThrowsException() {
        init(10);
        g.adjacents(10);
    }

    @Test(expected = NoSuchElementException.class)
    public void negativeAdjacentCheckThrowsException() {
        init(1);
        g.adjacents(-1);
    }

    @Test
    public void emptyAdjacentIterableHasNoElements() {
        init(5);
        g.addEdge(edge(1, 2, 1.0));
        g.addEdge(edge(2, 3, 9.0));

        assertFalse(g.adjacents(4).iterator().hasNext());
    }
}