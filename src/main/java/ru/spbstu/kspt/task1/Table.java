package main.java.ru.spbstu.kspt.task1;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Main class
 */
public class Table {
    TreeMap<Double, Double> pairMap = new TreeMap<Double, Double>(); // добавить пару
    private ArrayList<Object> difference;

    public void addValue(double x, double y) {
        pairMap.put(x, y);
    }

    public Double funValue(double x) { // вывести для х у
        return pairMap.get(x);
    }

    public void dellValue(double x) { // удалить пару
        pairMap.remove(x);
    }

    public String showTable(){
        StringBuilder res = new StringBuilder();
        for (Map.Entry e:pairMap.entrySet()) {
            res.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
        }
        return res.toString();
    }

    public String findClosestPair(double x0) {// найти ближайшее значени для х0
        double diff = Double.MAX_VALUE;
        double res = 0;
        for (Map.Entry<Double, Double> entry : pairMap.entrySet())
            if (diff > Math.abs(entry.getKey() - x0)) {
                diff = Math.abs(entry.getKey() - x0);
                res = entry.getKey();
            }
        return res + " " + pairMap.get(res);
    }

    private ArrayList<Double> splitDifference() {
        int n = pairMap.size();
        ArrayList<Double> difference = new ArrayList();
        for (Map.Entry<Double, Double> entry : pairMap.entrySet()) {
            difference.add(entry.getValue());
        }
        for (int j = 1; j < n; j++) {
            for (int i = n - 1; i > j - 1; i--) {
                difference.set(i, (difference.get(i) - difference.get(i - 1)) /
                        ((Double) pairMap.values().toArray()[i] - (Double) pairMap.values().toArray()[i - j]));
            }
        }
        return difference;
    }

    public double calculateNewtonPolynomialValue(double x0) {
        ArrayList<Double> difference = this.splitDifference();
        int n = difference.size() - 1;
        double fun = difference.get(n);
        for (int i = n - 1; i > -1; i--) {
            fun = fun * (x0 - (Double) (pairMap.values().toArray()[i])) + difference.get(n);
        }
        return fun;
    }
}