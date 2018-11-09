package prj.clark.cs.dsa.struct.union;

import java.util.NoSuchElementException;

public class WeightedQuickUnionFind implements UnionFind {
    private int[] siteIDs;
    private int[] componentSizes;
    private int count;

    /**
     * Creates a new object with components from 0 to components - 1. Attempting to use any other value with this will
     * result in a {@link java.util.NoSuchElementException}.
     * @param components the number of components to be a part of the union find.
     */
    public WeightedQuickUnionFind(int components) {
        count = components;
        componentSizes = new int[components];
        siteIDs = new int[components];

        for (int i = 0; i < components; ++i) {
            siteIDs[i] = i;
        }

        for (int i = 0; i < components; ++componentSizes[i++]); 
    }

    @Override
    public void makeUnion(int p, int q) {
        validate(p);
        validate(q);

        int i = find(p);
        int j = find(q);

        if (i == j) {
            return;
        }

        // Make the smaller root point to the larger one.
        if (componentSizes[i] < componentSizes[j]) {
            siteIDs[i] = siteIDs[j];
        } else {
            siteIDs[j] = siteIDs[i];
        }

        count--;
    }

    @Override
    public int find(int p) {
        validate(p);

        while (p != siteIDs[p]) {
            p = siteIDs[p];
        }

        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);

        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

    private void validate(int k) {
        if (k < 0 || k >= siteIDs.length) {
            throw new NoSuchElementException();
        }
    }
}
