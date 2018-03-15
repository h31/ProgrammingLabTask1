package ru.spbstu.kspt.task1;

import java.util.*;

public class Trains {
    List<Train> trains = new ArrayList<>();

    public Trains(ArrayList<Train> trains) {
        this.trains = trains;
    }

    public Trains() {
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public void deleteTrain(int n) {
        try {
            trains.remove(n);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Поезда c номером " + n + " не существует!");
        }
    }

    public Train getTrain(int n) {
        try {
            return trains.get(n);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Поезда под номером " + n + " не существует!");
        }
        return null;
    }

    public int size() {
        return trains.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Train train : trains) {
            result.append(train.toString()).append("\n");
        }
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

    @Override
    public int hashCode(){
        return Objects.hash(trains);
    }

    public Train searchTrain(Integer time, String station) {
        Train last = new Train();
        int division = 60 * 60 * 24;
        for (int i = 0; i < trains.size(); i++) {
            Train train = trains.get(i);
            TimeTable table = train.getTable();
            if (table.haveThis(station)) {

                int seconds = table.get(station);
                if ((seconds - time < division) && (seconds - time > 0)){
                    division = seconds - time;
                    last = train;
                }
            }
        }
        return last;
    }

}
