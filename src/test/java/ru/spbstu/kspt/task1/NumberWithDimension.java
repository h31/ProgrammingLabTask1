package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberWithDimensionTest {
    @Test
    void getNumber() {
    }

    @Test
    void getDimension() {
    }

    @Test
    void plus() {
        assertEquals(new NumberWithDimension(4.0,"км", new Dimension().getLengthDimensions()),
                new NumberWithDimension(2.0,"км",  new Dimension().getLengthDimensions()).
                        plus(new NumberWithDimension(2.0,"км",
                                new Dimension().getLengthDimensions())));
    }

    @Test
    void minus() {
        assertEquals(new NumberWithDimension(4.0,"км", new Dimension().getLengthDimensions()),
                new NumberWithDimension(6.0,"км",  new Dimension().getLengthDimensions())
                        .minus(new NumberWithDimension(2.0,"км",
                                new Dimension().getLengthDimensions())));
    }

    @Test
    void multiply() {
        assertEquals(new NumberWithDimension(26.0,"км", new Dimension().getLengthDimensions()),
                new NumberWithDimension(1.0,"км",  new Dimension().getLengthDimensions())
                        .multiply(26.0));
        assertEquals(new NumberWithDimension(29.0,"м", new Dimension().getLengthDimensions()),
                new NumberWithDimension(1.0,"м",  new Dimension().getLengthDimensions())
                        .multiply(29.0));
    }

    @Test
    void divide() {
        assertEquals(new NumberWithDimension(5.0,"км", new Dimension().getLengthDimensions()),
                new NumberWithDimension(25.0,"км",  new Dimension().getLengthDimensions())
                        .divide(5.0));
        assertEquals(new NumberWithDimension(5.0,"м", new Dimension().getLengthDimensions()),
                new NumberWithDimension(30.0,"м",  new Dimension().getLengthDimensions())
                        .divide(6.0));
    }

    @Test
    void divideForDim() {
        assertEquals(10.0,
                new NumberWithDimension(25.0,"км",  new Dimension().getLengthDimensions())
                        .divideForDim(new NumberWithDimension(2.5,"км",
                                new Dimension().getLengthDimensions())));
    }

    @Test
    void transfer() {
    }


    @Test
    void equals() {
    }

}