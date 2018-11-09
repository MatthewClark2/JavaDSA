package prj.clark.cs.dsa.struct.graph;

import prj.clark.cs.dsa.struct.bag.Bag;
import prj.clark.cs.dsa.struct.bag.StackBag;

import java.util.NoSuchElementException;

/**
 * This class is useful for sparse, undirected mst implementations. Densely packed graphs may
 * prefer a matrix backed implementation.
 * This implementation is undirected.
 */
public class AdjacencyListGraph implements Graph {
    private final int vertices;
    private int edges;
    private Bag<Integer>[] adj;

    /**
     * Creates a new Adjacency list mst with serialized integers as nodes.
     * @param vertices the number of available vertices. Available vertices to make connections between range from 0 to
     *                 this value minus 1.
     */

    @SuppressWarnings("unchecked")
    public AdjacencyListGraph(int vertices) {
        this.vertices = vertices;
        adj = (Bag<Integer>[]) (new Bag[vertices]);
        for (int i = 0; i < adj.length; ++i) {
            adj[i] = new StackBag<>();
        }
    }

    @Override
    public void addEdge(int a, int b) {
        validateVertex(a);
        validateVertex(b);
        adj[a].add(b);
        adj[b].add(a);
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
        validateVertex(e);
        return adj[e];
    }

    private void validateVertex(int a) {
        if (a >= vertices || a < 0) {
            throw new NoSuchElementException();
        }
    }
}
