package ru.spbstu.kspt.task1;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class MainTest {
    private static Map<Main.Person, Main.Address> MyMap = new LinkedHashMap<>();

    private static Main.addressBook createAddressBook() {
        return new Main.addressBook(MyMap);
    }


    @Test
    void addAddressBook() {
        Main.addressBook addressBook = createAddressBook();
        addressBook.addAddressBook(new Main.Person("Долгих"), new Main.Address("Советская", 8, 9));
        addressBook.addAddressBook(new Main.Person("Кубасова"), new Main.Address("Ноябрьская", 47, 741));
        assertEquals(2, addressBook.getAddressBook().size());
        addressBook.addAddressBook(new Main.Person("Полухин"), new Main.Address("наб.Фонтанки", 56, 8));
        assertEquals(3, addressBook.getAddressBook().size());
        addressBook.addAddressBook(new Main.Person("Виноградный"), new Main.Address("наб.Фонтанки", 8, 359));
        assertEquals(4, addressBook.getAddressBook().size());
        addressBook.addAddressBook(new Main.Person("Шадрин"), new Main.Address("наб.Фонтанки", 56, 18));
        assertEquals(5, addressBook.getAddressBook().size());
    }


    @Test
    void removeAddressBook() {
        Main.addressBook addressBook = createAddressBook();
        addressBook.removeAddressBook((Main.Person) MyMap.keySet().toArray()[0]);
        assertEquals(4, addressBook.getAddressBook().size());
        addressBook.removeAddressBook((Main.Person) MyMap.keySet().toArray()[0]);
        assertEquals(3, addressBook.getAddressBook().size());
    }


    @Test
    void changeAddressBook() {
        Main.addressBook addressBook = createAddressBook();
        addressBook.changeAddressBook(((Main.Person) MyMap.keySet().toArray()[1]), new Main.Address("Харченко", 16, 540));
        addressBook.changeAddressBook((Main.Person) MyMap.keySet().toArray()[0], new Main.Address("Шателена", 18, 8));
        try {
            assertEquals(new Main.Address("Харченко", 16, 540),
                    addressBook.getAddress((Main.Person) MyMap.keySet().toArray()[1]));
            assertEquals(new Main.Address("Шателена", 18, 8),
                    addressBook.getAddress((Main.Person) MyMap.keySet().toArray()[0]));

        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    void getAddress() {
        Main.addressBook addressBook = createAddressBook();
        try {
            assertEquals((MyMap.values().toArray()[1]),
                    addressBook.getAddress((Main.Person) MyMap.keySet().toArray()[1]));
            assertEquals(MyMap.values().toArray()[0],
                    addressBook.getAddress((Main.Person) MyMap.keySet().toArray()[0]));
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    void findOnStreet() {
        Main.addressBook addressBook = createAddressBook();
        try {
            assertEquals(Arrays.asList((Main.Person) MyMap.keySet().toArray()[0],
                    MyMap.keySet().toArray()[1], MyMap.keySet().toArray()[2]),
                    addressBook.findOnStreet(addressBook.getAddress((Main.Person) MyMap.keySet().toArray()[1]).getStreet()));
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    void findOnHouse() {
        Main.addressBook addressBook = createAddressBook();
        try {
            assertEquals(Arrays.asList((Main.Person) MyMap.keySet().toArray()[2], MyMap.keySet().toArray()[4]),
                    addressBook.findOnHouse(addressBook.getAddress((Main.Person)
                            MyMap.keySet().toArray()[2]).getStreet(), addressBook.getAddress((Main.Person)
                            MyMap.keySet().toArray()[2]).getHouse()));
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}