package ru.spbstu.kspt.task1;

import java.util.*;

public class Train {
    private String name;
    private String terminal;
    private Table table;

    Train(String name, String terminal){
        this.name = name;
        this.terminal = terminal;
    }


    public String getName() {
        return this.name;
    }

    public String getTerminal() {
        return this.terminal;
    }

    @Override
    public String toString() {
        return name + " " + terminal;
    }
}
