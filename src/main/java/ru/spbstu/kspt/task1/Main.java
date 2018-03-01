package ru.spbstu.kspt.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    Map<String, ArrayList<String>> book = new HashMap<>();

    private static boolean checkNum(String numFormat) {
        Pattern p = Pattern.compile("[\\d*#()\\-+]+");
        Matcher m = p.matcher(numFormat);
        return m.matches();
    }

    void addPerson(String name, String[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(numbers));
        for (String i : list){
            if (!checkNum(i)) throw new IllegalArgumentException("Wrong format");
        }
        book.put(name, list);
    }

    void delPerson(String name) {
        if (!book.containsKey(name)) throw new IllegalArgumentException("invalid Person");
        book.remove(name);
    }

    void addNumber(String name, String number) {
        if (!book.containsKey(name)) throw new IllegalArgumentException("invalid Person");
        if (checkNum(number))
            book.get(name).add(number);
        else throw new IllegalArgumentException("Wrong format");
    }
}

