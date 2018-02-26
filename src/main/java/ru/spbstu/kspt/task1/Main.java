package ru.spbstu.kspt.task1;


import java.util.*;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Введите название поезда");
        Scanner n = new Scanner(System.in);
        String name = n.nextLine();
        System.out.println("Введите название конечной станции");
        Scanner t = new Scanner(System.in);
        String terminal = t.nextLine();

        Train first = new Train(name, terminal);
        System.out.println(first);
    }

    static String timeToString(int seconds) {
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
