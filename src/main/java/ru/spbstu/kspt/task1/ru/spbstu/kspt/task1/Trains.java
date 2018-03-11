package ru.spbstu.kspt.task1;

import java.util.*;

public class Trains {
    List<Train> Trains = new ArrayList<>();

    public Trains(ArrayList<Train> trains) {
        Trains = trains;
    }

    public Trains(List<Train> list) {
        this.Trains = list;
    }

    public Trains() {
    }

    public void addTrain(Train train) {
        Trains.add(train);
    }

    public void deleteTrain(int n) {
        try {
            Trains.remove(n);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Поезда c номером " + n + " не существует!");
        }
    }

    public Train getTrain(int n) {
        try {
            return Trains.get(n);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Поезда под номером " + n + " не существует!");
        }
        return null;
    }

    public int size() {
        return Trains.size();
    }

    /* public static Trains getTrainFromConsole(String text){

        String[] textTrains;
        textTrains = text.split("####");

        Trains trains = new Trains();
        for (int i = 0; i < textTrains.length; i++) {
            String[] wordsTrain;
            wordsTrain = textTrains[i].split("[ \n]");
            Train train = new Train();
            for (int k = 0; k < wordsTrain.length; k++) {
                if (wordsTrain[k].equals("name=")) {
                    train.setName(wordsTrain[k + 1]);
                    continue;
                }
                if (wordsTrain[k].equals("terminal=")) {
                    train.setTerminal(wordsTrain[k + 1]);
                    continue;
                }

                if (wordsTrain[k].equals("Table:")) {
                    Table table = new Table();
                    k++;
                    while (!wordsTrain[k].equals("EndTable.")) {
                        table.addObjToTable(wordsTrain[k], wordsTrain[k + 1]);
                        k += 2;
                    }
                    train.setTable(table);
                    break;
                }
            }
            trains.addTrain(train);
        }
        return trains;
    }

    public static Trains addTrainFromConsole(){
        Scanner in = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        while (!in.next().equals("end!")){
            result.append(in.next());
        }
        Trains trains = getTrainFromConsole(result.toString());
        return trains;
    }
    public static Trains getTrainsFromFile(String dir, String name) {
        String text = Files.readFile(dir, name);

        String[] textTrains;
        textTrains = text.split("####");

        Trains trains = new Trains();
        for (int i = 0; i < textTrains.length; i++) {
            String[] wordsTrain;
            wordsTrain = textTrains[i].split("[ \n]");
            Train train = new Train();
            for (int k = 0; k < wordsTrain.length; k++) {
                if (wordsTrain[k].equals("name=")) {
                    train.setName(wordsTrain[k + 1]);
                    continue;
                }
                if (wordsTrain[k].equals("terminal=")) {
                    train.setTerminal(wordsTrain[k + 1]);
                    continue;
                }

                if (wordsTrain[k].equals("Table:")) {
                    Table table = new Table();
                    k++;
                    while (!wordsTrain[k].equals("EndTable.")) {
                        table.addObjToTable(wordsTrain[k], wordsTrain[k + 1]);
                        k += 2;
                    }
                    train.setTable(table);
                    break;
                }
            }
            trains.addTrain(train);
        }
        return trains;
    }

    public static void addTrainsToFile(String dir, String name, Trains trains) {
        String trainsString = trains.toString();

        Files.writeFile(dir, name, trainsString);
    }

    public static String stringsToString(String[] textSplitted) {
        StringBuilder result = new StringBuilder();

        for (String str : textSplitted) {
            result.append(str).append(" ");
        }
        return result.toString();
    }
*/
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Train train : Trains) {
            result.append(train.toString()).append("####\n");
        }
        int length = result.length();
        result.delete(length - 6, length);
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Trains trains = (Trains) obj;

        if (this == trains) return true;
        if (this.size() != trains.size() && this.getClass() != trains.getClass()) return false;

        for (int i = 0; i < this.size(); i++) {
            if (trains.getTrain(i) != this.getTrain(i)) return false;
        }
        return true;
    }

    public Train searchTrain(String time, String station) {
        Train last = new Train();
        for (int i = 0; i < Trains.size() - 1; i++) {
            int division = 86400;
            Train train = Trains.get(i);
            Table table = train.getTable();
            if (table.haveThis(station)) {
                int seconds = Integer.parseInt(table.get(station));
                if (seconds - Integer.parseInt(time) < division) {
                    division = seconds - Integer.parseInt(time);
                    last = train;
                }
            }
        }
        return last;
    }
}
