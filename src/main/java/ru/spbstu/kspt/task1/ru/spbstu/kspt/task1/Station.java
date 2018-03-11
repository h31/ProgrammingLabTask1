package ru.spbstu.kspt.task1;


public class Station{
    private String name;
    private Table table;

    Station(String name, Table table){
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
    public void setTable(Table table){
        this.table = table;
    }
}