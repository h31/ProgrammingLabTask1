package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolinomialTest {
    @Test
    void summarizeOrSubtract() {
        assertEquals(new Polinomial(new int[]{1,2,3,-1,2,1}),
                new Polinomial(new int[]{-4,3,-1,1,2,1}).
                        summarizeOrSubtract(new Polinomial(new int[]{5,-1,4,-2}), true));
        assertEquals(new Polinomial(new int[]{-9,4,-5,-3,2,1}),
                new Polinomial(new int[]{-4,3,-1,1,2,1}).
                        summarizeOrSubtract(new Polinomial(new int[]{5,-1,4,-2}), false));
    }
    @Test
    void evaluate() {
        assertEquals(102, new Polinomial(new int[]{-8,-1,-6,3,7}).evaluate(2));
        assertEquals(7, new Polinomial(new int[]{7}).evaluate(2));
    }
    @Test
    void multiply() {
        assertEquals(new Polinomial(new int[]{0,16,-18,-3,-15,-5,21}),
                new Polinomial(new int[]{-8,-3,-3,3,7}).multiply(new Polinomial(new int[]{0,-2,3})));
    }
}