package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {
    @Test
    void getNumber() {
        assertEquals(2434.0,
                new Numbers(2434.0,"кг").getNumber());
        assertEquals(2.0,
                new Numbers(2.0,"кг").getNumber());
    }

    @Test
    void getDimension() {
        assertEquals("кг",
                new Numbers(2.0,"кг").getDimension());
        assertEquals("мин",
                new Numbers(2.0,"мин").getDimension());
    }

    @Test
    void plus() {
        assertEquals(new Numbers(4.0,"кг"),
                new Numbers(2.0,"кг").plus(new Numbers(2.0,"кг")));
        assertEquals(new Numbers(2.002,"кг"),
                new Numbers(2.0,"кг").plus(new Numbers(2.0,"г")));
    }

    @Test
    void minus() {
        assertEquals(new Numbers(0.0,"кг"),
                new Numbers(2.0,"кг").minus(new Numbers(2.0,"кг")));
        assertEquals(new Numbers(1.998,"кг"),
                new Numbers(2.0,"кг").minus(new Numbers(2.0,"г")));
    }

    @Test
    void multiplication() {
        assertEquals(new Numbers(5.0,"кг"),
                new Numbers(2.0,"кг").multiplication(2.5));
        assertEquals(new Numbers(8.0,"кг"),
                new Numbers(2.0,"кг").multiplication(4.0));
    }

    @Test
    void division() {
        assertEquals(new Numbers(2.0,"кг"),
                new Numbers(4.0,"кг").division(2.0));
        assertEquals(new Numbers(2.0,"кг"),
                new Numbers(27.0,"кг").division(13.5));
    }

    @Test
    void divisionForDim() {
        assertEquals(1000.0,
                new Numbers(2.0,"кг").divisionForDim(new Numbers(2.0,"г")));
        assertEquals(2.0,
                new Numbers(4.0,"кг").divisionForDim(new Numbers(2.0,"кг")));
    }

    @Test
    void whoIsBigger() {
        assertEquals(new Numbers(4.0,"кг"),
                new Numbers(4.0,"кг").whoIsBigger(new Numbers(2.0,"кг")));
        assertEquals(new Numbers(12000.0,"г"),
                new Numbers(2.0,"кг").whoIsBigger(new Numbers(12000.0,"г")));
    }

    @Test
    void whoIsLess() {
        assertEquals(new Numbers(2.0,"кг"),
                new Numbers(4.0,"кг").whoIsLess(new Numbers(2.0,"кг")));
        assertEquals(new Numbers(2.0,"кг"),
                new Numbers(2.0,"кг").whoIsLess(new Numbers(12000.0,"г")));
    }

    @Test
    void transfer() {
        assertEquals(new Numbers(2000.0,"г"),
                new Numbers(2.0,"кг").transfer("г"));
        assertEquals(new Numbers(120,"с"),
                new Numbers(2.0,"мин").transfer("с"));
    }

    @Test
    void equalsNum() {
        assertTrue(new Numbers(2.0,"кг").equalsNum(new Numbers(2.0,"кг")));
        assertTrue(new Numbers(2.0,"кг").equalsNum(new Numbers(2000.0,"г")));
        assertTrue(new Numbers(2.0,"мин").equalsNum(new Numbers(120.0,"с")));
        assertTrue(new Numbers(2.0,"м").equalsNum(new Numbers(20.0,"дм")));
        assertFalse(new Numbers(20.0,"мин").equalsNum(new Numbers(120.0,"с")));
    }

    @Test
    void equals() {
    }

}