package com.jimmimimmi.java.guidewire;

import junit.framework.TestCase;

public class IteratorOfIteratorsTest extends TestCase {

    public void testNullSubArrays() {
        var strings = new String[2][];

        var iteratorOfIterators = new IteratorOfIterators<>(strings);
        assertFalse(iteratorOfIterators.hasNext());
        assertNull(iteratorOfIterators.next());
    }

    public void testEmpty() {
        var strings = new String[0][];

        var iteratorOfIterators = new IteratorOfIterators<>(strings);
        assertFalse(iteratorOfIterators.hasNext());
        assertNull(iteratorOfIterators.next());
    }

    public void testNull() {
        var iteratorOfIterators = new IteratorOfIterators<>(null);
        assertFalse(iteratorOfIterators.hasNext());
        assertNull(iteratorOfIterators.next());
    }

    public void testIterationsThroughEmptyOrNull() {
        var strings = new String[][]{{"a"}, {}, {"b", "c"}, null, {"e", "f", "g"}};
        var iteratorOfIterators = new IteratorOfIterators<>(strings);

        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("a", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("b", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("c", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("e", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("f", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("g", iteratorOfIterators.next());
        assertFalse(iteratorOfIterators.hasNext());
        assertNull(iteratorOfIterators.next());
        assertFalse(iteratorOfIterators.hasNext());
    }

    public void testSkippingNullValues() {
        var strings = new String[][]{{"a"}, {null}, {"b", null, "c"}, null, {"e", "f", "g"}};
        var iteratorOfIterators = new IteratorOfIterators<>(strings);

        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("a", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("b", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("c", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("e", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("f", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("g", iteratorOfIterators.next());
        assertFalse(iteratorOfIterators.hasNext());
        assertNull(iteratorOfIterators.next());
        assertFalse(iteratorOfIterators.hasNext());
    }

    public void testBasicIterations() {
        var strings = new String[][]{{"a"}, {}, {"b", "c"}, {"d"}, {"e", "f", "g"}};
        var iteratorOfIterators = new IteratorOfIterators<>(strings);

        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("a", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("b", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("c", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("d", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("e", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("f", iteratorOfIterators.next());
        assertTrue(iteratorOfIterators.hasNext());
        assertEquals("g", iteratorOfIterators.next());
        assertFalse(iteratorOfIterators.hasNext());
        assertNull(iteratorOfIterators.next());
        assertFalse(iteratorOfIterators.hasNext());
    }
}