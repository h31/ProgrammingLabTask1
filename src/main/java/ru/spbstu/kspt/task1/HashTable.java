package ru.spbstu.kspt.task1;

public class HashTable {
        private Cell[] table;
        private static int size = 8;

        HashTable() {
            table = new Cell[size];
            for (int i = 0; i < size; i++)
                table[i] = null;
        }

    public HashTable add(int key, int value) {
        int hashCode = key % size;
        int indexStart = -1;
        int indexOfDeletedCell = -1;
        while (hashCode != indexStart
                && (table[hashCode] == DeletedCell.getUniqueDeletedCell() || table[hashCode] != null
                && table[hashCode].getKey() != key)) {
            if (indexStart == -1)
                indexStart = hashCode;
            if (table[hashCode] == DeletedCell.getUniqueDeletedCell())
                indexOfDeletedCell = hashCode;
            hashCode = (hashCode + 1) % size;
        }
        if ((table[hashCode] == null || hashCode == indexStart)
                && indexOfDeletedCell != -1)
            table[indexOfDeletedCell] = new Cell(key, value);
        else if (indexStart != hashCode)
            if (table[hashCode] != DeletedCell.getUniqueDeletedCell()
                    && table[hashCode] != null && table[hashCode].getKey() == key)
                table[hashCode].setValue(value);
            else
                table[hashCode] = new Cell(key, value);
        return null;
    }

    public int get(int key) {
        int hashCode = key % size;
        int indexStart = -1;
        while (hashCode != indexStart && (table[hashCode] == DeletedCell.getUniqueDeletedCell() || table[hashCode] != null
                && table[hashCode].getKey() != key)) {
            if (indexStart == -1)
                indexStart = hashCode;
            hashCode = (hashCode + 1) % size;
        }
        return table[hashCode].getValue();
    }


    public HashTable delete(int key) {
        int hashCode = key % size;
        int indexStart = -1;
        while (hashCode != indexStart && (table[hashCode] == DeletedCell.getUniqueDeletedCell() || table[hashCode] != null
                && table[hashCode].getKey() != key)) {
            if (indexStart == -1)
                indexStart = hashCode;
            hashCode = (hashCode + 1) % size;
        }
        if (hashCode != indexStart && table[hashCode] != null)
            table[hashCode] = DeletedCell.getUniqueDeletedCell();
        return null;
    }
}
