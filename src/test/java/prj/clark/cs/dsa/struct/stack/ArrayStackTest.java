package prj.clark.cs.dsa.struct.stack;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

    @Test(expected = NoSuchElementException.class)
    public void emptyStackThrowsException() {
        stack.pop();
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
        for (int i = 0; i < 100000; ++i) {
            stack.push("hi");
        }

        for (int i = stack.size(); i > 0; --i) {
            stack.pop();
        }
    }

    @Test
    public void iteratorContainsCorrectElements() {
        String[] elements = {"Hello", "World", "Dr.", "Hussain"};

        stack.push("Hussain");
        stack.push("Dr.");
        stack.push("World");
        stack.push("Hello");

        int pos = 0;

        for (String s : stack) {
            assertEquals(elements[pos++], s);
        }

        assertEquals(4, pos);
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyIteratorThrowsException() {
        Iterator<String> i = stack.iterator();
        i.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratorRemovalThrowsException() {
        Iterator<String> i = stack.iterator();
        i.remove();
    }

    @Test
    public void vanillaForeachCase() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream os = new PrintStream(output);

        stack.push("plates");
        stack.push("of");
        stack.push("Stack");

        stack.forEach(os::println);

        assertEquals("Stack\nof\nplates\n", output.toString());
    }

}
