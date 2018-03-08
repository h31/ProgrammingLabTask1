package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DimensionTest {
    @Test
    void getValueDimension() {
        assertEquals(100000, new Dimension().getLengthDimensions().getValueDimension("км"));
        assertEquals(1000000, new Dimension().getWeightDimensions().getValueDimension("кг"));
        assertEquals(3600, new Dimension().getTimeDimensions().getValueDimension("ч"));
        assertEquals(1, new Dimension().getLengthDimensions().getValueDimension("см"));
        assertEquals(1000, new Dimension().getWeightDimensions().getValueDimension("г"));
        assertEquals(60, new Dimension().getTimeDimensions().getValueDimension("мин"));
    }

}