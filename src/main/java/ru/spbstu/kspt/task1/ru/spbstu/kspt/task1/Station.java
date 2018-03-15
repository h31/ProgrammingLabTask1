package ru.spbstu.kspt.task1;


import java.util.Objects;

public class Station {
    private String name;
    private TimeTable table;

    Station(String name, TimeTable table) {
        this.name = name;
        this.table = table;
    }

    public String getName() {
        return this.name;
    }

    public String getTable() {
        return this.table.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTable(TimeTable table) {
        this.table = table;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name).append(": ").append(table);
        return result.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, table);
    }

    @Override
    public boolean equals(Object object) {
        Station other = (Station) object;
        return (this.getClass() == other.getClass() && (this.name == other.name) && this.table == other.table);
    }
}