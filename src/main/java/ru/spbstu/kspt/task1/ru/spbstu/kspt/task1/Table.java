package ru.spbstu.kspt.task1;

import java.util.*;

import static ru.spbstu.kspt.task1.Main.timeToString;


public class Table {
    Map<String, String> Table = new LinkedHashMap<>();

    public Table(LinkedHashMap<String, String> map) {
        this.Table = map;
    }

    public Table() {
    }

    public int size(){
        return Table.size();
    }

    public boolean haveThis(String key){
        return Table.containsKey(key);
    }
    public String get(String key){
        return Table.get(key);
    }

    public void addObjToTable(String name, String time) {
        Table.put(name, time);
    }

    public void deleteObjFromTable(String time) {
        Table.remove(time);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Table:\n");
        for (String key : Table.keySet()) {
            result.append(timeToString(Table.get(key))).append(" ").append(key).append("\n");
        }
        result.append("EndTable.\n");
        return result.toString();
    }

    @Override
    public boolean equals(Object obj){
        Table table = (Table) obj;

        if (table == this) return true;

        if (table.size() != this.size()) return false;

        for (String key : this.Table.keySet()){
            if (table.get(key) != this.get(key)) return false;
        }

        return true;
    }
}