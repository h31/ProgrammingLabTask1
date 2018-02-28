package ru.spbstu.kspt.task1;

import java.util.*;

public class Train {
    private String name;
    private String terminal;
    private Table table;

    Train(String name, String terminal, Table table){
        this.name = name;
        this.terminal = terminal;
        this.table = table;
    }

    Train(){
        this.name = "null";
        this.terminal = "null";
        this.table = new Table();
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

    @Override
    public String toString() {
        return "name= " + name+ ".\n" + "terminal= " + terminal+ "\n" + table;
    }
}
