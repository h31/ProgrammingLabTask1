package ru.spbstu.kspt.task1;

/**
 * Класс числа с размерностью
 *
 * plus - сложение размерных чисел
 *
 * minus - вычитание размерных чисел
 *
 * multiplication - умножение размерного числа на вещественное
 *
 * division - деление размерного числа на вещественное
 *
 * divisionForDim - деление размерных чисел
 *
 * whoIsBigger - нахождение наибольшего числа среди размерных чисел
 *
 * whoIsLess - нахождение наименьшего числа среди размерных чисел
 *
 * transfer - перевод размерного числа из одной размерности в другую
 *
 * equalsNum - сравнение размерных чисел
 *
 * Чтение из строки в разработке
 */
public class Numbers {

    private double number;
    private String dimension;

    double getNumber() {
        return number;
    }

    String getDimension() {
        return dimension;
    }

    Numbers() {
        number = 0;
        dimension = "м";
    }

    Numbers(double number, String dimension) {
        this.number = number;
        this.dimension = dimension;
    }

    Numbers plus(Numbers other) {
        if (new Dimension(dimension).equalsDim( new Dimension(other.dimension))) {
            return new Numbers(number + other.number *
                    (new Dimension(other.dimension).power() / new Dimension(dimension).power()), dimension);
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }

    Numbers minus(Numbers other) {
        if (new Dimension(dimension).equalsDim(new Dimension(other.dimension))) {
            return new Numbers(number - other.number *
                    (new Dimension(other.dimension).power() / new Dimension(dimension).power()), dimension);
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }

    Numbers multiplication(double multi) {
        return new Numbers(number * multi, dimension);
    }

    Numbers division(double div) {
        return new Numbers(number / div, dimension);
    }

    Numbers divisionForDim(Numbers other) {
        if (new Dimension(dimension).equalsDim(new Dimension(other.dimension))) {
            return new Numbers(number / (other.number *
                    (new Dimension(other.dimension).power() / new Dimension(dimension).power())), dimension);
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }


    Numbers whoIsBigger (Numbers other) {
        if (new Dimension (dimension).equalsDim(new Dimension(other.dimension))) {
            if (number * new Dimension(dimension).power() >= other.number * new Dimension(other.dimension).power()) {
                return this;
            }
            else {
                return other;
            }
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }

    Numbers whoIsLess (Numbers other) {
        if (new Dimension(dimension).equalsDim(new Dimension(other.dimension))) {
            if (number * new Dimension(dimension).power() <= other.number * new Dimension(other.dimension).power()) {
                return this;
            }
            else {
                return other;
            }
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }

    Numbers transfer (String other) {
        if (new Dimension(dimension).equalsDim(new Dimension(other))) {
            if (!dimension.equals(other)) {
                return new Numbers(number *
                        (new Dimension(dimension).power() / new Dimension(other).power()), other);
            }
            else {
                System.out.println("Перевод не нуждается");
                return this;
            }
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }

    boolean equalsNum (Numbers other) {
        if (new Dimension(dimension).equalsDim(new Dimension(other.dimension))) {
            return (number == other.number * (new Dimension(other.dimension).power() / new Dimension(dimension).power()));
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Numbers) {
            Numbers other = (Numbers) obj;
            return number == other.number
                    && dimension.equals(other.dimension);
        }
        return false;
    }

    @Override
    public String toString(){
        return "" + number + " " + dimension;
    }
}