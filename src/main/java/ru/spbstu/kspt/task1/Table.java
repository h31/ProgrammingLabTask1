package main.java.ru.spbstu.kspt.task1;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Main class
 */
public class Table {

    TreeMap<Double, Double> pairMap = new TreeMap<Double, Double>();
    private ArrayList<Object> difference;

    @Override
    public int hashCode() {

        return Objects.hash(pairMap, difference);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equals(pairMap, table.pairMap) &&
                Objects.equals(difference, table.difference);
    }

    public static class Pair {
        public double x;
        public double y;

        public Pair(TreeMap<Double,Double> pairMap, int i) {
            this.x = (double) pairMap.keySet().toArray()[i];
            this.y = (double) pairMap.values().toArray()[i];
        }

        public Pair(double x, double y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Double.compare(pair.x, x) == 0 &&
                    Double.compare(pair.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public void addValue(double x, double y) {// добавить пару
        if(pairMap.containsKey(x)) throw new IllegalArgumentException();
        pairMap.put(x, y);
    }



    public Double funValue(double x) { // вывести для х у
        return pairMap.get(x);
    }

    public void delValue(double x) { // удалить пару
        pairMap.remove(x);
    }

    public String showTable(){
        StringBuilder res = new StringBuilder();
        for (Map.Entry e:pairMap.entrySet()) {
            res.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
        }
        return res.toString();
    }
    public Pair findClosestPair(double x0) {// найти ближайшее значени для х0
        int low = 0;
        int up = pairMap.size();
        int comp = -1;
        double diff = pairMap.lastEntry().getValue();
        int res = -1;
        while (low != up){
            comp = (low + up) / 2;
            if(diff > (x0 - (double) pairMap.keySet().toArray()[comp])){
                diff = x0 - (double) pairMap.keySet().toArray()[comp];
                res = comp;
            }
            if(diff < 0.01)
                return new Pair(pairMap, res);
            else if (Double.compare((double)pairMap.keySet().toArray()[comp], x0) < 0)
                up = comp;
            else
                low = ++comp;
        }
        return new Pair(pairMap, res);
    }

    private double[] diff() {
        int n = pairMap.size();
        double[] diff = new double[n];
        for (int i = 0; i < n; i++)
            diff[i] = (double) pairMap.values().toArray()[i];
        for (int j = 1; j < n; j++)
            for (int i = n - 1; i > j - 1; i--)
                    diff[i] = (diff[i] - diff[i - 1])
                            /((double)pairMap.keySet().toArray()[i] - (double)pairMap.keySet().toArray()[i - j]);
        return diff;
    }

    public double calculateNewtonPolynom(double x0) {
        double[] a = diff();
        int n = a.length - 1;
        double temp = a[n];
        for (int i = n - 1; i > -1;  i--)
            temp = temp * (x0 - (double) pairMap.keySet().toArray()[i]) + a[i];
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(Map.Entry e : pairMap.entrySet()){
            res.append("x: ").append(e.getKey()).append(" y: ").append(e.getValue()).append("\n");
        }
        return res.toString();
    }

}