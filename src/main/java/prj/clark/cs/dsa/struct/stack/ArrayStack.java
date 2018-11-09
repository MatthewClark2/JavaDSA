package prj.clark.cs.dsa.struct.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array-backed stack implementation.
 *
 * Pushes are in amortized O(1), while pops are explicitly O(1). Memory usage scales with the
 * number of elements that are in the stack.
 *
 * Note that this structure can grow when elements are pushed onto it, but it will not shrink when
 * elements are removed, as it works under the assumption that they may be added back later.
 * @param <T> the type of object stored by this stack.
 */
public class ArrayStack<T> implements Stack<T> {
    // This is a common default getSize for most collections.
    private static final int INITIAL_CAPACITY = 16;

    private static final double MINIMUM_LOAD_CAPACITY = 0.25;

    private T[] elements;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        // A T[] may not be instantiated directly due to the limitations of Java's generics.
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
            throw new NoSuchElementException();
        }

        // We only deallocate space if we drop below a specified threshold, and have expanded
        // the buffer.
        if (capacity > INITIAL_CAPACITY && ((double) size) / capacity <= MINIMUM_LOAD_CAPACITY) {
            reallocateBuffer(capacity / 2);
        }

        size--;

        T popped = elements[size];

        elements[size] = null;

        return popped;
    }

    @Override
    public void push(T element) {
        if (size >= capacity) {
            reallocateBuffer(capacity * 2);
        }

        // This could be done in one step, but splitting it in two steps is more explicit.
        elements[size] = element;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }

    @SuppressWarnings("unchecked")
    private void reallocateBuffer(int size) {
        capacity = size;
        T[] newBuffer = (T[]) new Object[capacity];

        System.arraycopy(elements, 0, newBuffer, 0,
                Math.min(elements.length, newBuffer.length));

        elements = newBuffer;
    }

    private class ArrayStackIterator implements Iterator<T> {
        private int position;

        ArrayStackIterator() {
            position = size - 1;
        }

        @Override
        public boolean hasNext() {
            return position > -1;
        }

        @Override
        public T next() {
            if (! hasNext()) {
                throw new NoSuchElementException();
            }

            return elements[position--];
        }
    }
}
