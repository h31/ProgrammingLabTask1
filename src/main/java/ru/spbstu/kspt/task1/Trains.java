package ru.spbstu.kspt.task1;

import java.util.*;

public class Trains{
    List<ru.spbstu.kspt.task1.Train> Trains = new ArrayList<>();
    Trains(ArrayList<ru.spbstu.kspt.task1.Train> trains){
        Trains = trains;
    }

    private void addTrain(ru.spbstu.kspt.task1.Train train){
        Trains.add(train);
    }
    private void deleteTrain(Integer number){
        Trains.remove(number);
    }
}
