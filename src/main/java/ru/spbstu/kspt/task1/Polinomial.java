package ru.spbstu.kspt.task1;

import java.util.ArrayList;
import java.util.Arrays;

public class Polinomial {

    private int[] function;
    private int degree;

    public Polinomial(int[] function) {
        this.function = function;
        this.degree = function.length - 1;
    }

    public Polinomial summarizeOrSubtract(Polinomial pol, String request) {
        if (!request.equals("Summarize") && !request.equals("Subtract"))
                throw new IllegalArgumentException("Неверный запрос: введите Summarize или Subtract");
        int maxDegree = Math.max(this.degree, pol.degree);
        int minDegree = Math.min(this.degree, pol.degree);
        int[] resultFunction = new int[maxDegree + 1];
        if (request.equals("Summarize")) {
            for (int i = 0; i <= maxDegree; i++) {
                if (i <= minDegree) {
                    resultFunction[i] = this.function[i] + pol.function[i];
                } else {
                    if (this.function.length > minDegree) resultFunction[i] = this.function[i];
                    else resultFunction[i] = pol.function[i];
                }
            }
        } else {
            for (int i = 0; i <= maxDegree; i++) {
                if (i <= minDegree) {
                    resultFunction[i] = this.function[i] - pol.function[i];
                } else {
                    if (this.function.length > minDegree) resultFunction[i] = this.function[i];
                    else resultFunction[i] = -pol.function[i];
                }
            }
        }
        return new Polinomial(resultFunction);
    }

    public int evaluate(int x) {
        int result = 0;
        for (int i = 0; i <= this.degree; i++) {
            result += Math.pow(x, i) * this.function[i];
        }
        return result;
    }

    @Override
    public boolean equals(Object object) {
        Polinomial pol = (Polinomial) object;
        if (object.getClass() != this.getClass() || this.degree != pol.degree) return false;
        double a,b;
        if (this.function[this.degree] % pol.function[this.degree] == 0) {
            a = this.function[this.degree] % pol.function[this.degree];
        } else return false;
        for (int i = this.degree - 1; i >= 0; i--) {
            if (pol.function[i] != 0) {
                if (this.function[i] % pol.function[i] == 0) {
                    b = this.function[i] % pol.function[i];
                    if (a != b) return false;
                }
                else if(this.function[i] != 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
