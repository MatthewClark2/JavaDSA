package prj.clark.cs.dsa.struct.union;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class WeightedQuickUnionFindTest {
    private UnionFind uf;

    public void init(int size) {
        uf = new WeightedQuickUnionFind(size);
    }

    @Test
    public void emptyUnionHasNoComponents() {
        init(0);

        assertEquals(0, uf.count());
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyUnionCannotJoin() {
        init(0);
        uf.makeUnion(0, 1);
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyUnionCannotCheckConnection() {
        init(0);
        uf.connected(0, 1);
    }

    @Test
    public void directUnionConnected() {
        init(5);
        uf.makeUnion(1, 2);
        uf.makeUnion(3, 0);

        assertTrue(uf.connected(2, 1));
        assertTrue(uf.connected(1, 2));
        assertTrue(uf.connected(3, 0));
        assertTrue(uf.connected(0, 3));
    }

    @Test
    public void elementsSelfConnected() {
        init(5);
        assertTrue(uf.connected(0, 0));
    }

    @Test
    public void indirectlyConnectedElementsConnected() {
        init(5);
        uf.makeUnion(0, 1);
        uf.makeUnion(1, 3);

        assertTrue(uf.connected(0, 3));
    }

    @Test
    public void unjoinedElementsNotConnected() {
        init(6);
        uf.makeUnion(0, 1);
        uf.makeUnion(0, 2);
        uf.makeUnion(3, 4);

        assertFalse(uf.connected(0, 3));
        assertFalse(uf.connected(0, 4));
        assertFalse(uf.connected(0, 5));
    }

}