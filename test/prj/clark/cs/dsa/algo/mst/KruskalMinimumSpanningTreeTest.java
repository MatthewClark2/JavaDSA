package prj.clark.cs.dsa.algo.mst;

import static org.junit.Assert.*;

import org.junit.Test;
import prj.clark.cs.dsa.struct.graph.Edge;
import prj.clark.cs.dsa.struct.graph.EdgeWeightedGraph;

public class KruskalMinimumSpanningTreeTest {
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
    public void basicGraphMST() {
        EdgeWeightedGraph g = new EdgeWeightedGraph(10);

        g.addEdge(edge(0, 1, 1));
        g.addEdge(edge(1, 2, 3));
        g.addEdge(edge(2, 3, 9));
        g.addEdge(edge(3, 4, 2));
        g.addEdge(edge(4, 5, 4));
        g.addEdge(edge(5, 6, 19));
        g.addEdge(edge(0, 7, 9));
        g.addEdge(edge(0, 6, 5));
        g.addEdge(edge(3, 7, 11));
        g.addEdge(edge(4, 7, 7));
        g.addEdge(edge(4, 6, 21));
        g.addEdge(edge(1, 7, 12));

        MinimumSpanningTree mst = new KruskalMinimumSpanningTree(g);
        assertEquals(24, mst.weight(), 0);
    }
}