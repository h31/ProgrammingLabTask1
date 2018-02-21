package ru.spbstu.kspt.task1;
import java.util.ArrayList;
import java.util.List;

public class Polinom {

    private ArrayList<Integer> coef;
    private String function;
    private int x;
    private int order;

    public Polinom(int order, String function) {
        this.coef = coef;
        this.order = order;
        this.function = function;
        String[] parts = this.function.split(";");
        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].isEmpty())
            this.coef.add( Integer.parseInt(parts[i]));
        }
    }

    private Polinom min(Polinom pol) {
        String minFunction = (this.order < pol.order) ? this.function : pol.function;
        return new Polinom(Math.min(this.order, pol.order), minFunction);
    }

    private Polinom equ(Polinom pol) {
        Polinom result = this.min(pol);
        int difference = Math.abs(this.order - pol.order);
        for (int i = 0; i < difference; i++) {
            result.coef.add(i, 0);
        }
        result.order = result.coef.size() - 1;
        result.function = result.toString();
        return result;
    }

    public Polinom plus(Polinom pol) {
        Polinom maxPol = (this.order < pol.order) ? pol : this;
        Polinom minPol = this.equ(pol);
        int end = maxPol.order;
        Polinom result = new Polinom(end, "");
        for (int i = 0; i <= end; i++) {
            result.coef.add(i, (maxPol.coef.get(i) + minPol.coef.get(i)));
        }
        result.function = result.toString();
        System.out.println(result);
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

    public static void main(String[] args) {
    }
}
