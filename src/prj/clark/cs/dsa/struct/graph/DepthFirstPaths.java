package prj.clark.cs.dsa.struct.graph;

import prj.clark.cs.dsa.struct.stack.ArrayStack;
import prj.clark.cs.dsa.struct.stack.Stack;

import java.util.Iterator;

public class DepthFirstPaths<E> implements Paths<E> {
    private boolean[] marked;
    private E[] edgesTo;
    private final E origin;

    @SuppressWarnings("unchecked")
    private DepthFirstPaths(Graph<E> g, E origin) {
        marked = new boolean[g.getVertices()];
        edgesTo = (E[]) (new Object[g.getVertices()]);
        this.origin = origin;

        depthFirstSearch(g, origin);
    }

    private void depthFirstSearch(Graph<E> g, E origin) {
        marked[hash(origin)] = true;

        for (E e : g.adjacent(origin)) {
            int currHash = hash(e);

            if (! marked[currHash]) {
                edgesTo[currHash] = origin;
                depthFirstSearch(g, e);
            }
        }
    }

    public static <T> Paths<T> from(Graph<T> g, T origin) {
        return new DepthFirstPaths<T>(g, origin);
    }

    private int hash(E e) {
        return (e.hashCode() & 0x1fffffff) % marked.length;
    }

    @Override
    public boolean hasPath(E e) {
        return marked[hash(e)];
    }

    @Override
    public Iterable<E> pathTo(E e) {
        if (! hasPath(e)) {
            return () -> new Iterator<E>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public E next() {
                    return null;
                }
            };
        }

        // You can use any iterable that features a reverse iterator since we're making a stack based search.

        Stack<E> path = new ArrayStack<>();
        for (E curr = e; curr != origin; curr = edgesTo[hash(curr)]) {
            path.push(curr);
        }

        path.push(origin);

        return path;
    }
}
