package ru.spbstu.kspt.task1;

import java.util.*;


public class AddressBook {
    public Map<Person, Address> addressBook = new LinkedHashMap<>();

    public AddressBook() {
    }

    public void addPersonWithAddress(Person person, Address address) {
        addressBook.put(person, address);
    }

    public void removePerson(Person person) {
        addressBook.remove(person);
    }

    public void changeAddress(Person person, Address address) {
        if (addressBook.containsKey(person)) {
            addressBook.replace(person, address);
        }
    }

    public Address getAddress(Person person) {
        if (addressBook.containsKey(person)) {
            return addressBook.get(person);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<Person> findOnStreet(String street) {
        List<Person> listOfPerson = new ArrayList<>();
        for (Map.Entry<Person, Address> mapSet : addressBook.entrySet()) {
            if (Objects.equals(mapSet.getValue().street, street)) {
                listOfPerson.add(mapSet.getKey());
            }
        }
        return listOfPerson;
    }

    public List<Person> findOnHouse(String street, Integer house) {
        List<Person> listOfPerson = new ArrayList<>();
        for (Map.Entry<Person, Address> mapSet : addressBook.entrySet()) {
            if (Objects.equals(mapSet.getValue().street, street) &&
                    mapSet.getValue().house == house) {
                listOfPerson.add(mapSet.getKey());
            }
        }
        return listOfPerson;
    }

    public Map<Person, Address> getAddressBook() {
        return addressBook;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Person, Address> mapSet : addressBook.entrySet()) {
            result.append(mapSet.getKey()).append(mapSet.getValue()).append("\n");
        }
        return result.toString();
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode() * this.getAddressBook().hashCode();
    }
}



