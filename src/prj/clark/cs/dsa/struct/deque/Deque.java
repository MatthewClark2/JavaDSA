package prj.clark.cs.dsa.struct.deque;

public interface Deque<T> extends Iterable<T> {
    T popLeft();
    T popRight();
    void pushLeft(T elem);
    void pushRight(T elem);
    int size();
    boolean isEmpty();
}
