package prj.clark.cs.dsa.struct.graph;

import prj.clark.cs.dsa.struct.stack.ArrayStack;
import prj.clark.cs.dsa.struct.stack.Stack;

import java.util.Iterator;

public class DepthFirstPaths implements Paths {
    private boolean[] marked;
    private int[] edgesTo;
    private final int origin;

    @SuppressWarnings("unchecked")
    public DepthFirstPaths(Graph g, int origin) {
        marked = new boolean[g.getVertices()];
        edgesTo = new int[g.getVertices()];
        this.origin = origin;

        depthFirstSearch(g, origin);
    }

    private void depthFirstSearch(Graph g, int origin) {
        marked[origin] = true;

        for (int e : g.adjacent(origin)) {
            if (! marked[e]) {
                edgesTo[e] = origin;
                depthFirstSearch(g, e);
            }
        }
    }

    @Override
    public boolean hasPath(int e) {
        return marked[e];
    }

    @Override
    public Iterable<Integer> pathTo(int e) {
        // You can use any iterable that features a reverse iterator since we're making a stack based search.

        Stack<Integer> path = new ArrayStack<>();
        for (int curr = e; curr != origin; curr = edgesTo[curr]) {
            path.push(curr);
        }

        path.push(origin);

        return path;
    }
}
