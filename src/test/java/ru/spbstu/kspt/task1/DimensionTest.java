package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DimensionTest {
    @Test
    void getDim() {
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
    }

    @Test
    void equals() {
    }

}