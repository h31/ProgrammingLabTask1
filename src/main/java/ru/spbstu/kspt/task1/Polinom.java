package ru.spbstu.kspt.task1;
import java.util.ArrayList;


/* Входная фукнция
 *
 *
 *
  * Сравнение на равенство
  * Нахождение функции при известном Х
  * Сложение полиномов
  * Вычитание полиномов
  * Умножение полиномов
  * Деление полиномов
  * Остаток от деления полинома на полином */


public class Polinom {

    private ArrayList<Integer> coef;
    private String function;
    private int x;
    private int order;

    public Polinom(int order, String function) {
        this.order = order;
        this.function = function;
        String[] parts = ";".split(this.function);
        for (int i = this.order; i >= 0; i--) this.coef.add(i, Integer.parseInt(parts[i]));
    }

    public Polinom(int order, String function, int x) {
        this.order = order;
        this.function = function;
        this.x = x;
        String[] parts = ";".split(this.function);
        for (int i = this.order; i >= 0; i--) this.coef.add(i, Integer.parseInt(parts[i]));
    }

    private ArrayList aligment(Polinom pol) {
        if (this.coef.size() > pol.coef.size()) {
            int i = pol.order + 1;
            while (i <= this.order) {
                pol.coef.add(i, 0);
                i++;
            }
            return pol.coef;
        } else {
            int i = this.order + 1;
            while (i <= pol.order) {
                this.coef.add(i, 0);
                i++;
            }
            return this.coef;
        }
    }

    private int maxOrder(Polinom pol) {
        return this.coef.size() > pol.coef.size() ? this.order : pol.order;
    }

    public Polinom plus(Polinom pol) {
        this.aligment(pol);
        int end = this.maxOrder(pol);
        Polinom result = new Polinom(end, "");

        for (int i = 0; i < end; i++) {
            result.coef.add(i, (this.coef.get(i) + pol.coef.get(i)));
        }
        result.function = result.toString();
        return result;
    }

    public Polinom minus(Polinom pol) {
        this.aligment(pol);
        int end = this.maxOrder(pol);
        Polinom result = new Polinom(end, "");

        for (int i = 0; i < end; i++) {
            result.coef.add(i, (this.coef.get(i) - pol.coef.get(i)));
        }
        result.function = result.toString();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = this.order; i >= 0; i--) {
            if (i != 0) {
                result.append(this.coef.get(i)).append(";");
            } else {
                result.append(this.coef.get(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
    }
}
