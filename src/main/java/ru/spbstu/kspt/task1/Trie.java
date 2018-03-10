package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Trie {
    private static final Logger logger = LogManager.getLogger(Main.class);

    static class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<>();
        boolean leaf;
    }

    TrieNode root = new TrieNode();
    List existedChars = new ArrayList<Character>();

    public void insert(String str) {
        int i = 0;
        TrieNode v = root;
        boolean bro = false;
        for (char ch : str.toLowerCase().toCharArray()) {
            i++;
            if (!v.children.containsKey(ch)){
                v.children.put(ch, new TrieNode());
            }
            else {
                if (!existedChars.contains(ch)) {
                    existedChars.add(ch);
                }
            }
            v = v.children.get(ch);

        }
        v.leaf = true;
        System.out.println(existedChars);
    }


    public boolean find(String str) {
        TrieNode v = root;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (!v.children.keySet().contains(ch)) {
                return false;
            } else {
                v = v.children.get(ch);
            }
        }

            return true;

    }

    public boolean broExist(String str) {
        TrieNode v = root;
        boolean result = false;
        for (char ch : str.toLowerCase().toCharArray()) {
            if ( v.children.keySet().size() > 1 && v != root) {
                result = true;
            }
            if (v.children.get(ch) != null) {
                v = v.children.get(ch);
            }
        }
        return result;
    }


    public void delete(String str) {
        Trie trie = new Trie();

        TrieNode v = root;
        boolean broExist = false;
        String str2 = str;
        System.out.println(str2);
        for (char ch : str.toLowerCase().toCharArray()) {
            if (  v != root  && !existedChars.contains(ch) ) {
                System.out.println(v.children.keySet());
                //v.children.remove(ch);
                v.children.put('@', v.children.remove(ch));
                v = v.children.get('@');
                System.out.println(v.children.keySet());


            }
            else {
                if (v.children.get(ch) != null) {
                    System.out.println("else");
                    v = v.children.get(ch);
                    v.leaf = false;
                }
            }

        }


    }


}
