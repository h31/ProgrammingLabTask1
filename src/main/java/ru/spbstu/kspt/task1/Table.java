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

    private Double[] diff() {
        int n = pairMap.size();
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++)
            a[i] = (Double) pairMap.values().toArray()[i];
        for (int j = 1; j < n; j++)
            for (int i = n - 1; i > j - 1; i--)
                    a[i] = (a[i] - a[i - 1])
                            /((Double)pairMap.keySet().toArray()[i] - (Double)pairMap.keySet().toArray()[i - j]);
        return a;
    }

    public Double calculateNewtonPolynom(double x0) {
        Double[] a = diff();
        int n = a.length - 1;
        Double temp = a[n];
        for (int i = n - 1; i > -1;  i--)
            temp = temp * (x0 - (Double) pairMap.keySet().toArray()[i]) + a[i];
        return temp;
    }
}