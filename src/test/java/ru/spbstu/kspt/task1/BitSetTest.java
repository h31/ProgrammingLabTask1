package ru.spbstu.kspt.task1;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BitSetTest {

    @Test
    public void addElementAndElements() {
        // first
        BitSet a = new BitSet(10);
        BitSet b = new BitSet(3);
        int element = 22;
        int[] elements1 = {1,2,3,4,5};
        a.addElement(1);
        a.addElements(elements1);
        assertFalse(a.check(0));
        assertTrue(a.check(1));
        assertTrue(a.check(2));
        assertTrue(a.check(3));
        assertTrue(a.check(4));
        assertTrue(a.check(5));
        // second
        try {
            b.addElement(element);
        } catch (IllegalArgumentException e) {
            assertFalse(element == b.getSize());
        }
    }
}