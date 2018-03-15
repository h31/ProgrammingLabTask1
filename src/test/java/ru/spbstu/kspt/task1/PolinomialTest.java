package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolinomialTest {
    @Test
    void plus() {
        assertEquals(new Polinomial(4,"7;3;-3;-3;-8"),
                new Polinomial(4, "7;3;-6;-1;-8").plus(new Polinomial(2, "3;-2;0")));
    }

    @Test
    void minus() {
        assertEquals(new Polinomial(4,"7;3;-9;1;-8"),
                new Polinomial(4, "7;3;-6;-1;-8").minus(new Polinomial(2, "3;-2;0")));
    }

    @Test
    void multiplication() {
        assertEquals(new Polinomial(6,"21;-5;-15;-3;-18;16;0"),
                new Polinomial(4, "7;3;-3;-3;-8").multiplication(new Polinomial(2, "3;-2;0")));
    }

    @Test
    void computation() {
        assertEquals(102,
                new Polinomial(4, "7;3;-6;-1;-8").computation(2));
    }

    @Test
    void quotient() {
        assertEquals(new Polinomial(2, "-2;-1;0"),
                new Polinomial(4, "-7;3;-7;-3;-8").quotient(new Polinomial(2, "3;-2;4")));
        assertEquals(new Polinomial(2, "1;-1;2"),
                new Polinomial(6, "3;-4;2;8;-1;9;3").quotient
                        (new Polinomial(4, "5;5;-2;1;-7")));
    }

    @Test
    void remainder() {
        assertEquals(new Polinomial(0, "-10"),
                new Polinomial(4, "-7;3;-7;-3;-8").remainder(new Polinomial(2, "3;-2;4")));
        assertEquals(new Polinomial(1, "1;-8"),
                new Polinomial(4, "2;-10;23;-22;-3").remainder
                        (new Polinomial(2, "1;-3;5")));
        assertEquals(new Polinomial(0, "0"),
                new Polinomial(3, "3;-5;-6;8").remainder
                        (new Polinomial(2, "3;1;-4")));
    }
}