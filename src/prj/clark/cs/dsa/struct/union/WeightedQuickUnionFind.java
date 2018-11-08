package prj.clark.cs.dsa.struct.union;

public class WeightedQuickUnionFind implements UnionFind {
    private int[] siteIDs;
    private int[] componentSizes;
    private int count;

    public WeightedQuickUnionFind(int components) {
        count = components;
        componentSizes = new int[components];
        siteIDs = new int[components];

        for (int i = 0; i < components; ++i) {
            siteIDs[i] = i;
        }

        // Needlessly terse code that initializes all elements of the array to 1.
        for (int i = 0; i < components; ++i, ++componentSizes[i]);
    }

    @Override
    public void makeUnion(int p, int q) {
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
        while (p != siteIDs[p]) {
            p = siteIDs[p];
        }

        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
