package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

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
        addressBook.addPersonWithAddress(new Person("Вязиков"),
                new Address("Ноябрьская", 40, 52));
        addressBook.addPersonWithAddress(new Person("Багаутдинов"),
                new Address("Новая", 8, 367));
        return addressBook;
    }

    @Test
    void addPersonWithAddress() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPersonWithAddress(new Person("Долгих"), new Address("Советская", 8, 9));
        addressBook.addPersonWithAddress(new Person("Кубасова"), new Address("Ноябрьская", 47, 741));
        assertEquals(2, addressBook.getAddressBook().size());
        addressBook.addPersonWithAddress(new Person("Полухин"), new Address("наб.Фонтанки", 56, 8));
        assertEquals(3, addressBook.getAddressBook().size());
        addressBook.addPersonWithAddress(new Person("Виноградный"), new Address("наб.Фонтанки", 8, 359));
        assertEquals(4, addressBook.getAddressBook().size());
        addressBook.addPersonWithAddress(new Person("Шадрин"), new Address("наб.Фонтанки", 56, 18));
        assertEquals(5, addressBook.getAddressBook().size());
    }


    @Test
    void removePerson() {
        AddressBook addressBook = createAddressBook();
        addressBook.removePerson(new Person("Багаутдинов"));
        assertEquals(4, addressBook.getAddressBook().size());
        addressBook.removePerson(new Person("Земская"));
        assertEquals(3, addressBook.getAddressBook().size());
    }


    @Test
    void changeAddressBook() {
        AddressBook addressBook = createAddressBook();
        addressBook.changeAddress(new Person("Вязиков"), new Address("Харченко", 16, 540));
        addressBook.changeAddress(new Person("Дженжер"), new Address("Шателена", 18, 8));
            assertEquals(new Address("Харченко", 16, 540),
                    addressBook.getAddress(new Person("Вязиков")));
            assertEquals(new Address("Шателена", 18, 8),
                    addressBook.getAddress(new Person("Дженжер")));
        }



    @Test
    void getAddress() {
        AddressBook addressBook = createAddressBook();
            assertEquals(new Address("Ноябрьская", 47, 69),
                    addressBook.getAddress(new Person("Новикова")));
            assertEquals(new Address("Пролетарская", 360, 308),
                    addressBook.getAddress(new Person("Дженжер")));
        }



    @Test
    void findOnStreet() {
        AddressBook addressBook = createAddressBook();
            assertEquals(Arrays.asList(new Person("Новикова"), new Person("Земская"),
                    new Person("Вязиков")), addressBook.findOnStreet("Ноябрьская"));
    }


    @Test
    void findOnHouse() {
        AddressBook addressBook = createAddressBook();
        assertEquals(Arrays.asList(new Person("Новикова"), new Person("Земская")),
                addressBook.findOnHouse("Ноябрьская", 47));
    }
}