package ru.spbstu.kspt.task1;

import java.util.*;

import static ru.spbstu.kspt.task1.Main.timeToString;


public class Table {
    Map<String, String> Table = new LinkedHashMap<>();

    public Table(Map<String, String> map) {
        this.Table = map;
    }

    public Table(){
        this.Table = new LinkedHashMap<>();
    }

    public void addObjToTable(String time, String name) {
        Table.put(time, name);
    }

    public void deleteObjFromTable(String time){
        Table.remove(time);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Table:\n");
        for(String key : Table.keySet()) {
                result.append(timeToString(key)).append(" ").append(Table.get(key)).append("\n");
        }
        result.append("EndTable.\n");
        return result.toString();
    }
}