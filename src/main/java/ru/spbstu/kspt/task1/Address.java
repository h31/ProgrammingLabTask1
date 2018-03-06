package ru.spbstu.kspt.task1;

import java.util.Objects;

public class Address {
    public String street;
    public int house;
    private int flat;

    public Address(String street, int house, int flat) {
        this.street = street;
        if (house <= 0 || flat <= 0) throw new IllegalArgumentException();
        this.house = house;
        this.flat = flat;
    }

    public String getStreet() {
        return this.street;
    }

    public int getHouse() {
        return this.house;
    }

    @Override
    public String toString() {
        return street + " " + house + " " + flat;
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

