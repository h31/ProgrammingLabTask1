package ru.spbstu.kspt.task1;

import java.util.Objects;

public class Person {
    private String name;

    public String getName() { return this.name; }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Person) {
            Person other = (Person) obj;
            return Objects.equals(name, other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() * 35;
    }
}

