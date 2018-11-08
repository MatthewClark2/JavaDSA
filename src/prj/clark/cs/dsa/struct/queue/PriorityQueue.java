package prj.clark.cs.dsa.struct.queue;

/**
 *
 * @param <E> the type of element being stored in the queue.
 */
public interface PriorityQueue<E> {
    /**
     * Add a new element to the queue.
     * @param elem the element to add.
     */
    void insert(E elem);

    /**
     * Returns the next element from the queue.
     * @return the next element from the queue.
     */
    E head();

    /**
     * Deletes the next element from the queue.
     * @return the next element from the queue.
     */
    E deleteHead();

    /**
     * Determine whether or not more elements are in the queue.
     * @return true if more elements remain, and false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements currently in the queue.
     * @return the number of elements currently in the queue.
     */
    int size();
}
