package prj.clark.cs.dsa.struct.stack;

/**
 * Standard interface for a classical first in, last out data structure.
 *
 * It should be noted that iterators for implementing classes should yield the elements from the
 * top, similarly to how they would be popped off over time.
 * @param <T> the type of element contained on the stack.
 */
public interface Stack<T> extends Iterable<T> {
    /**
     * Remove the next item from the stack, and return it.
     * @return the next element.
     * @throws java.util.NoSuchElementException if no elements are in the stack.
     */
    T pop();

    /**
     * Append a new element to the stack.
     * @param element the new element to be added.
     */
    void push(T element);

    /**
     * Determine the number of elements in the stack.
     * @return the number of elements in the stack.
     */
    int size();

    /**
     * Determine if the stack has no elements.
     * @return true if no elements are in the stack, and false otherwise.
     */
    boolean isEmpty();
}
