package ru.spbstu.kspt.task1;

import java.util.List;
import java.util.Map;

public interface AddressBookInterface {
    void addPersonWithAddress(Person person, Address address);

    void removePerson(Person person);

    void changeAddress(Person person, Address address);

    Address getAddress(Person person);

    List<Person> findPersonsOnStreet(String street);

    List<Person> findPersonsOnHouse(String street, int house);

    Map<Person, Address> getAddressBook();
}
