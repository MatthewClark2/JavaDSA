package prj.clark.cs.dsa.struct.deque;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListDequeTest {
    private Deque<String> deque;

    @Before
    public void setup() {
        deque = new DoublyLinkedListDeque<>();
    }

    @Test
    public void dllStartsEmpty() {
        assertEquals(0, deque.size());
    }

    @Test
    public void leftWorksAsLIFO() {
        deque.pushBack("Hello");
        deque.pushBack("World");

        assertEquals("World", deque.popBack());
        assertEquals("Hello", deque.popBack());
    }

    @Test
    public void rightWorksAsLIFO() {
        deque.pushFront("Foo");
        deque.pushFront("Bar");

        assertEquals("Bar", deque.popFront());
        assertEquals("Foo", deque.popFront());
    }

    @Test
    public void wrapsCorrectlyToRight() {
        deque.pushFront("Biff");
        deque.pushBack("Fuzz");
        deque.pushBack("Qux");

        assertEquals("Qux", deque.popBack());
        assertEquals("Fuzz", deque.popBack());
        assertEquals("Biff", deque.popBack());
    }

    @Test
    public void wrapsCorrectlyToLeft() {
        deque.pushBack("Java");
        deque.pushFront("Groovy");
        deque.pushFront("Clojure");

        assertEquals("Clojure", deque.popFront());
        assertEquals("Groovy", deque.popFront());
        assertEquals("Java", deque.popFront());
    }

    @Test
    public void emptyReturnsNullLeft() {
        assertNull(deque.popBack());
    }

    @Test
    public void emptyReturnsNullRight() {
        assertNull(deque.popFront());
    }

    @Test
    public void popLeftDecreasesSize() {
        deque.pushBack("Hello");
        deque.pushBack("World");

        deque.popBack();
        assertEquals(1, deque.size());

        deque.popBack();
        assertEquals(0, deque.size());
    }

    @Test
    public void emptyPopsDoNotAffectSize() {
        deque.popBack();
        assertEquals(0, deque.size());
        deque.popFront();
        assertEquals(0, deque.size());
    }

    @Test
    public void popRightDecreasesSize() {
        deque.pushFront("Scheme");
        deque.pushFront("Common Lisp");

        deque.popFront();
        assertEquals(1, deque.size());

        deque.popFront();
        assertEquals(0, deque.size());
    }

    @Test
    public void mixedPopsDecreaseSize() {
        deque.pushFront("OCaml");
        deque.pushBack("Haskell");

        deque.popFront();
        assertEquals(1, deque.size());

        deque.popBack();
        assertEquals(0, deque.size());
    }

    @Test
    public void pushLeftIncreasesSize() {
        deque.pushBack("Fortran");
        assertEquals(1, deque.size());

        deque.pushBack("COBOL");
        assertEquals(2, deque.size());
    }

    @Test
    public void pushRightIncreasesSize() {
        deque.pushFront("Rust");
        assertEquals(1, deque.size());

        deque.pushFront("Golang");
        assertEquals(2, deque.size());
    }

    @Test
    public void mixedPushesIncreaseSize() {
        deque.pushFront("Kotlin");
        assertEquals(1, deque.size());

        deque.pushBack("Scala");
        assertEquals(2, deque.size());
    }
}