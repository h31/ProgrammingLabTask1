package ru.spbstu.kspt.task1;

import java.util.*;

public class HashTable {
    private String[] key;
    private int size;
    private String free = null;
    private String deleted = "deleted";

    public HashTable(int size){
        this.size = size;
        key = new String[this.size];
        Arrays.fill(key, free);
    }

    public void add(String x) {
        int i = 0;
        while (i <size) {
            if (key[i] == free || key[i] == deleted) {
                key[i] = x;
            }
            i++;
        }
    }

    public boolean find(String x){
        int i = 0;
        while (i < size) {
            if (key[i] == x) return true;
            if (key[i] == free) return false;
            i++;
        }
        return false;
    }

    public void delete (String x){
        int i = 0;
        while (i < size) {
            if (key[i] == x){
                key[i] = deleted;
            }
            i++;
        }
    }
}
