package ru.spbstu.kspt.task1;

interface NumberWithDimensionInterface {
    /**
     * Взятие вещественного числа из класса.
     */
    double getNumber(); //
    /**
     * Взятие размерности из класса в строковой форме.
     */
    String getDimension();
    /**
     * Сложение двух вещественных чисел с размерностью.
     */
    NumberWithDimension plus(NumberWithDimension other);
    /**
     * Вычитание двух вещественных чисел с размерностью.
     */
    NumberWithDimension minus(NumberWithDimension other);
    /**
     * Умножение числа с размерностью на вещественное число.
     */
    NumberWithDimension multiply(double multi);
    /**
     * Деление числа с размерностью на вещественное число.
     */
    NumberWithDimension divide(double div);
    /**
     * Деление числа с размерностью на другое число с размерностью.
     */
    double divideForDim(NumberWithDimension other);
    /**
     * Перевод числа с размерностью из одной величины в другую.
     */
    NumberWithDimension translate (String other);
}
