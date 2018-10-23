package prj.clark.cs.dsa.struct.graph;

import prj.clark.cs.dsa.algo.sort.priority.UnorderedArrayPriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstPaths<E> implements Paths<E> {
    private boolean[] marked;
    private E[] edgeTo;
    private int[] distanceto;
    private final E origin;

    @SuppressWarnings("unchecked")
    private BreadthFirstPaths(Graph<E> g, E origin) {
        marked = new boolean[g.vertices()];
        edgeTo = (E[]) (new Object[g.vertices()]);
        this.origin = origin;
        distanceto = new int[g.vertices()];
        breadthFirstSearch(g, origin);
    }

    private void breadthFirstSearch(Graph<E> g, E e) {
        // We're using an arraylist as a queue.
        List<E> q = new ArrayList<>();
        q.add(e);

        marked[hash(e)] = true;
        distanceto[hash(e)] = 0;

        while(! q.isEmpty()) {
            E v = q.remove(0);

            for (E w : g.adjacent(v)) {
                if (! marked[hash(w)]) {
                    q.add(w);
                    marked[hash(w)] = true;
                    edgeTo[hash(w)] = v;
                    distanceto[hash(w)] = distanceto[hash(v)] + 1;
                }
            }
        }
    }

    public static <T> Paths<T> from(Graph<T> g, T origin) {
        return new BreadthFirstPaths<>(g, origin);
    }

    @Override
    public boolean hasPath(E e) {
        return marked[hash(e)];
    }

    @Override
    public Iterable<E> pathTo(E e) {
        return null;
    }

    private int hash(E e) {
        return (e.hashCode() & 0x1fffffff) % marked.length;
    }
}
