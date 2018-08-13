package prj.clark.cs.dsa.struct.stack;

public class ArrayStack implements Stack {
    // This is a common default size for most collections.
    private static final int INITIAL_CAPACITY = 16;

    private String[] strings;
    private int size;
    private int capacity;

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        strings = new String[initialCapacity];
        size = 0;
        capacity = initialCapacity;
    }

    @Override
    public String pop() {
        if (size <= 0) {
            return null;
        }

        String popped = strings[size - 1];

        strings[size - 1] = null;

        size--;

        return popped;
    }

    @Override
    public void push(String element) {
        if (size >= capacity) {
            reallocateBuffer();
        }

        // This could be done in one step, but splitting it in two steps is more explicit.
        strings[size] = element;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    private void reallocateBuffer() {
        capacity <<= 1;
        String[] newBuffer = new String[capacity];

        System.arraycopy(strings, 0, newBuffer, 0, strings.length);

        strings = newBuffer;
    }
}
