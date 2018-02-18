package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
//import static ru.spbstu.kspt.task1.MainTest.createAddressBook;


class MainTest {
    private static Map<Main.Person, Main.Address> MyMap = new HashMap<>();
    private static List<Main.Person> listPerson = Arrays.asList(new Main.Person("Шадрин"),
            new Main.Person("Дженжер"));
    private static List<Main.Address> listAddress = Arrays.asList(new Main.Address("Новая", 12, 325),
            new Main.Address("Пролетарская", 308, 359));

    private static Main.addressBook createAddressBook() {
        for (int i = 0; i < listPerson.size(); i++) {
            MyMap.put(listPerson.get(i), listAddress.get(i));
        }
        System.out.println(MyMap);
        return new Main.addressBook(MyMap);
    }

    @Test
    void addAddressBook() {
        Main.addressBook addressBook = createAddressBook();
        addressBook.addAddressBook(new Main.Person(""), new Main.Address("", 8, 9));
        assertEquals(3, addressBook.getAddressBook().size());
    }

    @Test
    void getAddress() {
        Main.addressBook addressBook = createAddressBook();
        System.out.println(addressBook);
        try {
            assertEquals(new Main.Address("Новая", 12, 325).toString(),
                    addressBook.getAddress(new Main.Person("Дженжер")).toString());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}

