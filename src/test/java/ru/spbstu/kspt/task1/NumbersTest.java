package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {
    @Test
    void getNumber() {
        assertEquals(new Numbers(4.0,"кг"),
                new Numbers(2.0,"кг").plus(new Numbers(2.0,"кг")));
        assertEquals(new Numbers(2.002,"кг"),
                new Numbers(2.0,"кг").plus(new Numbers(2.0,"г")));
    }

    @Test
    void getDimen() {
    }

    @Test
    void plus() {
    }

    @Test
    void minus() {
    }

    @Test
    void multiplication() {
    }

    @Test
    void division() {
    }

    @Test
    void divisionForDim() {
    }

    @Test
    void whoIsBigger() {
    }

    @Test
    void whoIsLess() {
    }

    @Test
    void transfer() {
    }

    @Test
    void equalsNum() {
    }

    @Test
    void equals() {
    }


}