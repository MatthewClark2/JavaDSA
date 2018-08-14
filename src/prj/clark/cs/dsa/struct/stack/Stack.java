package prj.clark.cs.dsa.struct.stack;

public interface Stack<T> extends Iterable<T> {
    T pop();

    void push(T element);

    int size();

    boolean isEmpty();
}
