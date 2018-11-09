package prj.clark.cs.dsa.struct.graph;

public interface Paths {
    boolean hasPath(int e);

    Iterable<Integer> pathTo(int e);
}
