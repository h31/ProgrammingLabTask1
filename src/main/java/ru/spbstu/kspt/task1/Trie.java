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
        if (trie.find(str)) {
            for (char ch : str.toLowerCase().toCharArray()) {
                if (v.children.containsKey(ch)) {
                    v.children.remove(ch);
                }
                v = v.children.get(ch);
            }
        }
    }


}
