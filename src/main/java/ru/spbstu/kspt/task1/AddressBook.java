package ru.spbstu.kspt.task1;

import java.util.*;


public class AddressBook implements AddressBookInterface {

    public Map<Person, Address> addressBook = new LinkedHashMap<>();

    public void addPersonWithAddress(Person person, Address address) {
        if (addressBook.containsKey(person)) {
            throw new IllegalArgumentException("Такой человек уже существует в адресной книге. Перезапись невозможна.");
        } else {
            addressBook.put(person, address);
        }
    }

    public void removePerson(Person person) {
        if (addressBook.containsKey(person)) {
            addressBook.remove(person);
        } else {
            throw new IllegalArgumentException("Этого человека нет в адресной книге. Удаление невозможно.");
        }
    }

    public void changeAddress(Person person, Address address) {
        if (addressBook.containsKey(person)) {
            addressBook.replace(person, address);
        } else {
            throw new IllegalArgumentException("Этого человека нет в адресной книге. Изменение адреса невозможно.");
        }
    }

    public Address getAddress(Person person) {
        if (addressBook.containsKey(person)) {
            return addressBook.get(person);
        } else {
            throw new IllegalArgumentException("Этого человека нет в адресной книге. Получение адреса невозможно.");
        }
    }

    public List<Person> findPersonsOnStreet(String street) {
        List<Person> listOfPerson = new ArrayList<>();
        for (Map.Entry<Person, Address> addressBookRecord : addressBook.entrySet()) {
            if (Objects.equals(addressBookRecord.getValue().getStreet(), street)) {
                listOfPerson.add(addressBookRecord.getKey());
            }
        }
        return listOfPerson;
    }

    public List<Person> findPersonsOnHouse(String street, int house) {
        List<Person> listOfPerson = new ArrayList<>();
        for (Map.Entry<Person, Address> addressBookRecord : addressBook.entrySet()) {
            if (Objects.equals(addressBookRecord.getValue().getStreet(), street) &&
                    addressBookRecord.getValue().getHouse() == house) {
                listOfPerson.add(addressBookRecord.getKey());
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
        for (Map.Entry<Person, Address> addressBookRecord : addressBook.entrySet()) {
            result.append(addressBookRecord.getKey()).append(": ").append(addressBookRecord.getValue()).append("\n");
        }
        return result.toString();
    }

    @Override
    public int hashCode() {
        return this.getAddressBook().hashCode();
    }
}



