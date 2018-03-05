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


    public void insert(String str) {
        TrieNode v = root;

        for (char ch : str.toLowerCase().toCharArray()) {
            if (!v.children.containsKey(ch)) {
                v.children.put(ch, new TrieNode());
                System.out.println("i");
                System.out.println(v.children.keySet());
            }
            v = v.children.get(ch);

        }
        v.leaf = true;

    }


    public boolean find(String str) {
        TrieNode v = root;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (!v.children.containsKey(ch)) {
                return false;
            } else {
                v = v.children.get(ch);
            }
        }
        return true;
    }


    public void delete(String str) {
        TrieNode v = root;
        Trie trie = new Trie();
        boolean broExist = false;
        String str2 = str;
        for (char ch : str.substring(1).toLowerCase().toCharArray()) {
            if ( v.children.keySet().size() > 1) {
                System.out.println(v.children.keySet().size());
                broExist = true;
                str2 = str.substring(str.indexOf(ch));
                System.out.println(str2);
            }
        }

        for (char ch : str2.toLowerCase().toCharArray()) {
            v.children.remove(ch);
            System.out.println("d");
            System.out.println(v.children.keySet());


        }

    }


}
