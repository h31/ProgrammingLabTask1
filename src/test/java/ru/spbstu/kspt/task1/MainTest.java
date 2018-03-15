package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        addressBook.addPersonWithAddress(new Person("Долгих"),
                new Address("Советская", 8, 9));
        addressBook.addPersonWithAddress(new Person("Кубасова"),
                new Address("Ноябрьская", 47, 741));
        assertEquals(7, addressBook.getAddressBook().size());
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.addPersonWithAddress(new Person("Полухин"),
                        new Address("наб.Фонтанки", 56, 8)));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.addPersonWithAddress(new Person("Виноградный"),
                        new Address("наб.Фонтанки", -8, 359)));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.addPersonWithAddress(new Person("Шадрин"), new Address("", 56, 18)));
    }


    @Test
    void removePerson() {
        AddressBook addressBook = createAddressBook();
        addressBook.removePerson(new Person("Новикова"));
        assertEquals(4, addressBook.getAddressBook().size());
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.removePerson(new Person("Земской")));
    }


    @Test
    void changeAddressBook() {
        AddressBook addressBook = createAddressBook();
        addressBook.changeAddress(new Person("Полухин"), new Address("Харченко", 16, 540));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.changeAddress(new Person("Дженжера"), new Address("Шателена", 18, 8)));
        assertEquals(new Address("Харченко", 16, 540),
                addressBook.getAddress(new Person("Полухин")));

    }


    @Test
    void getAddress() {
        AddressBook addressBook = createAddressBook();
        assertEquals(new Address("Ноябрьская", 47, 69),
                addressBook.getAddress(new Person("Новикова")));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.getAddress(new Person("Дженджер")));
    }


    @Test
    void findPersonsOnStreet() {
        AddressBook addressBook = createAddressBook();
        assertEquals(Arrays.asList(new Person("Новикова"), new Person("Земская"),
                new Person("Полухин")), addressBook.findPersonsOnStreet("Ноябрьская"));
        assertEquals(Collections.singletonList(new Person("Дженжер")),
                addressBook.findPersonsOnStreet("Пролетарская"));
        assertEquals(Collections.emptyList(), addressBook.findPersonsOnStreet("Харченко"));

    }


    @Test
    void findPersonsOnHouse() {
        AddressBook addressBook = createAddressBook();
        assertEquals(Arrays.asList(new Person("Новикова"), new Person("Земская")),
                addressBook.findPersonsOnHouse("Ноябрьская", 47));
        assertEquals(Collections.singletonList(new Person("Багаутдинов")), addressBook.findPersonsOnHouse("Новая", 8));
        assertEquals(Collections.emptyList(), addressBook.findPersonsOnHouse("Харченко", 71));
    }

    
    @Test
    void stringToAddress() {
        assertEquals("ул. Пушкина, д. 15, кв. 12", new Address("ул. Пушкина, д. 15, кв. 12").toString());
        assertThrows(IllegalArgumentException.class, () ->
                new Address("ул. Шателена, д. -8, кв. 8"));
        assertThrows(IllegalArgumentException.class, () ->
                new Address("Шателена, 8, 8"));

    }
}