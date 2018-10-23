package prj.clark.cs.dsa.struct.graph;

public interface Paths<E> {
    boolean hasPath(E e);

    Iterable<E> pathTo(E e);
}
