package ru.spbstu.kspt.task1;

import java.util.*;

public class Trains{
    List<Train> Trains = new ArrayList<>();
    Trains(ArrayList<Train> trains){
        Trains = trains;
    }
    Trains(){
        this.Trains = Trains;
    }
    public void addTrain(Train train){
        Trains.add(train);
    }
    private void deleteTrain(Integer number){
        Trains.remove(number);
    }
    public Train getTrain(int n){
        return Trains.get(n);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        for(Train train : Trains){
            result.append(train.toString());
        }
        return result.toString();
    }
}
