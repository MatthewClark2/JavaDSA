package prj.clark.cs.dsa.struct.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {

    private Stack<String> stack;

    @Before
    public void setup() {
        stack = new ArrayStack<>();
    }

    @Test
    public void newStackIsEmpty() {
        assertEquals(0, stack.size());
    }

    @Test
    public void sizeZeroWhenEmpty() {
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void pushedStackNotEmpty() {
        assertTrue(stack.isEmpty());

        stack.push("");

        assertFalse(stack.isEmpty());
    }

    @Test
    public void poppedStackBecomesEmpty() {
        assertTrue(stack.isEmpty());

        stack.push("");

        assertFalse(stack.isEmpty());

        stack.pop();

        assertTrue(stack.isEmpty());
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
    public void pushingDecreasesSize() {

        stack.push("hi");
        assertEquals(1, stack.size());

        stack.push("shussain");
        assertEquals(2, stack.size());
    }

    @Test
    public void stackResizesAutomatically() {
        for (int i = 0; i < ArrayStack.INITIAL_CAPACITY + 5; ++i) {
            stack.push("hi");
        }
    }

}
