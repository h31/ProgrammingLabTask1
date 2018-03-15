package ru.spbstu.kspt.task1;

import java.util.List;

interface PhoneBookInterface {

        void addPerson(String name, String[] numbers);

        void delPerson(String name);

        void addNumber(String name, String number);

        void delNumber(String name, String number);

        ArrayList<String> searchByPerson(String name);

        String searchByNum(String number);
}
