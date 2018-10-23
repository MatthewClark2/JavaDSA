package prj.clark.cs.dsa.struct.bag;

public interface Bag<T> extends Iterable<T> {
    void add(T elem);
    boolean isEmpty();
    int size();
}
