package ru.spbstu.kspt.task1;

import java.util.ArrayList;

interface MainInterface {

        void addPerson(String name, String[] numbers);

        void delPerson(String name);

        void addNumber(String name, String number);

        void delNumber(String name, String number);

        ArrayList<String> searchByPerson(String name);

        String searchByNum(String number);
}
