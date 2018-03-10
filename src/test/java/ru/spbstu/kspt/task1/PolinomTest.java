package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolinomTest {
    @Test
    void plus() {
        assertEquals(new Polinom(4,"7;3;-3;-3;-8"),
                new Polinom(4, "7;3;-6;-1;-8").plus(new Polinom(2, "3;-2;0")));
    }

    @Test
    void minus() {
        assertEquals(new Polinom(4,"7;3;-9;1;-8"),
                new Polinom(4, "7;3;-6;-1;-8").minus(new Polinom(2, "3;-2;0")));
    }

    @Test
    void multiplication() {
        assertEquals(new Polinom(6,"21;-5;-15;-3;-18;16;0"),
                new Polinom(4, "7;3;-3;-3;-8").multiplication(new Polinom(2, "3;-2;0")));
    }

    @Test
    void computation() {
        assertEquals(102,
                new Polinom(4, "7;3;-6;-1;-8").computation(2));
    }

    @Test
    void quotient() {
        assertEquals(new Polinom(2, "-2;-1;0"),
                new Polinom(4, "-7;3;-7;-3;-8").quotient(new Polinom(2, "3;-2;4")));
        assertEquals(new Polinom(2, "1;-1;2"),
                new Polinom(6, "3;-4;2;8;-1;9;3").quotient
                        (new Polinom(4, "5;5;-2;1;-7")));
    }

    @Test
    void remainder() {
        assertEquals(new Polinom(0, "-10"),
                new Polinom(4, "-7;3;-7;-3;-8").remainder(new Polinom(2, "3;-2;4")));
        assertEquals(new Polinom(1, "1;-8"),
                new Polinom(4, "2;-10;23;-22;-3").remainder
                        (new Polinom(2, "1;-3;5")));
    }
}