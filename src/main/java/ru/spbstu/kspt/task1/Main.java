package ru.spbstu.kspt.task1;


import sun.tools.jconsole.Tab;

import java.util.*;

/**
 * Main class
 */
public class Main {

    public static class Train {
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
            return name + terminal + table.toString();
        }
    }

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
    }

    public static class Trains{
        List<Train> Trains = new ArrayList<>();
        public Trains(ArrayList<Train> trains){
            Trains = trains;
        }

        private void addTrain(Train train){
            Trains.add(train);
        }
        private void deleteTrain(Integer number){
            Trains.remove(number);
        }

    }

    public static class Table {
        private Map<Integer, String> Table = new HashMap<>();

        public Table(Map<Integer, String> map) {
            this.Table = map;
        }

        public void addObjToTable(Integer time, String name) {
            Table.put(time, name);
        }

        public void deleteObjFromTable(Integer time){
            Table.remove(time);
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for(Integer key : Table.keySet()) {
                if (Table.get(key) != null ) {
                    result.append(timeToString(key)).append(" ").append(Table.get(key)).append("\n");
                }
            }
            return result.toString();
        }
    }

    private static String timeToString(int seconds) {
        return seconds / 3600 + ":" + seconds % 3600 / 60 + ":" + seconds % 216000;
    }
}
