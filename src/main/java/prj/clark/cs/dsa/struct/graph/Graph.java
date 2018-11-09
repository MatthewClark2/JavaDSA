package prj.clark.cs.dsa.struct.graph;

import java.util.NoSuchElementException;

// Note that both implementations are reliant on hashing to make the generics work. This has to stop due to the risk of
// a single hash collision breaking the entire implementation. This is likely to be overlooked in small examples, but
// will become painfully obvious as they grow.
public interface Graph {
    /**
     * Add an edge between two nodes.
     * @param e1 first element
     * @param e2 second element
     */
    void addEdge(int a, int b);

    /**
     * Obtain an iterator of getVertices connected to e.
     * @param e the node on the mst being searched.
     * @return an iterator of getVertices.
     * @throws NoSuchElementException if the node is not in the mst.
     */
    Iterable<Integer> adjacent(int e);

    /**
     * Get the number of getVertices.
     * @return the number of getVertices.
     */
    int getVertices();

    /**
     * Get the number of getEdges.
     * @return the number of getEdges.
     */
    int getEdges();
}
