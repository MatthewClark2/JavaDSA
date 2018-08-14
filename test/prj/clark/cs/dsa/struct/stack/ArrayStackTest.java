package prj.clark.cs.dsa.struct.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {

    @Test
    public void stackIsLIFO() {
        Stack stack = getStack();
        stack.push("Hello");
        stack.push("World");

        assertEquals("World", stack.pop());
        assertEquals("Hello", stack.pop());
    }

    private Stack getStack() {
        return new ArrayStack();
    }

    @Test
    public void stackAcceptsNull() {
        Stack stack = getStack();
        stack.push(null);

        assertNull(stack.pop());
    }

    @Test
    public void emptyStackPopsNull() {
        Stack stack = getStack();
        assertNull(stack.pop());
    }

    @Test
    public void ensurePoppingDecreasesSize() {
        Stack stack = getStack();
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
        assertEquals(0, getStack().size());
    }

    @Test
    public void ensurePushingDecreasesSize() {
        Stack stack = getStack();

        stack.push("hi");
        assertEquals(1, stack.size());

        stack.push("shussain");
        assertEquals(2, stack.size());
    }

    @Test
    public void stackResizesAutomatically() {
        Stack stack = getStack();
        for (int i = 0; i < ArrayStack.INITIAL_CAPACITY + 5; ++i) {
            stack.push("hi");
        }
    }

}
