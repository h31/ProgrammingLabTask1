package ru.spbstu.kspt.task1;

class HashCreate {
    private int key;
    private int value;

    HashCreate(int key, int value) {
        this.key = key;
        this.value = value;
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    int getKey() {
        return key;
    }
}
