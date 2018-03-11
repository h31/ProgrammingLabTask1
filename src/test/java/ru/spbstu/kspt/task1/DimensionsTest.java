package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DimensionsTest {
    @Test
    void getValueDimension() {
        assertEquals(100000, new Dimensions().getLengthDimensions().getDimensionValue("км"));
        assertEquals(1000000, new Dimensions().getWeightDimensions().getDimensionValue("кг"));
        assertEquals(3600, new Dimensions().getTimeDimensions().getDimensionValue("ч"));
        assertEquals(1, new Dimensions().getLengthDimensions().getDimensionValue("см"));
        assertEquals(1000, new Dimensions().getWeightDimensions().getDimensionValue("г"));
        assertEquals(60, new Dimensions().getTimeDimensions().getDimensionValue("мин"));
        try {
            assertEquals(60, new Dimensions().getTimeDimensions().getDimensionValue("оки"));
            assertEquals(60, new Dimensions().getTimeDimensions().getDimensionValue("кауаку"));
            assertEquals(60, new Dimensions().getTimeDimensions().getDimensionValue("минутки"));
        }
        catch (IllegalArgumentException e){
            System.out.println("Ошибка поймана.");
        }
    }

}