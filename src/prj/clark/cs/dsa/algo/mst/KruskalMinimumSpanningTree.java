package prj.clark.cs.dsa.algo.mst;

import prj.clark.cs.dsa.struct.queue.Queue;
import prj.clark.cs.dsa.struct.queue.WrapperQueue;
import prj.clark.cs.dsa.struct.graph.Edge;
import prj.clark.cs.dsa.struct.graph.EdgeWeightedGraph;
import prj.clark.cs.dsa.struct.queue.MinimumPriorityQueue;
import prj.clark.cs.dsa.struct.queue.PriorityQueue;
import prj.clark.cs.dsa.struct.union.UnionFind;
import prj.clark.cs.dsa.struct.union.WeightedQuickUnionFind;

import java.util.function.Supplier;

public class KruskalMinimumSpanningTree implements MinimumSpanningTree {
    private Queue<Edge> minimumSpanningTree;
    private double weight;

    /* This is a lazy hack, literally. This won't get called until object creation, so we're fine to rely on methods
     * that require the object to be in a complete state. Essentially, we initialize the value, then swap out the
     * supplier for something that returns that calculated value directly. Since this object is effectively final, it
     * doesn't matter a whole lot if this gets invoked while currently executing, as the calculated value will still
     * be the same.
     */
    private Supplier<String> representation = () -> {
        String rep = stringify();
        representation = () -> rep;
        return rep;
    };

    /**
     * Creates a new spanning tree utilizing the greedy Kruskal algorithm implementation.
     *
     * @param g the mst from which the MST is to be formed.
     */
    public KruskalMinimumSpanningTree(EdgeWeightedGraph g) {
        minimumSpanningTree = new WrapperQueue<>();
        PriorityQueue<Edge> minPQ = MinimumPriorityQueue.create();
        g.edges().forEach(minPQ::insert);
        UnionFind uf = new WeightedQuickUnionFind(g.getVertices());

        while (!minPQ.isEmpty() && minimumSpanningTree.size() < g.getVertices() - 1) {
            Edge e = minPQ.deleteHead();
            int v = e.either();
            int w = e.other(v);

            if (uf.connected(v, w)) {
                // Ignore it.
                continue;
            }

            uf.makeUnion(v, w);

            minimumSpanningTree.enqueue(e);

            // Each edge is added once, so the weight of the minimum spanning tree is simply the sum of the weight of
            // the added edges.
            weight += e.weight();
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return minimumSpanningTree;
    }

    @Override
    public double weight() {
        return weight;
    }

    private String stringify() {
        StringBuilder sb = new StringBuilder();
        edges().forEach(x -> {
            sb.append(x);
            sb.append(", ");
        });
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" : Total Weight - ");
        sb.append(weight);
        return sb.toString();
    }

    @Override
    public String toString() {
        return representation.get();
    }
}
