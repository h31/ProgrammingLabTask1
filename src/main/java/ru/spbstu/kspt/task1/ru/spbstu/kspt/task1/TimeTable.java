package ru.spbstu.kspt.task1;

import java.util.*;
import static ru.spbstu.kspt.task1.Statics.timeToString;


public class TimeTable {
    Map<String, Integer> timeTable = new LinkedHashMap<>();

    public TimeTable(LinkedHashMap<String, Integer> map) {
        this.timeTable = map;
    }

    public TimeTable() {
    }

    public int size(){
        return timeTable.size();
    }

    public boolean haveThis(String key){
        return timeTable.containsKey(key);
    }
    public int get(String key){
        return timeTable.get(key);
    }

    public void addStringToTable(String name, Integer time) {
        timeTable.put(name, time);
    }

    public void deleteStringFromTable(String name) {
        timeTable.remove(name);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : timeTable.entrySet()) {
            result.append(timeToString(entry.getValue())).append(" ").append(entry.getKey()).append("; ");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object obj){
        TimeTable table = (TimeTable) obj;

        if (table == this) return true;

        if (table.size() != this.size()) return false;

        for (String key : this.timeTable.keySet()){
            if (table.get(key) != this.get(key)) return false;
        }

        return true;
    }
}