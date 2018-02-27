package ru.spbstu.kspt.task1;


import java.io.*;
import java.util.*;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args){



      /*  System.out.println("Введите название поезда");
        Scanner n = new Scanner(System.in);
        String name = n.nextLine();
        System.out.println("Введите название конечной станции");
        Scanner t = new Scanner(System.in);
        String terminal = t.nextLine();
        Table tabl = new Table();

        tabl.addObjToTable(35321,"Купчино");
        tabl.addObjToTable(37654, "Невский проспект");
        tabl.addObjToTable(45332, "Сенная площадь");
        tabl.addObjToTable(54004, "Горьковская");
*/
       /* for (int i = 1; i < 6; i++){
            System.out.println("Введите время и название станции для поезда №" + i);
            Scanner time = new Scanner(System.in);
            Scanner nameStation = new Scanner(System.in);
            tabl.addObjToTable(time.nextInt(), nameStation.nextLine());
        }
*/
        /*Train first = new Train(name, terminal, tabl);
        Trains trains = new Trains();
        trains.addTrain(first);
        trains.addTrain(first);
        trains.addTrain(first);
        */

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
