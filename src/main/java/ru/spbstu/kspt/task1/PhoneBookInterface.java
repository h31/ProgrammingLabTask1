package ru.spbstu.kspt.task1;

import java.util.List;

interface PhoneBookInterface {

        void addPerson(String name, List<String> numbers);

        void delPerson(String name);

        void addNumber(String name, String number);

        void delNumber(String name, String number);

        List<String> searchByPerson(String name);

        String searchByNum(String number);
}
