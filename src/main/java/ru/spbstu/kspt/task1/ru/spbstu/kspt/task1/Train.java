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


    public String getName() {
        return this.name;
    }

    public String getTerminal() {
        return this.terminal;
    }

    @Override
    public String toString() {
        return "Поезд: " + name+ ".\n" + "Конечная станция: " + terminal+ "\n" + "Расписание: \n" + table;
    }
}
