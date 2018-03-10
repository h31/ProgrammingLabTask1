package ru.spbstu.kspt.task1;

interface NumberWithDimensionInterface {

    double getNumber(); // Взятие вещественного числа из класса

    String getDimension(); // Взятие размерности из класса в строковой форме

    NumberWithDimension plus(NumberWithDimension other); // Сложение двух вещественных чисел с размерностью

    NumberWithDimension minus(NumberWithDimension other); // Вычитание двух вещественных чисел с размерностью

    NumberWithDimension multiply(double multi); // Умножение числа с размерностью на вещественное число

    NumberWithDimension divide(double div); // Деление числа с размерностью на вещественное число

    double divideForDim(NumberWithDimension other); // Деление двух вещественных чисел с размерностью

    NumberWithDimension translation (String other); // Перевод числа с размерностью из одной величины в другую
}
