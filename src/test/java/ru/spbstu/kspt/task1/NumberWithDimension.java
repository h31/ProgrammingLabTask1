package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberWithDimensionTest {
    @Test
    void getNumber() {
        assertEquals(2.0,
                new NumberWithDimension(2.0,"км",  new Dimension().getLengthDimensions())
                        .getNumber());
    }

    @Test
    void getDimension() {
        assertEquals("км",
                new NumberWithDimension(2.0,"км",  new Dimension().getLengthDimensions())
                        .getDimension());
    }

    @Test
    void plus() {
        assertEquals(new NumberWithDimension(4.0,"км", new Dimension().getLengthDimensions()),
                new NumberWithDimension(2.0,"км",  new Dimension().getLengthDimensions())
                        .plus(new NumberWithDimension(2.0,"км",
                                new Dimension().getLengthDimensions())));
        assertEquals(new NumberWithDimension(4.0,"А",
                        new Dimension().addDimension("кА",1000)
                        .addDimension("А",1).addDimension("мА",0.001)),
                new NumberWithDimension(2.0,"А",
                        new Dimension().addDimension("кА",1000)
                        .addDimension("А",1).addDimension("мА",0.001))
                        .plus(new NumberWithDimension(2.0,"А",
                                new Dimension().addDimension("кА",1000)
                                        .addDimension("А",1)
                                        .addDimension("мА",0.001))));
    }

    @Test
    void minus() {
        assertEquals(new NumberWithDimension(4.0,"км", new Dimension().getLengthDimensions()),
                new NumberWithDimension(6.0,"км",  new Dimension().getLengthDimensions())
                        .minus(new NumberWithDimension(2.0,"км",
                                new Dimension().getLengthDimensions())));
        assertEquals(new NumberWithDimension(5.0,"А",
                        new Dimension().addDimension("кА",1000)
                                .addDimension("А",1).addDimension("мА",0.001)),
                new NumberWithDimension(15.0,"А",
                        new Dimension().addDimension("кА",1000)
                                .addDimension("А",1).addDimension("мА",0.001))
                        .minus(new NumberWithDimension(10.0,"А",
                                new Dimension().addDimension("кА",1000)
                                        .addDimension("А",1)
                                        .addDimension("мА",0.001))));
    }

    @Test
    void multiply() {
        assertEquals(new NumberWithDimension(26.0,"км", new Dimension().getLengthDimensions()),
                new NumberWithDimension(1.0,"км",  new Dimension().getLengthDimensions())
                        .multiply(26.0));
        assertEquals(new NumberWithDimension(29.0,"м", new Dimension().getLengthDimensions()),
                new NumberWithDimension(1.0,"м",  new Dimension().getLengthDimensions())
                        .multiply(29.0));
        assertEquals(new NumberWithDimension(51.0,"А",
                        new Dimension().addDimension("кА",1000)
                                .addDimension("А",1).addDimension("мА",0.001)),
                new NumberWithDimension(2.0,"А",
                        new Dimension().addDimension("кА",1000)
                                .addDimension("А",1).addDimension("мА",0.001))
                        .multiply(25.5));
    }

    @Test
    void divide() {
        assertEquals(new NumberWithDimension(5.0,"км", new Dimension().getLengthDimensions()),
                new NumberWithDimension(25.0,"км",  new Dimension().getLengthDimensions())
                        .divide(5.0));
        assertEquals(new NumberWithDimension(5.0,"м", new Dimension().getLengthDimensions()),
                new NumberWithDimension(30.0,"м",  new Dimension().getLengthDimensions())
                        .divide(6.0));
        assertEquals(new NumberWithDimension(2.0,"А",
                        new Dimension().addDimension("кА",1000)
                                .addDimension("А",1).addDimension("мА",0.001)),
                new NumberWithDimension(12.0,"А",
                        new Dimension().addDimension("кА",1000)
                                .addDimension("А",1).addDimension("мА",0.001))
                        .divide(6.0));
    }

    @Test
    void divideForDim() {
        assertEquals(10.0,
                new NumberWithDimension(25.0,"км",  new Dimension().getLengthDimensions())
                        .divideForDim(new NumberWithDimension(2.5,"км",
                                new Dimension().getLengthDimensions())));
        assertEquals(5.5,
                new NumberWithDimension(11.0,"А",
                        new Dimension().addDimension("кА",1000)
                                .addDimension("А",1).addDimension("мА",0.001))
                        .divideForDim(new NumberWithDimension(2.0,"А",
                                new Dimension().addDimension("кА",1000)
                                        .addDimension("А",1)
                                        .addDimension("мА",0.001))));
    }

    @Test
    void translate() {
        assertEquals(new NumberWithDimension(2000.0,"мА",
                        new Dimension().addDimension("кА",1000)
                                .addDimension("А",1).addDimension("мА",0.001)),
                new NumberWithDimension(2.0,"А",
                        new Dimension().addDimension("кА",1000)
                                .addDimension("А",1).addDimension("мА",0.001))
                        .translate("мА"));
        assertEquals(new NumberWithDimension(6000.0,"м", new Dimension().getLengthDimensions()),
                new NumberWithDimension(6.0,"км",  new Dimension().getLengthDimensions())
                        .translate("м"));
    }


    @Test
    void compareTo() {
        assertEquals(0,
                new NumberWithDimension(25.0,"м",  new Dimension().getLengthDimensions())
                        .compareTo(new NumberWithDimension(0.025,"км",
                                new Dimension().getLengthDimensions())));
        assertEquals(1,
                new NumberWithDimension(25.0,"м",  new Dimension().getLengthDimensions())
                        .compareTo(new NumberWithDimension(0.024,"км",
                                new Dimension().getLengthDimensions())));
        assertEquals(-1,
                new NumberWithDimension(25.0,"м",  new Dimension().getLengthDimensions())
                        .compareTo(new NumberWithDimension(0.026,"км",
                                new Dimension().getLengthDimensions())));
        assertEquals(1,
                new NumberWithDimension(2.0,"А",
                        new Dimension().addDimension("кА",1000)
                                .addDimension("А",1).addDimension("мА",0.001))
                        .compareTo(new NumberWithDimension(2.0,"мА",
                                new Dimension().addDimension("кА",1000)
                                        .addDimension("А",1)
                                        .addDimension("мА",0.001))));
    }

}