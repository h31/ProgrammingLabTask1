package ru.spbstu.kspt.task1;

import java.util.Arrays;

public class Polinomial {

    private int[] function;
    private int degree;

    public Polinomial(int[] function) {
        this.function = function;
        this.degree = function.length - 1;
    }

    public Polinomial summarizeOrSubtract(Polinomial pol, boolean plus) {
        int maxDegree = Math.max(this.degree, pol.degree);
        int minDegree = Math.min(this.degree, pol.degree);
        int[] resultOfFunction = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            if (i <= minDegree) {
                resultOfFunction[i] = this.function[i] + (plus ? pol.function[i] : -pol.function[i]);
            } else {
                if (this.function.length > minDegree) resultOfFunction[i] = this.function[i];
                else resultOfFunction[i] = plus ? pol.function[i] : -pol.function[i];
            }
        }
        return new Polinomial(resultOfFunction);
    }

    public int evaluate(int x) {
        int result = 0;
        for (int i = 0; i <= this.degree; i++) {
            result += Math.pow(x, i) * this.function[i];
        }
        return result;
    }

    public Polinomial multiply(Polinomial pol) {
        int[] resultOfFunction = new int[this.degree + pol.degree + 1];
        for (int i = this.degree; i >= 0; i--) {
            for (int j = pol.degree; j >= 0; j--) {
                resultOfFunction[i + j] = this.function[i] * pol.function[j] + resultOfFunction[i + j];
            }
        }
        return new Polinomial(resultOfFunction);
    }

    private double[] functionToDouble(int[] function) {
        double[] result = new double[function.length];
        for (int i = 0; i < function.length; i++) {
            result[i] = (double) function[function.length - i - 1];
        }
        return result;
    }

    private Polinomial ClearRemainderOfZero() {
        for (int i = this.function.length - 1; i >= 0; i--){
            if (this.function[i] != 0) {
                int[] result = new int[i + 1];
                for (int j = i; j >= 0; j--) {
                    result[j] = this.function[j];
                }
                return new Polinomial(result);
            }
        }
        return new Polinomial(new int[]{0});
    }

    public Polinomial divide(Polinomial pol, boolean request) {
        if (this.degree < pol.degree)
            throw new IllegalArgumentException("Порядок делимого не может быть меньше порядка делителя");
        double[] dividend = this.functionToDouble(this.function); // Делимое
        double[] divider = pol.functionToDouble(pol.function); // Делитель
        double[] quotient = new double[this.degree - pol.degree + 1]; // Частное
        int currentIndexOfQuotient = 0; //Показывает индекс в частном для текущего шага деления
        int currentIndexOfDivider = 0; // Показывает индекс в делителе для текущего шага уменьшения делимого
        int degreeOfDividend = pol.degree; // Служит для проверки, не получился ли новый полином
        //(уменьшенное делимое),меньшим чем делитель
        while (degreeOfDividend <= this.degree) {
            quotient[currentIndexOfQuotient] = dividend[currentIndexOfQuotient] / divider[0];
            for (int i = currentIndexOfQuotient; i <= degreeOfDividend; i++) {
                dividend[i] -= quotient[currentIndexOfQuotient] * divider[currentIndexOfDivider];
                currentIndexOfDivider++;
            }
            currentIndexOfDivider = 0;
            currentIndexOfQuotient++;
            degreeOfDividend++;
        }
        if (request) {
            int[] result = new int[quotient.length];
            for (int i = 0; i < quotient.length; i++) {
                result[i] = (int) Math.round(quotient[quotient.length - i -1]);
            }
            return new Polinomial(result);
        } else {
            int[] result = new int[dividend.length];
            for (int i= 0; i < dividend.length; i++) {
                result[i] = (int) Math.round(dividend[dividend.length - i - 1]);
            }
            return new Polinomial(result).ClearRemainderOfZero();
        }
    }

    @Override
    public boolean equals(Object object) {
        Polinomial pol = (Polinomial) object;
        if (object.getClass() != this.getClass() || this.degree != pol.degree) return false;
        double a, b;
        if (this.function[0] == 0 && pol.function[0] == 0 && this.function.length == 1 && pol.function.length == 1)
            return true; // Проверка для случая, когда остаток получился 0
        if (this.function[this.degree] % pol.function[this.degree] == 0) {
            a = this.function[this.degree] % pol.function[this.degree];
        } else return false;
        for (int i = this.degree - 1; i >= 0; i--) {
            if (pol.function[i] != 0) {
                if (this.function[i] % pol.function[i] == 0) {
                    b = this.function[i] % pol.function[i];
                    if (a != b) return false;
                } else if (this.function[i] != 0) return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.function[this.degree] >= 0)
            result.append(this.function[this.degree]).append("x^").append(this.degree);
        else
            result.append(" - ").append(Math.abs(this.function[this.degree]));
        for (int i = this.degree - 1; i > 0; i--) {
            if (this.function[i] >= 0) {
                result.append(" + ");
            } else {
                result.append(" - ");
            }
            result.append(Math.abs(this.function[i])).append("x^").append(i);
        }
        if (this.function[0] >= 0)
            result.append(" + ");
        else
            result.append(" - ");
        result.append(this.function[0]);
        return result.toString();
    }

    @Override
    public int hashCode() {
        return 11 * Arrays.hashCode(this.function);
    }

    public static void main(String[] args) {
    }
}
