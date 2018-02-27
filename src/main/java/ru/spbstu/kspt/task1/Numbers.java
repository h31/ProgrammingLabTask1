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
    private String dimen;

    public double getNumber() {
        return number;
    }

    public String getDimen() {
        return dimen;
    }

    Numbers() {
        number = 0;
        dimen = "м";
    }

    Numbers(double number, String dimen) {
        this.number = number;
        this.dimen = dimen;
    }

    Numbers plus(Numbers other) {
        if (new Dimension(dimen).equalsDim( new Dimension(other.dimen))) {
            return new Numbers(number + other.number *
                    (new Dimension(other.dimen).power() / new Dimension(dimen).power()), dimen);
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }

    Numbers minus(Numbers other) {
        if (new Dimension(dimen).equalsDim(new Dimension(other.dimen))) {
            return new Numbers(number - other.number *
                    (new Dimension(other.dimen).power() / new Dimension(dimen).power()), dimen);
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }

    Numbers multiplication(double multi) {
        return new Numbers(number * multi, dimen);
    }

    Numbers division(double div) {
        return new Numbers(number / div, dimen);
    }

    Numbers divisionForDim(Numbers other) {
        if (new Dimension(dimen).equalsDim(new Dimension(other.dimen))) {
            return new Numbers(number /
                    (other.number * (new Dimension(other.dimen).power() / new Dimension(dimen).power())), dimen);
        }
        else {
            throw new IllegalArgumentException("Разные классы размерностей");
        }
    }


    Numbers whoIsBigger (Numbers other) {
        if (new Dimension (dimen).equalsDim(new Dimension(other.dimen))) {
            if (number * new Dimension(dimen).power() >= other.number * new Dimension(other.dimen).power()) {
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
        if (new Dimension(dimen).equalsDim(new Dimension(other.dimen))) {
            if (number * new Dimension(dimen).power() <= other.number * new Dimension(other.dimen).power()) {
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
        if (new Dimension(dimen).equalsDim(new Dimension(other))) {
            if (dimen.equals(other)) {
                return new Numbers(number *
                        (new Dimension(other).power() / new Dimension(dimen).power()), other);
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
        if (new Dimension(dimen).equalsDim(new Dimension(other.dimen))) {
            return  (number == other.number * (new Dimension(other.dimen).power() / new Dimension(dimen).power()));
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
                    && dimen.equals(other.dimen);
        }
        return false;
    }

    @Override
    public String toString(){
        return "" + number + " " + dimen;
    }
}