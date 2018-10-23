package prj.clark.cs.dsa.struct.graph;

import prj.clark.cs.dsa.struct.bag.Bag;
import prj.clark.cs.dsa.struct.bag.StackBag;

/**
 * This class is useful for sparse, undirected graph implementations. Densely packed graphs may
 * prefer a matrix backed implementation.
 * This implementation is undirected.
 */
public class AdjacencyListGraph implements Graph {
    private final int vertices;
    private int edges;
    private Bag<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public AdjacencyListGraph(int vertices) {
        this.vertices = vertices;
        adj = (Bag<Integer>[]) (new Object[vertices]);
        for (int i = 0; i < adj.length; ++i) {
            adj[i] = new StackBag<>();
        }
    }

    @Override
    public void addEdge(int a, int b) {
        adj[hash(a)].add(b);
        adj[hash(b)].add(a);
        edges++;
    }

    @Override
    public int getVertices() {
        return vertices;
    }

    @Override
    public int getEdges() {
        return edges;
    }

    @Override
    public Iterable<Integer> adjacent(int e) {
        return adj[hash(e)];
    }

    private int hash(int k) {
        return (k & 0x1fffffff) % vertices;
    }
}
