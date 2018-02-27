package ru.spbstu.kspt.task1;

import java.util.*;

public class Trains {
    List<Train> Trains = new ArrayList<>();

    Trains(ArrayList<Train> trains) {
        Trains = trains;
    }

    Trains() {
        this.Trains = Trains;
    }

    public void addTrain(Train train) {
        Trains.add(train);
    }

    private void deleteTrain(Integer number) {
        Trains.remove(number);
    }

    public Train getTrain(int n) {
        return Trains.get(n);
    }


    public static Trains getTrainsFromFile(String dir, String name) {
        String text = Files.readFile(dir, name);

        String[] textTrains;
        textTrains = text.split("####");

        Trains trains = new Trains();
        for (int i = 0; i < textTrains.length; i++) {
            String[] wordsTrain;
            wordsTrain = textTrains[i].split(" |\n");
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Train train : Trains) {
            result.append(train.toString());
        }
        return result.toString();
    }
}
