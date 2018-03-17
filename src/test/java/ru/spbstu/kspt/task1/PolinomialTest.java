package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolinomialTest {
    @Test
    void summarizeOrSubtract() {
        assertEquals(new Polinomial(new int[]{1,2,3,-1,2,1}),
                new Polinomial(new int[]{-4,3,-1,1,2,1}).
                        summarizeOrSubtract(new Polinomial(new int[]{5,-1,4,-2}), "Summarize"));
        assertEquals(new Polinomial(new int[]{-9,4,-5,-3,2,1}),
                new Polinomial(new int[]{-4,3,-1,1,2,1}).
                        summarizeOrSubtract(new Polinomial(new int[]{5,-1,4,-2}), "Subtract"));
    }
}