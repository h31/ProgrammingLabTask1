package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DimensionTest {
    @Test
    void getDim() {
        assertEquals("км", new Dimension("км").getDim());
        assertEquals("м", new Dimension("м").getDim());
        assertEquals("дм", new Dimension("дм").getDim());
        assertEquals("см", new Dimension("см").getDim());
        assertEquals("ч", new Dimension("ч").getDim());
        assertEquals("мин", new Dimension("мин").getDim());
        assertEquals("с", new Dimension("с").getDim());
    }

    @Test
    void equalsDim() {
        assertTrue(new Dimension("м").equalsDim(new Dimension("км")));
        assertTrue(new Dimension("м").equalsDim(new Dimension("см")));
        assertTrue(new Dimension("г").equalsDim(new Dimension("кг")));
    }

    @Test
    void power() {
        assertEquals(1000.0, new Dimension("км").power());
        assertEquals(100.0, new Dimension("м").power());
        assertEquals(10.0, new Dimension("дм").power());
        assertEquals(1.0, new Dimension("см").power());
        assertEquals(3600.0, new Dimension("ч").power());
        assertEquals(60.0, new Dimension("мин").power());
        assertEquals(1.0, new Dimension("с").power());
    }

    @Test
    void equals() {
    }

}