package ru.spbstu.kspt.task1;

class Cell {
    private int key;
    private int value;

    Cell(int key, int value) {
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
