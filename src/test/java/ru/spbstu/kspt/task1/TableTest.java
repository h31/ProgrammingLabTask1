package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TableTest {
    private Table test = new Table();

    @Test
    void addAPair() {
        test.addAPair(1, 2);
        test.addAPair(2, 2);
        assertEquals(test.showTable(), "1.0 2.0\n2.0 2.0\n");
    }

    @Test
    void deletPair() {
        test.addAPair(1, 9);
        assertEquals(test.showTable(), "1.0 9.0\n");
        test.deletPair(1, 9);
        assertEquals(test.showTable(), "");
    }

}
