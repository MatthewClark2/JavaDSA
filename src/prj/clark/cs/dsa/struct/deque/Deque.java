package prj.clark.cs.dsa.struct.deque;

public interface Deque<T> {
    T popBack();
    T popFront();
    void pushBack(T elem);
    void pushFront(T elem);
    int size();
}
