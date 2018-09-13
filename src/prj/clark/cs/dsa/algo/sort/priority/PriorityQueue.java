package prj.clark.cs.dsa.algo.sort.priority;

public interface PriorityQueue<K extends Comparable<K>> {
    K max();
    void insert(K value);
    boolean isEmpty();
    K delMax();
}
