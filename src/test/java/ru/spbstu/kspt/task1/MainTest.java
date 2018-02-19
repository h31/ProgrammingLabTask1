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
        addressBook.addAddressBook(new Main.Person("Долгих"), new Main.Address("Советская", 8, 9));
        addressBook.addAddressBook(new Main.Person("Кубасова"), new Main.Address("Ноябрьская", 47, 741));
        assertEquals(4, addressBook.getAddressBook().size());
    }

    @Test
    void removeAddressBook() {
        Main.addressBook addressBook = createAddressBook();
        addressBook.removeAddressBook(listPerson.get(1));
        assertEquals(3, addressBook.getAddressBook().size());
    }


    @Test
    void changeAddress() {
        Main.addressBook addressBook = createAddressBook();
        addressBook.changeAddress(listPerson.get(1), new Main.Address("Харченко", 16, 540));
        try {
            assertEquals(new Main.Address("Харченко", 16, 540), addressBook.getAddress(listPerson.get(1)));

        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    void getAddress() {
        Main.addressBook addressBook = createAddressBook();
        //System.out.println(addressBook);
        try {
            assertEquals(listAddress.get(1), addressBook.getAddress(listPerson.get(1)));
            //System.out.println(listAddress.get(1));
            assertEquals(listAddress.get(0), addressBook.getAddress(listPerson.get(0)));
            //System.out.println(listAddress.get(0));
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void findOnStreet() {
        Main.addressBook addressBook = createAddressBook();
        try {
            assertEquals(Arrays.asList(listPerson.get(1)),
                    addressBook.findOnStreet(addressBook.getAddress(listPerson.get(1)).getStreet()));
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void findOnHouse() {
        Main.addressBook addressBook = createAddressBook();
        try {
            assertEquals(Arrays.asList(listPerson.get(0)),
                    addressBook.findOnHouse(addressBook.getAddress(listPerson.get(0)).getHouse()));
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}