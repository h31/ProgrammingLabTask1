package ru.spbstu.kspt.task1;
import java.util.ArrayList;

public class Polinom {

    private ArrayList<Integer> coef;
    private String function;
    private int x;
    private int order;

    public Polinom(int order, String function) {
        this.coef = new ArrayList<>();
        this.order = order;
        this.function = function;
        if (!this.function.equals("")) {
            String[] parts = this.function.split(";");
            for (int i = 0; i < parts.length; i++) {
                if (!parts[i].isEmpty())
                    this.coef.add(Integer.parseInt(parts[i]));
            }
        }
        else {
            for (int i = 0; i <= this.order; i++){
                this.coef.add(0);
            }
        }
    }

    private Polinom min(Polinom pol) {
        String minFunction = (this.order < pol.order) ? this.function : pol.function;
        return new Polinom(Math.min(this.order, pol.order), minFunction);
    }

    private Polinom aligment(Polinom pol) {
        Polinom result = this.min(pol);
        for (int i = 0; i < Math.abs(this.order - pol.order); i++) {
            result.coef.add(i, 0);
        }
        result.function = result.toString();
        return result;
    }

    public Polinom plus(Polinom pol) {
        Polinom maxPol = (this.order < pol.order) ? pol : this;
        Polinom minPol = this.aligment(pol);
        int end = maxPol.order;
        Polinom result = new Polinom(end, "");
        for (int i = 0; i <= end; i++) {
            result.coef.set(i, (maxPol.coef.get(i) + minPol.coef.get(i)));
        }
        result.function = result.toString();
        return result;
    }

    public Polinom minus(Polinom pol) {
        Polinom minuend, subtrahend;
        if (this.order > pol.order) {
            minuend = this;
            subtrahend = this.aligment(pol);
        } else {
            minuend = this.aligment(pol);
            subtrahend = pol;
        }
        int end = Math.max(this.order, pol.order);
        Polinom result = new Polinom(end, "");
        for (int i = 0; i <= end; i++) {
            result.coef.set(i, (minuend.coef.get(i) - subtrahend.coef.get(i)));
        }
        result.function = result.toString();
        return result;
    }

    public Polinom multiplication(Polinom pol) {
        int k;
        Polinom result = new Polinom(this.order + pol.order, "");
        for (int i = this.order; i >= 0; i--) {
            k = i + pol.order;
            for (int j = pol.order; j >= 0; j--) {
                result.coef.set(k, (this.coef.get(i) * pol.coef.get(j)) + result.coef.get(k));
                k--;
            }
        }
        result.function = result.toString();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.order; i++) {
            result.append(this.coef.get(i)).append(";");
        }
        result.append(this.coef.get(this.order));
        return result.toString();
    }

    @Override
    public boolean equals(Object object) {
        Polinom pol = (Polinom) object;
        if (object.getClass() != this.getClass() || this.order != pol.order) return false;
        int a, b;
        Polinom maxPol, minPol;
        if (this.coef.get(0) > pol.coef.get(0)) {
            maxPol = this;
            minPol = pol;
        } else {
            maxPol = pol;
            minPol = this;
        }
        if ((maxPol.coef.get(0) % minPol.coef.get(0)) == 0) {
            a = maxPol.coef.get(0) / minPol.coef.get(0);
        } else return false;
        for (int i = 1; i <= 4; i++) {
            if ((maxPol.coef.get(i) % minPol.coef.get(i)) == 0)
                b = maxPol.coef.get(i) / minPol.coef.get(i);
            else return false;
            if (a != b) return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
