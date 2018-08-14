package prj.clark.cs.dsa.struct.stack;

public class ArrayStack<T> implements Stack<T> {
    // This is a common default size for most collections.
    static final int INITIAL_CAPACITY = 16;

    private T[] elements;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        elements = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        capacity = INITIAL_CAPACITY;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T pop() {
        if (size <= 0) {
            return null;
        }

        T popped = elements[size - 1];

        elements[size - 1] = null;

        size--;

        return popped;
    }

    @Override
    public void push(T element) {
        if (size >= capacity) {
            reallocateBuffer();
        }

        // This could be done in one step, but splitting it in two steps is more explicit.
        elements[size] = element;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void reallocateBuffer() {
        capacity <<= 1;
        T[] newBuffer = (T[]) new Object[capacity];

        System.arraycopy(elements, 0, newBuffer, 0, elements.length);

        elements = newBuffer;
    }
}
