package ru.spbstu.kspt.task1;

import java.util.*;

public class Train {
    private String name;
    private String terminal;
    private TimeTable table;

    public Train(String name, String terminal, TimeTable table){
        this.name = name;
        this.terminal = terminal;
        this.table = table;
    }

    public Train(){
    }

    public void setName(String name) {this.name = name;}
    public void setTerminal(String terminal) {this.terminal = terminal;}
    public void setTable(TimeTable table) {this.table = table;}

    public String getName() {
        return this.name;
    }

    public String getTerminal() {
        return this.terminal;
    }

    public TimeTable getTable(){
        return this.table;
    }
    @Override
    public String toString() {
        return "name= " + name+ ". " + "terminal= " + terminal+ " " + table;
    }

    @Override
    public boolean equals(Object obj){
        Train train = (Train) obj;

        if ((train.name != this.name) || (train.terminal != this.terminal) || (train.table != this.table)) return false;

        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, terminal, table);
    }
}
