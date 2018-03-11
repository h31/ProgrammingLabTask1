package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberWithDimensionTest {

    private static final Logger logger = LogManager.getLogger(NumberWithDimensionTest.class);

    @Test
    void getNumber() {
        assertEquals(2.0,
                new NumberWithDimension(2.0,"км",  new Dimensions().getLengthDimensions())
                        .getNumber());
    }

    @Test
    void getDimension() {
        assertEquals("км",
                new NumberWithDimension(2.0,"км",  new Dimensions().getLengthDimensions())
                        .getDimension());
    }

    @Test
    void plus() throws IllegalArgumentException{
        logger.info("Начало теста на сложение с вещественным числом с размерностью, " +
                "используя уже приготовленные размерности.");
        assertEquals(new NumberWithDimension(4.0,"км",
                        new Dimensions().getLengthDimensions()),
                new NumberWithDimension(2.0,"км",
                        new Dimensions().getLengthDimensions())
                        .plus(new NumberWithDimension(2.0,"км",
                                new Dimensions().getLengthDimensions())));
        logger.info("Начало теста на сложение вещественного числа с размерностью, " +
                "используя размерности, написанные пользователем.");
        assertEquals(new NumberWithDimension(4.0,"А",
                        new Dimensions()
                                .addDimension("кА",1000)
                                .addDimension("А",1)
                                .addDimension("мА",0.001)),
                new NumberWithDimension(2.0,"А",
                        new Dimensions()
                                .addDimension("кА",1000)
                                .addDimension("А",1)
                                .addDimension("мА",0.001))
                        .plus(new NumberWithDimension(2.0,"А",
                                new Dimensions()
                                        .addDimension("кА",1000)
                                        .addDimension("А",1)
                                        .addDimension("мА",0.001))));
        logger.info("Начало теста на сложение вещественного числа с размерностью, чтобы мы ловили ошибку.");
        try {assertEquals(new NumberWithDimension(4.0,"км",
                        new Dimensions().getLengthDimensions()),
                new NumberWithDimension(2.0,"км",
                        new Dimensions().getLengthDimensions())
                        .plus(new NumberWithDimension(2.0,"км",
                                new Dimensions().getWeightDimensions()))); }
        catch (IllegalArgumentException e) {
            System.out.println("Ошибка поймана.");
        }
        logger.info("Тест на сложение с вещественным числом с размерностью пройдены.");
    }


    @Test
    void minus() {
        logger.info("Начало теста на вычитание вещественного числа с размерностью, " +
                "используя уже приготовленные размерности.");
        assertEquals(new NumberWithDimension(4.0,"км",
                        new Dimensions().getLengthDimensions()),
                new NumberWithDimension(6.0,"км",
                        new Dimensions().getLengthDimensions())
                        .minus(new NumberWithDimension(2.0,"км",
                                new Dimensions().getLengthDimensions())));
        logger.info("Начало теста на вычитание вещественного числа с размерностью, " +
                "используя размерности, написанные пользователем.");
        assertEquals(new NumberWithDimension(5.0,"А",
                        new Dimensions()
                                .addDimension("кА",1000)
                                .addDimension("А",1)
                                .addDimension("мА",0.001)),
                new NumberWithDimension(15.0,"А",
                        new Dimensions()
                                .addDimension("кА",1000)
                                .addDimension("А",1)
                                .addDimension("мА",0.001))
                        .minus(new NumberWithDimension(10.0,"А",
                                new Dimensions()
                                        .addDimension("кА",1000)
                                        .addDimension("А",1)
                                        .addDimension("мА",0.001))));
        logger.info("Начало теста на вычитание вещественного числа с размерностью, чтобы мы ловили ошибку.");
        try {assertEquals(new NumberWithDimension(4.0,"км",
                        new Dimensions().getLengthDimensions()),
                new NumberWithDimension(2.0,"км",
                        new Dimensions().getLengthDimensions())
                        .minus(new NumberWithDimension(2.0,"км",
                                new Dimensions().getWeightDimensions()))); }
        catch (IllegalArgumentException e) {
            System.out.println("Ошибка поймана.");
        }
        logger.info("Тест на вычитание с вещественным числом с размерностью пройдены.");
    }

    @Test
    void multiply() {
        logger.info("Начало теста на умножение на вещественное число, используя уже приготовленные размерности.");
        assertEquals(new NumberWithDimension(26.0,"км",
                        new Dimensions().getLengthDimensions()),
                new NumberWithDimension(1.0,"км",
                        new Dimensions().getLengthDimensions())
                        .multiply(26.0));
        assertEquals(new NumberWithDimension(29.0,"м",
                        new Dimensions().getLengthDimensions()),
                new NumberWithDimension(1.0,"м",
                        new Dimensions().getLengthDimensions())
                        .multiply(29.0));
        logger.info("Начало теста на умножение на вещественное число, используя размерности, написанные пользователем.");
        assertEquals(new NumberWithDimension(51.0,"А",
                        new Dimensions()
                                .addDimension("кА",1000)
                                .addDimension("А",1)
                                .addDimension("мА",0.001)),
                new NumberWithDimension(2.0,"А",
                        new Dimensions()
                                .addDimension("кА",1000)
                                .addDimension("А",1)
                                .addDimension("мА",0.001))
                        .multiply(25.5));
        logger.info("Тест на умножение на вещественное число пройдены.");
    }

    @Test
    void divide() {
        logger.info("Начало теста на деление на вещественное число, используя уже приготовленные размерности.");
        assertEquals(new NumberWithDimension(5.0,"км",
                        new Dimensions().getLengthDimensions()),
                new NumberWithDimension(25.0,"км",
                        new Dimensions().getLengthDimensions())
                        .divide(5.0));
        assertEquals(new NumberWithDimension(5.0,"м",
                        new Dimensions().getLengthDimensions()),
                new NumberWithDimension(30.0,"м",
                        new Dimensions().getLengthDimensions())
                        .divide(6.0));
        logger.info("Начало теста на деление на вещественное число, используя размерности, написанные пользователем.");
        assertEquals(new NumberWithDimension(2.0,"А",
                        new Dimensions()
                                .addDimension("кА",1000)
                                .addDimension("А",1)
                                .addDimension("мА",0.001)),
                new NumberWithDimension(12.0,"А",
                        new Dimensions()
                                .addDimension("кА",1000)
                                .addDimension("А",1)
                                .addDimension("мА",0.001))
                        .divide(6.0));
        logger.info("Тест на деление на вещественное число пройдены.");
    }

    @Test
    void divideForDim() {
        logger.info("Начало теста на деление на вещественное число с размерностью, " +
                "используя уже приготовленные размерности.");
        assertEquals(10.0,
                new NumberWithDimension(25.0,"км",
                        new Dimensions().getLengthDimensions())
                        .divideForDim(new NumberWithDimension(2.5,"км",
                                new Dimensions().getLengthDimensions())));
        logger.info("Начало теста на деление на вещественное число с размерностью, " +
                "используя размерности, написанные пользователем.");
        assertEquals(5.5, new NumberWithDimension(11.0,"А",
                        new Dimensions()
                                .addDimension("кА",1000)
                                .addDimension("А",1)
                                .addDimension("мА",0.001))
                        .divideForDim(new NumberWithDimension(2.0,"А",
                                new Dimensions()
                                        .addDimension("кА",1000)
                                        .addDimension("А",1)
                                        .addDimension("мА",0.001))));
        logger.info("Начало теста на деление на вещественное число с размерностью, чтобы мы ловили ошибку.");
        try {assertEquals(new NumberWithDimension(4.0,"км",
                        new Dimensions().getLengthDimensions()),
                new NumberWithDimension(2.0,"км",
                        new Dimensions().getLengthDimensions())
                        .plus(new NumberWithDimension(2.0,"км",
                                new Dimensions().getWeightDimensions()))); }
        catch (IllegalArgumentException e) {
            System.out.println("Ошибка поймана.");
        }
        logger.info("Тест на деление на вещественное число с размерностью пройдены.");
    }

    @Test
    void translate() {
        logger.info("Начало теста на перевод вещественного числа с размерностью, " +
                "используя размерности, написанные пользователем.");
        assertEquals(new NumberWithDimension(2000.0,"мА",
                        new Dimensions()
                                .addDimension("кА",1000)
                                .addDimension("А",1)
                                .addDimension("мА",0.001)),
                new NumberWithDimension(2.0,"А",
                        new Dimensions()
                                .addDimension("кА",1000)
                                .addDimension("А",1)
                                .addDimension("мА",0.001))
                        .translate("мА"));
        logger.info("Начало теста на перевод вещественного числа с размерностью, " +
                "используя уже приготовленные размерности.");
        assertEquals(new NumberWithDimension(6000.0,"м",
                        new Dimensions().getLengthDimensions()),
                new NumberWithDimension(6.0,"км",
                        new Dimensions().getLengthDimensions())
                        .translate("м"));
        logger.info("Начало теста на перевод вещественного числа с размерностью, чтобы мы ловили ошибку.");
        try {assertEquals(new NumberWithDimension(4.0,"км",
                        new Dimensions().getLengthDimensions()),
                new NumberWithDimension(2.0,"км",
                        new Dimensions().getLengthDimensions())
                        .plus(new NumberWithDimension(2.0,"км",
                                new Dimensions().getWeightDimensions()))); }
        catch (IllegalArgumentException e) {
            System.out.println("Ошибка поймана.");
        }
        logger.info("Тест на перевод чисел с размерностью пройдены.");
    }


    @Test
    void compareTo() {
        logger.info("Начало теста на сравнение между числами, используя уже приготовленные размерности.");
        assertEquals(0,
                new NumberWithDimension(25.0,"м",
                        new Dimensions().getLengthDimensions())
                        .compareTo(new NumberWithDimension(0.025,"км",
                                new Dimensions().getLengthDimensions())));
        assertEquals(1,
                new NumberWithDimension(25.0,"м",
                        new Dimensions().getLengthDimensions())
                        .compareTo(new NumberWithDimension(0.024,"км",
                                new Dimensions().getLengthDimensions())));
        assertEquals(-1,
                new NumberWithDimension(25.0,"м",
                        new Dimensions().getLengthDimensions())
                        .compareTo(new NumberWithDimension(0.026,"км",
                                new Dimensions().getLengthDimensions())));
        logger.info("Начало теста на сравнение между числами, используя размерности, написанные пользователем.");
        assertEquals(1, new NumberWithDimension(2.0,"А",
                        new Dimensions()
                                .addDimension("кА",1000)
                                .addDimension("А",1)
                                .addDimension("мА",0.001))
                        .compareTo(new NumberWithDimension(2.0,"мА",
                                new Dimensions()
                                        .addDimension("кА",1000)
                                        .addDimension("А",1)
                                        .addDimension("мА",0.001))));
        logger.info("Начало теста на сравнение вещественных чисел с размерностью, чтобы мы ловили ошибку.");
        try {assertEquals(new NumberWithDimension(4.0,"км",
                        new Dimensions().getLengthDimensions()),
                new NumberWithDimension(2.0,"км",
                        new Dimensions().getLengthDimensions())
                        .plus(new NumberWithDimension(2.0,"км",
                                new Dimensions().getWeightDimensions()))); }
        catch (IllegalArgumentException e) {
            System.out.println("Ошибка поймана.");
        }
        logger.info("Тест на сравнение пройдены.");
    }

}