package prj.clark.cs.dsa.algo.mst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import prj.clark.cs.dsa.struct.graph.Edge;
import prj.clark.cs.dsa.struct.graph.EdgeWeightedGraph;

import java.util.HashSet;
import java.util.Set;

public class KruskalMinimumSpanningTreeTest {
    private EdgeWeightedGraph graphA;
    private EdgeWeightedGraph graphB;

    @Before
    public void setUp() {
        // This wastes time, but avoids any mutation between tests throwing off results.
        graphA = new EdgeWeightedGraph(8);
        graphA.addEdge(edge(0, 1, 1));
        graphA.addEdge(edge(1, 2, 3));
        graphA.addEdge(edge(2, 3, 9));
        graphA.addEdge(edge(3, 4, 2));
        graphA.addEdge(edge(4, 5, 4));
        graphA.addEdge(edge(5, 6, 19));
        graphA.addEdge(edge(0, 7, 9));
        graphA.addEdge(edge(0, 6, 5));
        graphA.addEdge(edge(3, 7, 11));
        graphA.addEdge(edge(4, 7, 7));
        graphA.addEdge(edge(4, 6, 21));
        graphA.addEdge(edge(1, 7, 12));

        graphB = new EdgeWeightedGraph(6);
        graphB.addEdge(edge(0, 1, 2));
        graphB.addEdge(edge(1, 3, 1));
        graphB.addEdge(edge(3, 5, 5));
        graphB.addEdge(edge(4, 5, 2));
        graphB.addEdge(edge(0, 2, 3));
        graphB.addEdge(edge(1, 2, 2));
        graphB.addEdge(edge(2, 3, 7));
        graphB.addEdge(edge(2, 4, 4));
    }

    private static Edge edge(int w, int v, double weight) {
        return new Edge(v, w, weight);
    }

    @Test
    public void edgelessGraphProducesZeroWeightMST() {
        EdgeWeightedGraph g = new EdgeWeightedGraph(100);
        MinimumSpanningTree mst = new KruskalMinimumSpanningTree(g);
        assertEquals(0.0, mst.weight(), 0);
    }

    @Test
    public void linearGraphMST() {
        EdgeWeightedGraph g = new EdgeWeightedGraph(20);

        g.addEdge(edge(0, 1, 0.5));
        g.addEdge(edge(1, 2, 1.0));
        g.addEdge(edge(2, 3, 2.5));

        MinimumSpanningTree mst = new KruskalMinimumSpanningTree(g);

        assertEquals(4.0, mst.weight(), 0);
    }

    @Test
    public void basicGraphMSTWeight() {
        MinimumSpanningTree mst = new KruskalMinimumSpanningTree(graphB);
        assertEquals(15, mst.weight(), 0);
    }

    @Test
    public void basicGraphMSTEdges() {
        MinimumSpanningTree mst = new KruskalMinimumSpanningTree(graphB);

        Set<Edge> expected = new HashSet<>();

        expected.add(edge(0, 1, 2));
        expected.add(edge(1, 3, 1));
        expected.add(edge(3, 5, 5));
        expected.add(edge(1, 2, 2));
        expected.add(edge(2, 4, 4));

        for (Edge e : mst.edges()) {
            assertTrue(expected.contains(e));
            expected.remove(e);
        }

        assertEquals(0, expected.size());
    }
}
