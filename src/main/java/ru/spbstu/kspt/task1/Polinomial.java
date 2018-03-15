package ru.spbstu.kspt.task1;

import java.util.ArrayList;

public class Polinomial {

    private ArrayList<Integer> coef;
    private String function;
    private int degree;

    public Polinomial(int degree, String function) {
        this.coef = new ArrayList<>();
        this.degree = degree;
        if (this.degree < 0) {
            throw new UnsupportedOperationException("Порядок полинома не может быть меньше нуля");
        }
        this.function = function;
        if (!this.function.matches("") && !this.function.matches("-?\\d+(;-?\\d+)*")) {
            throw new UnsupportedOperationException("Не верный формат ввода для function");
        }
        if (!this.function.equals("")) {
            String[] parts = this.function.split(";");
            for (int i = 0; i < parts.length; i++) {
                if (!parts[i].isEmpty())
                    this.coef.add(Integer.parseInt(parts[i]));
            }
        } else {
            for (int i = 0; i <= this.degree; i++) {
                this.coef.add(0);
            }
        }
    }

    private Polinomial min(Polinomial pol) {
        String minFunction = (this.degree < pol.degree) ? this.function : pol.function;
        return new Polinomial(Math.min(this.degree, pol.degree), minFunction);
    }

    private Polinomial alignment(Polinomial pol) {
        Polinomial result = this.min(pol);
        for (int i = 0; i < Math.abs(this.degree - pol.degree); i++) {
            result.coef.add(i, 0);
        }
        result.function = result.toString();
        return result;
    }

    public Polinomial plus(Polinomial pol) {
        Polinomial maxPol = (this.degree < pol.degree) ? pol : this;
        Polinomial minPol = this.alignment(pol);
        Polinomial result = new Polinomial(maxPol.degree, "");
        for (int i = 0; i <= maxPol.degree; i++) {
            result.coef.set(i, (maxPol.coef.get(i) + minPol.coef.get(i)));
        }
        result.function = result.toString();
        return result;
    }

    public Polinomial minus(Polinomial pol) {
        Polinomial minuend, subtrahend;
        if (this.degree > pol.degree) {
            minuend = this;
            subtrahend = this.alignment(pol);
        } else {
            minuend = this.alignment(pol);
            subtrahend = pol;
        }
        Polinomial result = new Polinomial(Math.max(this.degree, pol.degree), "");
        for (int i = 0; i <= Math.max(this.degree, pol.degree); i++) {
            result.coef.set(i, (minuend.coef.get(i) - subtrahend.coef.get(i)));
        }
        result.function = result.toString();
        return result;
    }

    public Polinomial multiplication(Polinomial pol) {
        int currentDegree;
        Polinomial result = new Polinomial(this.degree + pol.degree, "");
        for (int i = this.degree; i >= 0; i--) {
            currentDegree = i + pol.degree;
            for (int j = pol.degree; j >= 0; j--) {
                result.coef.set(currentDegree, (this.coef.get(i) * pol.coef.get(j)) + result.coef.get(currentDegree));
                currentDegree--;
            }
        }
        result.function = result.toString();
        return result;
    }

    public int computation(int x) {
        int result = 0;
        for (int i = 0; i <= this.degree; i++) {
            result += Math.pow(x, i) * this.coef.get(this.coef.size() - i - 1);
        }
        return result;
    }

    public Polinomial quotient(Polinomial pol) {
        return this.divide(pol, "Division");
    }

    private Polinomial cleaning() {
        ArrayList<Integer> resultCoef = new ArrayList<>();
        for (int i = 0; i <= this.degree; i++) {
            if (this.coef.get(i) != 0) {
                for (int j = i; j <= this.degree; j++) {
                    resultCoef.add(this.coef.get(j));
                }
                break;
            }
            if (i == this.degree) {
                Polinomial resultZero = new Polinomial(0, "0");
                resultZero.coef.add(0);
                return resultZero;
            }
        }
        Polinomial result = new Polinomial(resultCoef.size() - 1, "");
        for (int i = 0; i <= result.degree; i++) {
            result.coef.set(i, resultCoef.get(i));
        }
        result.function = result.toString();
        return result;
    }

    public Polinomial remainder(Polinomial pol) {
        return this.divide(pol, "Remainder");
    }

    public Polinomial divide(Polinomial pol, String request) {
        if (this.degree < pol.degree) {
            throw new UnsupportedOperationException("Порядок делимого не может быть меньше порядка делителя");
        }
        if (!request.equals("Division") && !request.equals("Remainder")) {
            throw new UnsupportedOperationException("Не верно введен запрос request," +
                    "должен быть либо Division, либо Remainder");
        }
        Polinomial valueOfRemainder = new Polinomial(pol.degree - 1, "");
        Polinomial resultOfDivision = new Polinomial(this.degree - pol.degree, "");
        ArrayList<Double> dividend = new ArrayList<>();
        ArrayList<Double> divisor = new ArrayList<>();
        ArrayList<Double> resultToDouble = new ArrayList<>(this.degree - pol.degree + 1);
        for (int i = 0; i <= this.degree; i++) {
            dividend.add(i, this.coef.get(i).doubleValue());
            if (i <= pol.degree) divisor.add(i, pol.coef.get(i).doubleValue());
        }
        int leadingMember = 0;
        int currentDivisor = 0;
        int counter = pol.degree;
        while (counter <= this.degree) {
            resultToDouble.add(leadingMember, dividend.get(leadingMember) / divisor.get(0));
            for (int i = leadingMember; i <= counter; i++) {
                dividend.set(i, dividend.get(i) -
                        (resultToDouble.get(leadingMember) * divisor.get(currentDivisor)));
                currentDivisor++;
            }
            currentDivisor = 0;
            leadingMember++;
            counter++;
        }
        if (request.equals("Division")) {
            for (int i = 0; i <= resultOfDivision.degree; i++) {
                resultOfDivision.coef.set(i, (int) Math.round(resultToDouble.get(i)));
            }
            resultOfDivision.function = resultOfDivision.toString();
            return resultOfDivision;
        }
        else {
            int currentCoefficientOfRemainder = dividend.size() - 1;
            for (int i = valueOfRemainder.degree; i >= 0; i--) {
                valueOfRemainder.coef.set(i, (int) Math.round(dividend.get(currentCoefficientOfRemainder)));
                currentCoefficientOfRemainder--;
            }
            valueOfRemainder = valueOfRemainder.cleaning();
            valueOfRemainder.function = valueOfRemainder.toString();
            return valueOfRemainder;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.degree; i++) {
            result.append(this.coef.get(i)).append(";");
        }
        result.append(this.coef.get(this.degree));
        return result.toString();
    }

    @Override
    public boolean equals(Object object) {
        Polinomial pol = (Polinomial) object;
        if (object.getClass() != this.getClass() || this.degree != pol.degree) return false;
        double a, b;
        if (this.coef.get(0) == 0 && pol.coef.get(0) == 0) return true;
        if ((this.coef.get(0) % pol.coef.get(0)) == 0) {
            a = this.coef.get(0) / pol.coef.get(0);
        } else return false;
        for (int i = 1; i <= this.degree; i++) {
            if (pol.coef.get(i) != 0) {
                if ((this.coef.get(i) % pol.coef.get(i)) == 0)
                    b = this.coef.get(i) / pol.coef.get(i);
                else return false;
                if (a != b) return false;
            } else {
                if (this.coef.get(i) != 0) return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 11;
        int result;
        result = prime * this.function.hashCode();
        return result;
    }

    public static void main(String[] args) {
    }
}
