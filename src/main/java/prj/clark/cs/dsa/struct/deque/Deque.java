package prj.clark.cs.dsa.struct.deque;

/**
 * Standard interface for a classical double ended queue structure. For the uninitiated, it works
 * like a stack that can be pushed or popped from either end.
 *
 * Iterators for implementing classes are to yield the leftmost element first, and then move right.
 * @param <T> the type of element being stored.
 */
public interface Deque<T> extends Iterable<T> {
    /**
     * Remove the leftmost element, and return it.
     * @return the leftmost element.
     * @throws java.util.NoSuchElementException if the deque is empty.
     */
    T popLeft();

    /**
     * Remove the rightmost element, and return it.
     * @return the rightmost element.
     * @throws java.util.NoSuchElementException if the deque is empty.
     */
    T popRight();

    /**
     * Append the element to the left end of the deque.
     * @param elem the element to be appended.
     */
    void pushLeft(T elem);

    /**
     * Append the element to the right end of the deque.
     * @param elem the element to be appended.
     */
    void pushRight(T elem);

    /**
     * Determine the number of elements contained within the deque.
     * @return the number of elements within this object.
     */
    int size();

    /**
     * Determine if there are no elements in this object.
     * @return true of there are no elements, and false otherwise.
     */
    boolean isEmpty();
}
