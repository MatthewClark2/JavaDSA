package prj.clark.cs.dsa.struct.union;

public interface UnionFind {
    /**
     * Connect an int p directly to another int q. These should be distinct.
     */
    void makeUnion(int p, int q);

    /**
     * Obtain the component identifier for p, numbered from 0 to the total number of sites - 1.
     * @param p the int used for checking.
     * @return the component id for p.
     */
    int find(int p);

    /**
     * Determine if two values are within the same component.
     * @param p one value
     * @param q the other
     * @return true if both values are in the same component.
     */
    boolean connected(int p, int q);

    /**
     * Returns the total number of created components.
     * @return the total number of created components.
     */
    int count();
}
