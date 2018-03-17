package ru.spbstu.kspt.task1;

public class Polinomial {

    private int[] function;
    private int degree;

    public Polinomial(int[] function) {
        this.function = function;
        this.degree = function.length - 1;
    }

    public Polinomial summarizeOrSubtract(Polinomial pol, boolean request) {
        int maxDegree = Math.max(this.degree, pol.degree);
        int minDegree = Math.min(this.degree, pol.degree);
        int[] resultOfFunction = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            if (i <= minDegree) {
                resultOfFunction[i] = this.function[i] + (request ? pol.function[i] : - pol.function[i]);
            } else {
                if (this.function.length > minDegree) resultOfFunction[i] = this.function[i];
                else resultOfFunction[i] = request ? pol.function[i] : - pol.function[i];
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

    @Override
    public boolean equals(Object object) {
        Polinomial pol = (Polinomial) object;
        if (object.getClass() != this.getClass() || this.degree != pol.degree) return false;
        double a, b;
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

    public static void main(String[] args) {
    }
}
