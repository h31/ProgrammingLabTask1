package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    private static AddressBook createAddressBook() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPersonWithAddress(new Person("Дженжер"),
                new Address("Пролетарская", 360, 308));
        addressBook.addPersonWithAddress(new Person("Новикова"),
                new Address("Ноябрьская", 47, 69));
        addressBook.addPersonWithAddress(new Person("Земская"),
                new Address("Ноябрьская", 47, 60));
        addressBook.addPersonWithAddress(new Person("Полухин"),
                new Address("Ноябрьская", 40, 52));
        addressBook.addPersonWithAddress(new Person("Багаутдинов"),
                new Address("Новая", 8, 367));
        return addressBook;
    }

    @Test
    void addPersonWithAddress() {
        AddressBook addressBook = createAddressBook();
        try {
            addressBook.addPersonWithAddress(new Person("Долгих"),
                    new Address("Советская", 8, 9));
            addressBook.addPersonWithAddress(new Person("Кубасова"),
                    new Address("Ноябрьская", 47, 741));
            assertEquals(7, addressBook.getAddressBook().size());
            addressBook.addPersonWithAddress(new Person("Полухин"),
                    new Address("наб.Фонтанки", 56, 8));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            addressBook.addPersonWithAddress(new Person("Виноградный"),
                    new Address("наб.Фонтанки", -8, 359));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            addressBook.addPersonWithAddress(new Person("Шадрин"), new Address("", 56, 18));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Test
    void removePerson() {
        AddressBook addressBook = createAddressBook();
        try {
            addressBook.removePerson(new Person("Багаутдинов"));
            assertEquals(4, addressBook.getAddressBook().size());
            addressBook.removePerson(new Person("Земской"));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Test
    void changeAddressBook() {
        AddressBook addressBook = createAddressBook();
        try {
            addressBook.changeAddress(new Person("Полухин"), new Address("Харченко", 16, 540));
            addressBook.changeAddress(new Person("Дженжера"), new Address("Шателена", 18, 8));
            assertEquals(new Address("Харченко", 16, 540),
                    addressBook.getAddress(new Person("Полухин")));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Test
    void getAddress() {
        try {
            AddressBook addressBook = createAddressBook();
            assertEquals(new Address("Ноябрьская", 47, 69),
                    addressBook.getAddress(new Person("Новикова")));
            assertEquals(new Address("Пролетарская", 360, 308),
                    addressBook.getAddress(new Person("Дженджер")));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Test
    void findPersonsOnStreet() {
        AddressBook addressBook = createAddressBook();
        assertEquals(Arrays.asList(new Person("Новикова"), new Person("Земская"),
                new Person("Полухин")), addressBook.findPersonsOnStreet("Ноябрьская"));
        assertEquals(Arrays.asList(new Person("Дженжер")), addressBook.findPersonsOnStreet("Пролетарская"));
        assertEquals(Arrays.asList(), addressBook.findPersonsOnStreet("Харченко"));
    }


    @Test
    void findPersonsOnHouse() {
        AddressBook addressBook = createAddressBook();
        assertEquals(Arrays.asList(new Person("Новикова"), new Person("Земская")),
                addressBook.findPersonsOnHouse("Ноябрьская", 47));
        assertEquals(Arrays.asList(new Person("Багаутдинов")), addressBook.findPersonsOnHouse("Новая", 8));
        assertEquals(Arrays.asList(), addressBook.findPersonsOnHouse("Харченко", 71));
    }
}