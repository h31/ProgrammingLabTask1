package ru.spbstu.kspt.task1;

import java.util.ArrayList;

/**
 * Main class
 */
public class Table {
    public void addAPair(double x, double y) {
        if (!isExist(x))
            wr.add(new Pair(x, y));
        else
            throw new IllegalArgumentException();
    }
    ArrayList<Pair> wr = new ArrayList<Pair>();

    public void addPair(double x) {
        if (!isExist(x)) {
            double y = polynomNewton(x);
            wr.add(new Pair(x, y));
        } else
            throw new IllegalArgumentException();
    }

    public Pair search(double x, double y) {
        for (Pair p : wr)
            if (Math.abs(p.x - x) < 1e-5 && Math.abs(p.y - y) < 1e-5)
                return p;
        return null;
    }

    public void deletPair(double x, double y) {
        Pair tmp = search(x, y);
        if (tmp != null)
            wr.remove(tmp);
        else
            throw new IllegalArgumentException();
    }

    public String showTable() {
        String res = "";
        for (Pair p : wr) {
            res += (p.x + " " + p.y + "\n");
        }
        return res;
    }

    public void pairSearhByX(double x0) {
        Pair res = null;
        double min = Double.MAX_VALUE;
        for (Pair i : wr
                ) {
            if (i.dif(x0) <= min) {
                min = i.dif(x0);
                res = i;
            }
        }
        System.out.println(res.x + " " + res.y);
    }

    private boolean isExist(double x) {
        for (Pair p : wr) {
            if (Math.abs(p.x - x) < 1e-5) return true;
        }
        return false;
    }

    public double polynomNewton(double x) {
        int n = wr.size();
        double[][] difference = splitDifference();
        double xCoeff = 1;
        double y = difference[0][1];
        for (int i = 0; i <= n; i++) {
            xCoeff = xCoeff * (x - wr.get(i).x);
            y = y + xCoeff * difference[0][i + 2];
        }
        return y;
    }

    private double[][] splitDifference() {
        int n = wr.size();
        double[][] difference = new double[n][];
        for (int i = 0; i <= n; i++) {
            difference[0] = new double[n - 1];
            difference[i][0] = wr.get(0).x;
            difference[i][1] = wr.get(0).y;
        }
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 0; j <= n - 1; i++) {
                double xDiff = difference[j + i][0] - difference[j][0];
                double yDiff = difference[j + 1][i] - difference[j][i];
                difference[j][i] = yDiff / xDiff;
            }
        }
        return difference;
    }

    static class Pair {
        public double x;
        public double y;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double dif(double x0) {
            return Math.abs(x0 - x);
        }
    }
}
