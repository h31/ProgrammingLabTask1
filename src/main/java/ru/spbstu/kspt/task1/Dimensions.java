package ru.spbstu.kspt.task1;

import java.util.*;

/**
 * Класс размерности
 */
public class Dimensions {

    Dimensions(){

    }

    private Map<String,Double> dimens = new HashMap<>();

    static Dimensions getLengthDimensions() {
        return new Dimensions().addDimension("км",100000).addDimension("м",100).
                addDimension("дм",10).addDimension("см",1);
    }

    static Dimensions getTimeDimensions() {
        return new Dimensions().addDimension("с",1).addDimension("мин",60).
                addDimension("ч",3600);
    }

    static Dimensions getWeightDimensions() {
        return new Dimensions().addDimension("кг",1000000).addDimension("г",1000).
                addDimension("мг",1);
    }

    Dimensions addDimension(String name, double coefficient) {
        dimens.put(name, coefficient);
        return this;
    }

    double getDimensionValue(String dimension) {
        if (!dimens.containsKey(dimension)) {
            throw new IllegalArgumentException("Данная разменость не содержится в данном Map");
        }
        return dimens.get(dimension);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dimensions dimension = (Dimensions) o;

        return dimens != null ? dimens.equals(dimension.dimens) : dimension.dimens == null;
    }

    @Override
    public int hashCode() {
        return dimens != null ? dimens.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Dimension{" + dimens + '}';
    }
}
