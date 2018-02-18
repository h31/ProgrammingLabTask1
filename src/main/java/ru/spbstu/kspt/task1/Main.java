package ru.spbstu.kspt.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main class
 */
public class Main {

    public static class Address {
        private String street;
        private int house;
        private int flat;

        Address(String street, int house, int flat) {
            this.street = street;
            this.house = house;
            this.flat = flat;
        }

        @Override
        public String toString() {
            return street + " " + house + " " + flat;
        }
    }

    public static class Person {
        private String name;

        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class addressBook {
        private static Map<Person, Address> addressBook = new HashMap<>();

        public addressBook(Map<Person, Address> myMap) {
            this.addressBook = myMap;
        }

        public void addAddressBook(Person person, Address address) {
            addressBook.put(person, address);
        }

        public void removeAddressBook(Person person) {
            addressBook.remove(person);
        }

        public void changeAddress(Person person, Address address) {
            if (addressBook.containsKey(person)) {
                addressBook.replace(person, address);
            }
        }

        public Address getAddress(Person person) throws IllegalAccessException {
            if (addressBook.containsKey(person)) {
                return addressBook.get(person);
            } else throw new IllegalAccessException();
        }

        public void findOnStreet(String street) {
            List<Person> listOfPerson = new ArrayList<>();
            for (Person person : addressBook.keySet()) {
                if (addressBook.get(person).street == street) {
                    listOfPerson.add(person);
                }
            }
        }

        public void findOnHouse(Integer house) {
            List<Person> listOfPerson = new ArrayList<>();
            for (Person person : addressBook.keySet()) {
                if (addressBook.get(person).house == house) {
                    listOfPerson.add(person);
                }
            }
        }

        public Map<Person, Address> getAddressBook() {
            return addressBook;
        }

        @Override
        public String toString() {
            StringBuilder anwser = new StringBuilder();
            for (Person key : addressBook.keySet()) {
                anwser.append(addressBook.get(key)).append("\n");
            }
            return anwser.toString();
        }
    }
}


