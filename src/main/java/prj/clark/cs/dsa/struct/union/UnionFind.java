package prj.clark.cs.dsa.struct.union;

public interface UnionFind {
    /**
     * Connect an int p directly to another int q. These should be distinct.
     * @throws java.util.NoSuchElementException if either p or q is not a part of the union.
     */
    void makeUnion(int p, int q);

    /**
     * Obtain the component identifier for p, numbered from 0 to the total number of sites - 1.
     * @param p the int used for checking.
     * @return the component id for p.
     * @throws java.util.NoSuchElementException if p is not a part of the union.
     */
    int find(int p);

    /**
     * Determine if two values are within the same component.
     * @param p one value
     * @param q the other
     * @return true if both values are in the same component.
     * @throws java.util.NoSuchElementException if either p or q is not a part of the union.
     */
    boolean connected(int p, int q);

    /**
     * Returns the total number of created components.
     * @return the total number of created components.
     */
    int count();
}