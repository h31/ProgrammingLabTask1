package ru.spbstu.kspt.task1;

import com.sun.javafx.image.PixelConverter;

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
class NumberWithDimension {

    private double number;

    private String dimension;

    private Dimension dimensionClass;

    double getNumber() {
        return number;
    }

    Dimension getDimensionClass() {
        return dimensionClass;
    }

    String getDimension() {
        return dimension;
    }

    NumberWithDimension(double number, String dimension, Dimension dimensionClasses) {
        this.number = number;
        this.dimension = dimension;
        this.dimensionClass = dimensionClasses;
    }

    NumberWithDimension plus(NumberWithDimension other) { // Сложение размерных чисел
            return new NumberWithDimension(number + other.number *
                    (other.dimensionClass.getValue(other.dimension) /
                            dimensionClass.getValue(dimension)), dimension, dimensionClass);
    }

    NumberWithDimension minus(NumberWithDimension other) { // Вычитание размерных чисел
        return new NumberWithDimension(number - other.number *
                (other.dimensionClass.getValue(other.dimension) /
                        dimensionClass.getValue(dimension)), dimension, dimensionClass);
    }

    NumberWithDimension multiply(double multi) {
        return new NumberWithDimension(number * multi, dimension, dimensionClass);
    }

    NumberWithDimension divide(double div) {
        return new NumberWithDimension(number / div, dimension, dimensionClass);
    }

    double divideForDim(NumberWithDimension other) {
        return number / (other.number * (other.dimensionClass.getValue(other.dimension) /
                dimensionClass.getValue(other.dimension)));
    }

    NumberWithDimension transfer (String other) {
        return new NumberWithDimension(number *
                (dimensionClass.getValue(dimension) / dimensionClass.getValue(other)), other, dimensionClass);
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