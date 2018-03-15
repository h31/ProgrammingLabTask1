package ru.spbstu.kspt.task1;

import java.util.Objects;

public class Address {
    private String street;
    private int house;
    private int flat;

    public Address(String street, int house, int flat) {
        if (street.isEmpty() || house <= 0 || flat <= 0) {
            throw new IllegalArgumentException("Неправильно введен адрес.");
        }
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public Address(String address) {
        if (address.matches("ул\\.\\s+.+,\\s+д\\.\\s+\\d+,\\s+кв\\.\\s+\\d+")) {
            String[] addressParts = address.replaceAll(",", "").split("\\s+");
            this.street = addressParts[1];
            this.house = Integer.parseInt(addressParts[3]);
            this.flat = Integer.parseInt(addressParts[5]);
        } else {
            throw new IllegalArgumentException("Неверный формат адреса. " +
                    "Он должен быть вида ул. Улица, д. Номер дома, кв. Номер квартиры.");
        }
    }

    public String getStreet() {
        return this.street;
    }

    public int getHouse() {
        return this.house;
    }

    public int getFlat() {
        return this.flat;
    }

    @Override
    public String toString() {
        return "ул. " + street + ", д. " + house + ", кв. " + flat;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Address) {
            Address other = (Address) obj;
            return Objects.equals(street, other.street) && house == other.house && flat == other.flat;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.house * this.flat + this.street.hashCode();
    }
}

