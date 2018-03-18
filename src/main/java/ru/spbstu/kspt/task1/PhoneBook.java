package ru.spbstu.kspt.task1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PhoneBook implements PhoneBookInterface {
    Map<String, ArrayList<String>> book = new HashMap<>();

    private static Pattern p = Pattern.compile("[\\d*#\\-+]+");
    
    private boolean checkNum(String number) {
        Matcher m = p.matcher(number);
        return m.matches();
    }

    public void addPerson(String name, List<String> numbers) {
        for (String i : numbers) {
            if (!checkNum(i)) throw new IllegalArgumentException("Wrong format"); 
        }
        ArrayList<String> list = new ArrayList<>();
        list.addAll(numbers);
        book.put(name, list);
    }

    public void delPerson(String name) {
        if (!book.containsKey(name)) throw new IllegalArgumentException("invalid person");
        book.remove(name);
    }

    public void addNumber(String name, String number) {
        if (!book.containsKey(name))
            throw new IllegalArgumentException("invalid person");
        if (checkNum(number))
            book.get(name).add(number);
        else throw new IllegalArgumentException("Wrong format");
    }

    public void delNumber(String name, String number) {
        if (!book.containsKey(name)) throw new IllegalArgumentException("invalid person");
        if (book.get(name).isEmpty()) throw new IllegalArgumentException("empty list");
        if (!book.get(name).contains(number)) throw new IllegalArgumentException("invalid number");
        book.get(name).remove(number);
    }

    public List<String> searchByPerson(String name) {
        if (book.containsKey(name)) return book.get(name);
        else throw new IllegalArgumentException("invalid person");
    }

    public String searchByNum(String number) {
        if (!checkNum(number)) throw new IllegalArgumentException("Wrong format");
        for (String name : book.keySet()) {
            for (String num : book.get(name)) {
                if (number.equals(num)) return name;
            }
        }
        throw new IllegalArgumentException("invalid number"); 
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneBook main = (PhoneBook) o;

        return book != null ? book.equals(main.book) : main.book == null;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "book=" + book +
                '}';
    }

    @Override
    public int hashCode() {
        return book != null ? book.hashCode() : 0;
    }
}

