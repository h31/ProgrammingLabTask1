package ru.spbstu.kspt.task1;


import java.io.*;
import java.util.*;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args){
        String dir = "/Users/Ferrero/IdeaProjects3/ProgrammingLabTask1/src/main/resources/trains/";
        String name = "trains.txt";
        String newName = "trains2.txt";

        Trains tr = Trains.getTrainsFromFile(dir, name);
        Trains.addTrainsToFile(dir, newName, tr);
    }

    static String timeToString(String secs) {
        int seconds = Integer.parseInt(secs);
        if (seconds > 86399) { throw new IllegalArgumentException("Некорректно введенное время!");}
        StringBuilder result = new StringBuilder();
        int hour = seconds / 3600;
        int minutes = seconds % 3600 / 60;
        int sec = seconds - hour * 3600 - minutes * 60;

        if (hour < 10) {
            result.append(0).append(hour).append(":");
        }
        else {
            result.append(hour).append(":");
        }

        if (minutes < 10){
            result.append(0).append(minutes).append(":");
        }
        else {
            result.append(minutes).append(":");
        }

        if (sec < 10){
            result.append(0).append(sec);
        }
        else {
            result.append(sec);
        }
        return result.toString();
    }

}
