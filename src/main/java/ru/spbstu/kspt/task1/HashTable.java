package ru.spbstu.kspt.task1;

public class HashTable {
        private HashCreate[] table;
        private static int size = 8;

        HashTable() {
            table = new HashCreate[size];
            for (int i = 0; i < size; i++)
                table[i] = null;
        }

    public HashCreate[] add (int key, int value) {
        int hash = key % size;
        int initial = -1;
        int indexOfDeletedEntry = -1;
        while (hash != initial
                && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null
                && table[hash].getKey() != key)) {
            if (initial == -1)
                initial = hash;
            if (table[hash] == DeletedEntry.getUniqueDeletedEntry())
                indexOfDeletedEntry = hash;
            hash = (hash + 1) % size;
        }
        if ((table[hash] == null || hash == initial)
                && indexOfDeletedEntry != -1)
            table[indexOfDeletedEntry] = new HashCreate(key, value);
        else if (initial != hash)
            if (table[hash] != DeletedEntry.getUniqueDeletedEntry()
                    && table[hash] != null && table[hash].getKey() == key)
                table[hash].setValue(value);
            else
                table[hash] = new HashCreate(key, value);
            return table;
    }

    public int get(int key) {
        int hash = key % size;
        int initial = -1;
        while (hash != initial && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null
                && table[hash].getKey() != key)) {
            if (initial == -1)
                initial = hash;
            hash = (hash + 1) % size;
        }
        if (table[hash] == null || hash == initial) return -1;
        else
            return table[hash].getValue();
    }


    public HashCreate[] delete(int key) {
        int hash = key % size;
        int initial = -1;
        while (hash != initial && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null
                && table[hash].getKey() != key)) {
            if (initial == -1)
                initial = hash;
            hash = (hash + 1) % size;
        }
        if (hash != initial && table[hash] != null)
            table[hash] = DeletedEntry.getUniqueDeletedEntry();
        return table;
    }
}
