package main.java.ru.spbstu.kspt.task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class TableTest {

    @Test
    public void addValue() {
        Table test = new Table();
        test.addValue(1.0D, 2.0D);
        test.addValue(2.0D, 2.0D);
        assertEquals(test.showTable(), "1.0 2.0\n2.0 2.0\n");
    }
    @Test
    public void dellValue() {
        Table test = new Table();
        test.addValue(1.0D, 9.0D);
        assertEquals(test.showTable(), "1.0 9.0\n");
        test.delValue(1.0D);
        assertEquals(test.showTable(), "");
    }

    @Test
    public void findClosestPair() {
        Table test = new Table();
        test.addValue(1.0D, 2.0D);
        test.addValue(3.0D, 4.0D);
        test.addValue(10.0D, 11.0D);
        assertEquals(test.findClosestPair(4.0D), new Table.Pair(3.0D, 4.0D));
    }

    @Test
    public void calculateNewtonPolynomialValue() {
        Table test = new Table();
        test.addValue(0.0D, 1.272D);
        test.addValue(0.2D, 4.465D);
        test.addValue(0.4D, 5.644D);
        test.addValue(0.6D, 5.809D);
        test.addValue(0.8D, 3.961D);
        test.addValue(1.0D, 2.101D);
        assertEquals(test.calculateNewtonPolynom(0.1D), 3.398D, 10e-4);
    }
}