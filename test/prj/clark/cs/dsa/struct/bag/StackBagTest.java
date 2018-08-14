package prj.clark.cs.dsa.struct.bag;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackBagTest {
    private Bag<String> bag;

    @Before
    public void setup() {
        bag = new StackBag<>();
    }

    @Test
    public void newBagIsEmpty() {
        assertTrue(bag.isEmpty());
    }

    @Test
    public void initialBagSizeZero() {
        assertEquals(0, bag.size());
    }

    @Test
    public void addingIncreasesSize() {
        bag.add("foo");
        assertEquals(1, bag.size());

        bag.add("bar");
        assertEquals(2, bag.size());
    }

    @Test
    public void addingIsNonEmpty() {
        bag.add("null");

        assertFalse(bag.isEmpty());
    }

}