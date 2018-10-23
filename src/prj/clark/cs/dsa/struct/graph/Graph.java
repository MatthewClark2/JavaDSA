package prj.clark.cs.dsa.struct.graph;

import java.util.NoSuchElementException;

// Note that both implementations are reliant on hashing to make the generics work. This has to stop due to the risk of
// a single hash collision breaking the entire implementation. This is likely to be overlooked in small examples, but
// will become painfully obvious as they grow.
public interface Graph<E> {
    /**
     * Add an edge between two nodes.
     * @param e1 first element
     * @param e2 second element
     */
    void addEdge(E e1, E e2);

    /**
     * Obtain an iterator of vertices connected to e.
     * @param e the node on the graph being searched.
     * @return an iterator of vertices.
     * @throws NoSuchElementException if the node is not in the graph.
     */
    Iterable<E> adjacent(E e);

    /**
     * Get the number of vertices.
     * @return the number of vertices.
     */
    int vertices();

    /**
     * Get the number of edges.
     * @return the number of edges.
     */
    int edges();
}
