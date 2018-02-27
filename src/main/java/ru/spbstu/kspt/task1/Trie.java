package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;
import java.util.TreeMap;

public class Trie {
    private static final Logger logger = LogManager.getLogger(Main.class);

    static class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<>();
        boolean leaf;
    }

    TrieNode root = new TrieNode();

    public void put(String s) {
        TrieNode v = root;
        System.out.println("s");
        System.out.println(s);
        for (char ch : s.toLowerCase().toCharArray()) {
            System.out.println("ch");
            System.out.println(ch);
            System.out.println("vhildren");
            System.out.println(v.children);
            if (!v.children.containsKey(ch)) {
                v.children.put(ch, new TrieNode());
                System.out.println("ch");
                System.out.println(ch);
                System.out.println("vchildren");
                System.out.println(v.children);

            }
            v = v.children.get(ch);
        }
        v.leaf = true;
    }

    public boolean find(String s) {
        TrieNode v = root;
        for (char ch : s.toLowerCase().toCharArray()) {
            System.out.println("ch");
            System.out.println(ch);
            if (!v.children.containsKey(ch)) {
                System.out.println("vchildren");
                System.out.println(v.children);
                return false;
            } else {
                v = v.children.get(ch);
                System.out.println("values");
                System.out.println(v.children.values());
            }
        }
        return true;
    }
}
