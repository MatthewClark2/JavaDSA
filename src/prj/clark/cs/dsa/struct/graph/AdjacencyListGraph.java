package prj.clark.cs.dsa.struct.graph;

import prj.clark.cs.dsa.struct.bag.Bag;

/**
 * This class is useful for sparse, undirected graph implementations. Densely packed graphs may
 * prefer a matrix backed implementation.
 * This implementation is undirected.
 * @param <E>
 */
public class AdjacencyListGraph<E> implements Graph<E> {
    private final int vertices;

    // For the sake of generics, this will act like a poor man's hashmap.
    private Bag<E>[] adj;

    @SuppressWarnings("unchecked")
    public AdjacencyListGraph(int vertices) {
        this.vertices = vertices;
        adj = (Bag<E>[]) (new Object[vertices]);
    }

    @Override
    public void addEdge(E e1, E e2) {

    }

    @Override
    public Iterable<E> adjacent(E e) {
        return null;
    }

    @Override
    public int vertices() {
        return 0;
    }

    @Override
    public int edges() {
        return 0;
    }

    private int hash(E e) {
        return (e.hashCode() & 0x1fffffff) % vertices;
    }
}
