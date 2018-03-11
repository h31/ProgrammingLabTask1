package ru.spbstu.kspt.task1;

import java.util.*;

public class Train {
    private String name;
    private String terminal;
    private Table table;

    public Train(String name, String terminal, Table table){
        this.name = name;
        this.terminal = terminal;
        this.table = table;
    }

    public Train(){
    }

    public void setName(String name) {this.name = name;}
    public void setTerminal(String terminal) {this.terminal = terminal;}
    public void setTable(Table table) {this.table = table;}

    public String getName() {
        return this.name;
    }

    public String getTerminal() {
        return this.terminal;
    }

    public Table getTable(){
        return this.table;
    }
    @Override
    public String toString() {
        return "name= " + name+ ".\n" + "terminal= " + terminal+ "\n" + table;
    }

    @Override
    public boolean equals(Object obj){
        Train train = (Train) obj;
        if (train == obj) return true;

        if ((train.name != this.name) || (train.terminal != this.terminal) || (train.table != this.table)) return false;

        return true;
    }
}
