package prj.clark.cs.dsa.struct.bag;

import prj.clark.cs.dsa.struct.stack.ArrayStack;
import prj.clark.cs.dsa.struct.stack.Stack;

public class StackBag<T> implements Bag<T> {
    private Stack<T> elements;

    public StackBag() {
        elements = new ArrayStack<>();
    }

    @Override
    public void add(T elem) {
        elements.push(elem);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int size() {
        return elements.size();
    }
}
