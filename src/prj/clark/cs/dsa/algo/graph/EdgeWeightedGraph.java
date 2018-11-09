package prj.clark.cs.dsa.algo.graph;

import prj.clark.cs.dsa.struct.bag.Bag;
import prj.clark.cs.dsa.struct.bag.StackBag;

import java.util.NoSuchElementException;

public class EdgeWeightedGraph {
    private final int vertices;
    private int edges;

    private Bag<Edge>[] adjacencyLists;

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adjacencyLists = (Bag<Edge>[]) (new Bag[vertices]);
        for (int i = 0; i < vertices; ++i) {
            adjacencyLists[i] = new StackBag<>();
        }
    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public void addEdge(Edge e) {
        validate(e);

        int i = e.either();
        int j = e.other(i);

        adjacencyLists[i].add(e);
        adjacencyLists[j].add(e);

        edges++;
    }

    public Iterable<Edge> adjacents(int k) {
        validate(k);
        return adjacencyLists[k];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> edges = new StackBag<>();
        for (int i = 0; i < vertices; ++i) {
            for (Edge e : adjacencyLists[i]) {
                if (e.other(i) > i) {
                    edges.add(e);
                }
            }
        }

        return edges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        edges().forEach(x -> {
            sb.append(x);
            sb.append(", ");
        });

        sb.delete(sb.length() - 2, sb.length());

        return sb.toString();
    }

    private void validate(Edge e) {
        int i = e.either();
        int k = e.other(i);

        validate(i);
        validate(k);
    }

    private void validate(int k) {
        if (k < 0 || k >= vertices) {
            throw new NoSuchElementException();
        }
    }
}
