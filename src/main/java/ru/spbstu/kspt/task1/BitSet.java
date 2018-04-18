package ru.spbstu.kspt.task1;

public class BitSet {

    private boolean[] arrayBitSet;
    private int size;

    public BitSet(int size) {
        this.size = size;
        this.arrayBitSet = new boolean[size];
    }

    public boolean[] getArrayBitSet() {
        return arrayBitSet;
    }

    public int getSize() {
        return arrayBitSet.length;
    }

    public boolean check(int element) {
        if (element >= 0 && element < arrayBitSet.length) {
            return arrayBitSet[element];
        }
        else {
            throw new IllegalArgumentException("Такого элемента не существует.");
        }
    }

    public void addElement(int element) {
        if (element >= 0 && element < size) {
            arrayBitSet[element] = true;
        }
        else {
            throw new IllegalArgumentException("Такого элемента не существует.");
        }
    }

    public void deleteElement(int element) {
        if (element >= 0 && element < size) {
            arrayBitSet[element] = false;
        } else {
            throw new IllegalArgumentException("Такого элемента не существует.");
        }
    }

    public void addElements(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    public void deleteElements(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            deleteElement(elements[i]);
        }
    }

    private boolean checkSize (int setSize, int otherSetSize) {
        return setSize == otherSetSize;
    }

    public BitSet union(BitSet set, BitSet otherSet) {
        if (!checkSize(set.size, otherSet.size)) {
            throw new IllegalArgumentException("Разные размеры множества.");
        }
        BitSet setOfUnion = new BitSet(size);
        for (int i = 0; i < size - 1; i++) {
            if (set.arrayBitSet[i] || otherSet.arrayBitSet[i]) {
                setOfUnion.arrayBitSet[i] = true;
            }
        }
        return setOfUnion;
    }

    public BitSet intersect(BitSet set, BitSet otherSet) {
        if (!checkSize(set.size, otherSet.size)) {
            throw new IllegalArgumentException("Разные размеры множества.");
        }
        BitSet setOfIntersect = new BitSet(size);
        for (int i = 0; i < size - 1; i++) {
            if (set.arrayBitSet[i] && otherSet.arrayBitSet[i]) {
                setOfIntersect.arrayBitSet[i] = true;
            }
        }
        return setOfIntersect;
    }
    public BitSet complement(BitSet firstSet, BitSet secondSet) {
        if (!checkSize(firstSet.size, secondSet.size)) {
            throw new IllegalArgumentException("Разные размеры множества.");
        }
        BitSet setOfComplements = new BitSet(size);
        for (int i = 0; i < size - 1; i++) {
            if (firstSet.arrayBitSet[i]) {
                setOfComplements.arrayBitSet[i] = !secondSet.arrayBitSet[i];
            }
        }
        return setOfComplements;
    }
}