package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Класс размерности
 */
public class Dimension {

    Dimension(){

    }

    private Map<String,Double> dimens;
    {
        dimens = new HashMap<>();
    }

    Dimension getLengthDimensions() {
        return new Dimension().addDimension("км",100000).addDimension("м",100).
                addDimension("дм",10).addDimension("см",1);
    }

    Dimension getTimeDimensions() {
        return new Dimension().addDimension("с",1).addDimension("мин",60).
                addDimension("ч",3600);
    }

    Dimension getWeightDimensions() {
        return new Dimension().addDimension("кг",1000000).addDimension("г",1000).
                addDimension("мг",1);
    }

    Dimension addDimension(String name, double coefficient) {
        dimens.put(name, coefficient);
        return this;
    }

    double getValueDimension(String dimension) {
        try {
            return dimens.get(dimension);
        }
        catch (NullPointerException e) {
            throw new NullPointerException("Размерности не совпадают");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dimension dimension = (Dimension) o;

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
