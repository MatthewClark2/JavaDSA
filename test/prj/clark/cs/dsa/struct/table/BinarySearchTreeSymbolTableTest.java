package prj.clark.cs.dsa.struct.table;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class BinarySearchTreeSymbolTableTest {
    private SymbolTable<String, Integer> st;

    @Before
    public void setUp() {
        st = new BinarySearchTreeSymbolTable<>();
    }

    @Test
    public void emptyTableHasZeroSize() {
        assertEquals(0, st.getSize());
    }

    @Test
    public void emptyTableIsEmpty() {
        assertTrue(st.isEmpty());
    }

    @Test
    public void tableContainsInsertedElements() {
        st.put("Hello", 3);

        assertTrue(st.contains("Hello"));
    }

    @Test
    public void tableDoesNotContainUnplacedElements() {
        assertFalse(st.contains("Hello"));
    }

    @Test
    public void deletedElementsAreNotPresent() {
        assertFalse(st.contains("foo"));
        st.put("foo", 3);
        assertTrue(st.contains("foo"));
        st.delete("foo");
        assertFalse(st.contains("foo"));
    }

    @Test
    public void childrenOfDeletedElementsArePresent() {
        // This test is bad as it relies on the internal implementation of the Tree. However, this is an edge case that
        // needs to be tested. If the root of the tree is ever selected by anything other than the first added node,
        // then this test is void.
        st.put("c", 0);
        st.put("b", 2);
        st.put("d", 3);
        st.put("a", 4);

        st.delete("b");
        assertTrue(st.contains("a"));
    }

    @Test
    public void correctValuesAreReturned() {
        st.put("bar", 5);
        st.put("quux", 8);

        // The casts are required due to ambiguous method calls.
        assertEquals((Integer) 5, st.get("bar"));
        assertEquals((Integer) 8, st.get("quux"));
    }

    @Test(expected = NoSuchElementException.class)
    public void nonExistentElementThrowsExceptionWhenObtained() {
        st.put("Hello", 10);

        st.get(", World!");
    }

    @Test
    public void deletingNonExistentElementDoesNotThrowException() {
        st.delete("mat");
    }

    @Test
    public void deletionRetainsOtherNodes() {
        st.put("a", 1);
        st.put("b", 2);
        st.put("c", 3);
        st.put("d", 4);

        st.delete("a");

        assertFalse(st.contains("a"));
        assertTrue(st.contains("b"));
        assertTrue(st.contains("c"));
        assertTrue(st.contains("d"));
    }
}