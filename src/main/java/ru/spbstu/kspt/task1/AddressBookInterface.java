package ru.spbstu.kspt.task1;

import java.util.List;
import java.util.Map;

public interface AddressBookInterface {
    void addPersonWithAddress(Person person, Address address);

    void removePerson(Person person);

    void changeAddress(Person person, Address address);

    Address getAddress(Person person);

    List<Person> findOnStreet(String street);

    List<Person> findOnHouse(String street, Integer house);

    Map<Person, Address> getAddressBook();
}
