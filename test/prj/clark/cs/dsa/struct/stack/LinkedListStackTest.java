package prj.clark.cs.dsa.struct.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListStackTest {
    private Stack stack;

    @Before
    public void setup() {
        stack = new LinkedListStack();
    }

    @Test
    public void stackIsLIFO() {
        stack.push("Hello");
        stack.push("World");

        assertEquals("World", stack.pop());
        assertEquals("Hello", stack.pop());
    }


    @Test
    public void stackAcceptsNull() {
        stack.push(null);

        assertNull(stack.pop());
    }

    @Test
    public void emptyStackPopsNull() {
        assertNull(stack.pop());
    }

    @Test
    public void poppingDecreasesSize() {
        stack.push("asdf");
        stack.push("bleh");

        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());

        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void pushingDecreasesSize() {

        stack.push("hi");
        assertEquals(1, stack.size());

        stack.push("shussain");
        assertEquals(2, stack.size());
    }
}
