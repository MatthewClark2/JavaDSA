package prj.clark.cs.dsa.struct.queue;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MinimumPriorityQueue<E> implements PriorityQueue<E> {
    private static final int INITIAL_CAPACITY = 17;

    private final Comparator<E> cmp;

    private E[] elems;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    private MinimumPriorityQueue(Comparator<E> cmp) {
        this.cmp = cmp;
        elems = (E[]) (new Object[INITIAL_CAPACITY]);
        capacity = elems.length;
        size = 0;
    }

    public static <E> PriorityQueue<E> create(Comparator<E> cmp) {
        return new MinimumPriorityQueue<>(cmp);
    }

    public static <E extends Comparable<E>> PriorityQueue<E> create() {
        // Type specifier is required or else it won't compile.
        return new MinimumPriorityQueue<E>(Comparator.naturalOrder());
    }

    @Override
    public void insert(E elem) {
        ensureCapacity();
        elems[++size] = elem;
        swim(size);
    }

    @Override
    public E head() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return elems[1];
    }

    @Override
    public E deleteHead() {
        E head = head();
        exchange(1, size--);
        elems[size + 1] = null;
        sink(1);
        return head;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void sink(int pos) {
        while (2 * pos <= size) {
            int j = 2 * pos;
            if (j < size && gt(cmp, j, j+1)) {
                j++;
            }

            if (!gt(cmp, pos, j)) {
                break;
            }

            exchange(pos, j);
            pos = j;
        }
    }

    private void swim(int pos) {
        while (pos > 1 && gt(cmp, pos / 2, pos)) {
            exchange(pos / 2, pos);
            pos /= 2;
        }
    }

    private void exchange(int pos1, int pos2) {
        E tmp = elems[pos1];
        elems[pos1] = elems[pos2];
        elems[pos2] = tmp;
    }

    private boolean gt(Comparator<E> cmp, int pos1, int pos2) {
        return cmp.compare(elems[pos1], elems[pos2]) > 0;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size + 1>= capacity) {
            capacity *= 2;
            E[] buf = (E[]) (new Object[capacity]);
            System.arraycopy(elems, 0, buf, 0, elems.length);
            elems = buf;
        }
    }
}
