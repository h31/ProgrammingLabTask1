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

    private Dimension dimensionClass = new Dimension(dimension);

    double getNumber() {
        return number;
    }

    String getDimension() {
        return dimension;
    }

    Numbers() {
        number = 0;
        dimension = "м";
        dimensionClass = new Dimension(dimension);
    }

    Numbers(double number, String dimension) {
        this.number = number;
        this.dimension = dimension;
        this.dimensionClass = new Dimension(dimension);
    }

    Numbers plus(Numbers other) {
        if (dimensionClass.equalsDim(other.dimensionClass)) {
            return new Numbers(number + other.number *
                    (other.dimensionClass.power() / dimensionClass.power()), dimension);
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }

    Numbers minus(Numbers other) {
        if (dimensionClass.equalsDim(other.dimensionClass)) {
            return new Numbers(number - other.number *
                    (other.dimensionClass.power() / dimensionClass.power()), dimension);
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

    double divisionForDim(Numbers other) {
        if (dimensionClass.equalsDim(other.dimensionClass)) {
            return number / (other.number * (other.dimensionClass.power() / dimensionClass.power()));
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }


    Numbers whoIsBigger (Numbers other) {
        if (dimensionClass.equalsDim(other.dimensionClass)) {
            if (number * dimensionClass.power() >= other.number * other.dimensionClass.power()) {
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
        if (dimensionClass.equalsDim(other.dimensionClass)) {
            if (number * dimensionClass.power() <= other.number * other.dimensionClass.power()) {
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
        if (dimensionClass.equalsDim(new Dimension(other))) {
            if (!dimension.equals(other)) {
                return new Numbers(number *
                        (dimensionClass.power() / new Dimension(other).power()), other);
            }
            else {
                return this;
            }
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }

    boolean equalsNum (Numbers other) {
        if (dimensionClass.equalsDim(other.dimensionClass)) {
            return (number == other.number * (other.dimensionClass.power() / dimensionClass.power()));
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Numbers numbers = (Numbers) o;

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