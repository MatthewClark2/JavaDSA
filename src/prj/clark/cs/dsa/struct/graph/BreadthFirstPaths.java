package prj.clark.cs.dsa.struct.graph;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstPaths implements Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distanceto;
    private final int origin;

    @SuppressWarnings("unchecked")
    private BreadthFirstPaths(Graph g, int origin) {
        marked = new boolean[g.getVertices()];
        edgeTo = new int[g.getVertices()];
        this.origin = origin;
        distanceto = new int[g.getVertices()];
        breadthFirstSearch(g, origin);
    }

    private void breadthFirstSearch(Graph g, int e) {
        // We're using an arraylist as a queue.
        List<Integer> q = new ArrayList<>();
        q.add(e);

        marked[hash(e)] = true;
        distanceto[hash(e)] = 0;

        while(! q.isEmpty()) {
            int v = q.remove(0);

            for  (int w : g.adjacent(v)) {
                if (! marked[hash(w)]) {
                    q.add(w);
                    marked[hash(w)] = true;
                    edgeTo[hash(w)] = v;
                    distanceto[hash(w)] = distanceto[hash(v)] + 1;
                }
            }
        }
    }

    public static Paths from(Graph g, int origin) {
        return new BreadthFirstPaths(g, origin);
    }

    @Override
    public boolean hasPath (int e) {
        return marked[hash(e)];
    }

    @Override
    public Iterable<Integer> pathTo (int e) {
        return null;
    }

    private int hash(int e) {
        return (e & 0x1fffffff) % marked.length;
    }
}
