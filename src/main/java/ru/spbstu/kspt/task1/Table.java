package ru.spbstu.kspt.task1;

import java.util.ArrayList;

/**
 * Main class
 */
public class Table {
    static class Pair{
        public int x;
        public int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int dif(int x0){
            return Math.abs(x0 - x);
        }
    }
    ArrayList<Pair> wr = new ArrayList<Pair>();
    public void AddAPair() { // Проверка на одинаковые точки выдать ошибку
        wr.add(new Pair(1,2));
    }
    public void DeletPair(int x, int y){
        wr.remove(new Pair(x, y));
    }
    public void ShowTable() {
        for (Pair p:wr
             ) {
            System.out.println(p.x + " " + p.y);
        }
    }
    public void PairSearh(int x0) {
        Pair res = null;
        int min = Integer.MAX_VALUE;
        for (Pair i:wr
             ) {
            if (i.dif(x0) <= min){
                min = i.dif(x0);
                res = i;
            }
        }
        System.out.println(res.x + " " + res.y);

    }

}
