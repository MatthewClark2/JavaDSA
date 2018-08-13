package prj.clark.cs.dsa.struct.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListStackTest {

    @Test
    public void stackIsLIFO() {
        Stack stack = new LinkedListStack();
        stack.push("Hello");
        stack.push("World");

        assertEquals("World", stack.pop());
        assertEquals("Hello", stack.pop());
    }

    @Test
    public void stackAcceptsNull() {
        Stack stack = new LinkedListStack();
        stack.push(null);

        assertNull(stack.pop());
    }

    @Test
    public void emptyStackPopsNull() {
        Stack stack = new LinkedListStack();
        assertNull(stack.pop());
    }

    @Test
    public void ensurePoppingDecreasesSize() {
        Stack stack = new LinkedListStack();
        stack.push("blah");
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
    public void ensureNewStackIsEmpty() {
        assertEquals(0, new LinkedListStack().size());
    }

    @Test
    public void ensurePushingDecreasesSize() {
        Stack stack = new LinkedListStack();

        stack.push("hi");
        assertEquals(1, stack.size());

        stack.push("shussain");
        assertEquals(2, stack.size());
    }
}
