package prj.clark.cs.dsa.algo.mst;

import prj.clark.cs.dsa.struct.graph.Edge;

public interface MinimumSpanningTree {
    Iterable<Edge> edges();
    double weight();
}
