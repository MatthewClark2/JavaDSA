package prj.clark.cs.dsa.struct.deque;

public interface Deque {
    String popBack();
    String popFront();
    void pushBack(String elem);
    void pushFront(String elem);
    int size();
}
