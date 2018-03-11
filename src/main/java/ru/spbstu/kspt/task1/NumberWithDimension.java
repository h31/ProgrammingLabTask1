package ru.spbstu.kspt.task1;


/**
 * Класс числа с размерностью
 */
class NumberWithDimension implements Comparable<NumberWithDimension>, NumberWithDimensionInterface {

    private double number;

    private String dimension;

    private Dimensions dimensionClass;

    @Override
    public double getNumber() {
        return number;
    }

    @Override
    public String getDimension() {
        return dimension;
    }

    NumberWithDimension(double number, String dimension, Dimensions dimensionClass) {
        this.number = number;
        this.dimension = dimension;
        this.dimensionClass = dimensionClass;
    }

    /**
     * Дублирующий метод для вычисления чисел с размерностью. Используется во многих дальнейших функциях.
     */
    private double calculation(NumberWithDimension other) {
        if(!dimensionClass.equals(other.dimensionClass)) {
            throw new IllegalArgumentException("Размерности не совпадают");
        }
        return other.number * (other.dimensionClass.getDimensionValue(other.dimension)
                / dimensionClass.getDimensionValue(dimension));
    }

    /**
     * Сложение двух вещественных чисел с размерностью.
     */
    @Override
    public NumberWithDimension plus(NumberWithDimension other) {
        return new NumberWithDimension(number + calculation(other), dimension, dimensionClass);
    }

    /**
     * Вычитание двух вещественных чисел с размерностью.
     */
    @Override
    public NumberWithDimension minus(NumberWithDimension other) {
        return new NumberWithDimension(number - calculation(other), dimension, dimensionClass);
    }

    /**
     * Умножение вещественного числа с размерностью на вещественное число.
     */
    @Override
    public NumberWithDimension multiply(double multi) {
        return new NumberWithDimension(number * multi, dimension, dimensionClass);
    }

    /**
     * Деление вещественного числа с размерностью на вещественное число.
     */
    @Override
    public NumberWithDimension divide(double div) {
        return new NumberWithDimension(number / div, dimension, dimensionClass);
    }

    /**
     * Деление двух вещественных чисел друг на друга. В результате получаем вещественное число.
     */
    @Override
    public double divideForDim(NumberWithDimension other) {
        return number / calculation(other);
    }

    /**
     * Перевод вещественного числа с размерностью из одной размерности в другую.
     */
    @Override
    public NumberWithDimension translate(String other) {
        return new NumberWithDimension(number *
                (dimensionClass.getDimensionValue(dimension) / dimensionClass.getDimensionValue(other)),
                other, dimensionClass);
    }

    /**
     * Сравнение двух вещественных чисел с размерностью.
     */
    @Override
    public int compareTo(NumberWithDimension other) {
        return (number ) > (calculation(other)) ? 1 : (number) == (calculation(other)) ? 0 : -1;
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