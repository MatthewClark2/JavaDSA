package prj.clark.cs.dsa.algo.mst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import prj.clark.cs.dsa.struct.graph.Edge;
import prj.clark.cs.dsa.struct.graph.EdgeWeightedGraph;

import java.util.HashSet;
import java.util.Set;

public class KruskalMinimumSpanningTreeTest {
    private EdgeWeightedGraph graph;

    @Before
    public void setUp() {
        graph = new EdgeWeightedGraph(6);
        graph.addEdge(edge(0, 1, 2));
        graph.addEdge(edge(1, 3, 1));
        graph.addEdge(edge(3, 5, 5));
        graph.addEdge(edge(4, 5, 2));
        graph.addEdge(edge(0, 2, 3));
        graph.addEdge(edge(1, 2, 2));
        graph.addEdge(edge(2, 3, 7));
        graph.addEdge(edge(2, 4, 4));
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
        MinimumSpanningTree mst = new KruskalMinimumSpanningTree(graph);
        assertEquals(11, mst.weight(), 0);
    }

    @Test
    public void basicGraphMSTEdges() {
        MinimumSpanningTree mst = new KruskalMinimumSpanningTree(graph);

        Set<Edge> expected = new HashSet<>();

        expected.add(edge(0, 1, 2));
        expected.add(edge(1, 2, 2));
        expected.add(edge(1, 3, 1));
        expected.add(edge(2, 4, 4));
        expected.add(edge(4, 5, 2));

        for (Edge e : mst.edges()) {
            assertTrue(expected.contains(e));
            expected.remove(e);
        }

        assertEquals(0, expected.size());
    }
}
