package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.logging.Level;

/**
 * Класс числа с размерностью
 *
 * plus - сложение размерных чисел
 *
 * minus - вычитание размерных чисел
 *
 * multiply - умножение размерного числа на вещественное
 *
 * divide - деление размерного числа на вещественное
 *
 * divideForDim - деление размерных чисел
 */
class NumberWithDimension implements Comparable<NumberWithDimension>, NumberWithDimensionInterface {

    private double number;

    private String dimension;

    private Dimension dimensionClass;

    @Override
    public double getNumber() {
        return number;
    }

    @Override
    public String getDimension() {
        return dimension;
    }

    NumberWithDimension(double number, String dimension, Dimension dimensionClass) {
        this.number = number;
        this.dimension = dimension;
        this.dimensionClass = dimensionClass;
    }

    @Override
    public NumberWithDimension plus(NumberWithDimension other) { // Сложение размерных чисел
            return new NumberWithDimension(number + other.number *
                    (other.dimensionClass.getValueDimension(other.dimension) /
                            dimensionClass.getValueDimension(dimension)), dimension, dimensionClass);
    }

    @Override
    public NumberWithDimension minus(NumberWithDimension other) { // Вычитание размерных чисел
        return new NumberWithDimension(number - other.number *
                (other.dimensionClass.getValueDimension(other.dimension) /
                        dimensionClass.getValueDimension(dimension)), dimension, dimensionClass);
    }

    @Override
    public NumberWithDimension multiply(double multi) { // Умножение на вещественное число
        return new NumberWithDimension(number * multi, dimension, dimensionClass);
    }

    @Override
    public NumberWithDimension divide(double div) { // Деление на вещественное число
        return new NumberWithDimension(number / div, dimension, dimensionClass);
    }

    @Override
    public double divideForDim(NumberWithDimension other) { // Деление на другое число с размерностью
        return number / (other.number * (other.dimensionClass.getValueDimension(other.dimension) /
                dimensionClass.getValueDimension(other.dimension)));
    }

    @Override
    public NumberWithDimension translation (String other) { //Переводим вещественное число из одной величины в другую
        return new NumberWithDimension(number *
                (dimensionClass.getValueDimension(dimension) / dimensionClass.getValueDimension(other)),
                other, dimensionClass);
    }

    @Override
    public int compareTo(NumberWithDimension other) { //Cравниваем два числа, подводя их под одну величину
        return (number * dimensionClass.getValueDimension(dimension)) > (other.number
                * other.dimensionClass.getValueDimension(other.dimension)) ? 1 : (number
                * dimensionClass.getValueDimension(dimension)) == (other.number
                * other.dimensionClass.getValueDimension(other.dimension)) ? 0 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumberWithDimension numbers = (NumberWithDimension) o;

        if (Double.compare(numbers.number, number) != 0) return false;
        if (dimension != null ? !dimension.equals(numbers.dimension) : numbers.dimension != null) return false;
        return dimensionClass != null ? dimensionClass.equals(numbers.dimensionClass) : numbers.dimensionClass == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(number);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dimension != null ? dimension.hashCode() : 0);
        result = 31 * result + (dimensionClass != null ? dimensionClass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return "" + number + " " + dimension;
    }
}