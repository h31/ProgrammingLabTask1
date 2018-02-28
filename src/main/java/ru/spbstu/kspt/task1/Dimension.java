package ru.spbstu.kspt.task1;


import jdk.nashorn.internal.codegen.MapCreator;

import java.util.*;

/**
 * Класс размерности
 * equalsDim - сравнение на принадлежность к одному классу
 * power - вывод вещественного числа
 */
public class Dimension {

    private String dim;

    Dimension(){
        dim = "м";
    }

    Dimension(String dim) {
        this.dim = dim;
    }

    private static final Map<String,Double> metrs;
    static {
        metrs = new HashMap<>();
        metrs.put("см",1.0);
        metrs.put("дм",10.0);
        metrs.put("м",100.0);
        metrs.put("км",1000.0);
    }

    private static final Map<String,Double> time;
    static {
        time = new HashMap<>();
        time.put("с",1.0);
        time.put("мин",60.0);
        time.put("ч",3600.0);
    }

    private static final Map<String,Double> gramms;
    static {
        gramms = new HashMap<>();
        gramms.put("мг",1.0);
        gramms.put("г",1000.0);
        gramms.put("кг",1000000.0);
    }

    private static final Map<Integer,Map<String,Double>> dimens;
    static {
        dimens = new HashMap<>();
        dimens.put(1,metrs);
        dimens.put(2,time);
        dimens.put(3,gramms);
    }

    String getDim() {
        return dim;
    }

    boolean equalsDim (Dimension other) {
        for (int i = 1; i <= dimens.size(); i++) {
            if (dimens.get(i).containsKey(dim) && dimens.get(i).containsKey(other.dim)){
                return true;
            }
        }
        return false;
    }

    double power () {
        for (int i = 1; i <= dimens.size(); i++) {
            if (dimens.get(i).containsKey(dim)) {
                return dimens.get(i).get(dim);
            }
        }
        throw new IllegalArgumentException("Неверная размерность");
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Dimension) {
            Dimension other = (Dimension) obj;
            return dim.equals(other.dim);
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + dim;
    }



}
