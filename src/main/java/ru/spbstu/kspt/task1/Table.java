package ru.spbstu.kspt.task1;

import java.util.*;

import static ru.spbstu.kspt.task1.Main.timeToString;


public class Table {
    private Map<Integer, String> Table = new HashMap<>();

    private Table(Map<Integer, String> map) {
        this.Table = map;
    }

    public void addObjToTable(Integer time, String name) {
        Table.put(time, name);
    }

    public void deleteObjFromTable(Integer time){
        Table.remove(time);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Integer key : Table.keySet()) {
            if (Table.get(key) != null ) {
                result.append(timeToString(key)).append(" ").append(Table.get(key)).append("\n");
            }
        }
        return result.toString();
    }
}