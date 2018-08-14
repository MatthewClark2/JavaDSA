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
        assertTrue(deque.isEmpty());
    }

    @Test
    public void sizeZeroWhenEmpty() {
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void leftPushedDequeNotEmpty() {
        assertTrue(deque.isEmpty());
        deque.pushLeft("hi");
        assertFalse(deque.isEmpty());
    }

    @Test
    public void rightPushedDequeNotEmpty() {
        assertTrue(deque.isEmpty());
        deque.pushRight("hi");
        assertFalse(deque.isEmpty());
    }

    @Test
    public void leftPoppedDequeBecomesEmpty() {
        deque.pushLeft("hi");
        deque.popLeft();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void leftWorksAsLIFO() {
        deque.pushLeft("Hello");
        deque.pushLeft("World");

        assertEquals("World", deque.popLeft());
        assertEquals("Hello", deque.popLeft());
    }

    @Test
    public void rightWorksAsLIFO() {
        deque.pushRight("Foo");
        deque.pushRight("Bar");

        assertEquals("Bar", deque.popRight());
        assertEquals("Foo", deque.popRight());
    }

    @Test
    public void wrapsCorrectlyToRight() {
        deque.pushRight("Biff");
        deque.pushLeft("Fuzz");
        deque.pushLeft("Qux");

        assertEquals("Qux", deque.popLeft());
        assertEquals("Fuzz", deque.popLeft());
        assertEquals("Biff", deque.popLeft());
    }

    @Test
    public void wrapsCorrectlyToLeft() {
        deque.pushLeft("Java");
        deque.pushRight("Groovy");
        deque.pushRight("Clojure");

        assertEquals("Clojure", deque.popRight());
        assertEquals("Groovy", deque.popRight());
        assertEquals("Java", deque.popRight());
    }

    @Test
    public void emptyReturnsNullLeft() {
        assertNull(deque.popLeft());
    }

    @Test
    public void emptyReturnsNullRight() {
        assertNull(deque.popRight());
    }

    @Test
    public void popLeftDecreasesSize() {
        deque.pushLeft("Hello");
        deque.pushLeft("World");

        deque.popLeft();
        assertEquals(1, deque.size());

        deque.popLeft();
        assertEquals(0, deque.size());
    }

    @Test
    public void emptyPopsDoNotAffectSize() {
        deque.popLeft();
        assertEquals(0, deque.size());
        deque.popRight();
        assertEquals(0, deque.size());
    }

    @Test
    public void popRightDecreasesSize() {
        deque.pushRight("Scheme");
        deque.pushRight("Common Lisp");

        deque.popRight();
        assertEquals(1, deque.size());

        deque.popRight();
        assertEquals(0, deque.size());
    }

    @Test
    public void mixedPopsDecreaseSize() {
        deque.pushRight("OCaml");
        deque.pushLeft("Haskell");

        deque.popRight();
        assertEquals(1, deque.size());

        deque.popLeft();
        assertEquals(0, deque.size());
    }

    @Test
    public void pushLeftIncreasesSize() {
        deque.pushLeft("Fortran");
        assertEquals(1, deque.size());

        deque.pushLeft("COBOL");
        assertEquals(2, deque.size());
    }

    @Test
    public void pushRightIncreasesSize() {
        deque.pushRight("Rust");
        assertEquals(1, deque.size());

        deque.pushRight("Golang");
        assertEquals(2, deque.size());
    }

    @Test
    public void mixedPushesIncreaseSize() {
        deque.pushRight("Kotlin");
        assertEquals(1, deque.size());

        deque.pushLeft("Scala");
        assertEquals(2, deque.size());
    }
}