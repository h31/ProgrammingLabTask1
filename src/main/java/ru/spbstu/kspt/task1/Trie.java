package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Trie {
    private static final Logger logger = LogManager.getLogger(Main.class);

    static class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<>();
        boolean leaf;
        boolean turned;
    }

    TrieNode root = new TrieNode();


    public void insert(String str) {
        TrieNode node = root;

        for (char ch : str.toLowerCase().toCharArray()) {

            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());

                if (node != root) {
                    node.children.get(ch).turned = true;
                }

            } else {

                if (node.turned) {
                    node.turned = false;
                }

            }
            node = node.children.get(ch);
        }

        node.leaf = true;
    }


    public boolean find(String str) {
        TrieNode node = root;

        for (char ch : str.toLowerCase().toCharArray()) {

            if (!node.children.containsKey(ch)) {
                return false;
            } else {
                node = node.children.get(ch);
            }

        }

        return node.leaf;

    }


    public void delete(String str) {
        TrieNode node = root;

        for (char ch : str.toLowerCase().toCharArray()) {

            if (node.turned) {
                node = node.children.remove(ch);
            } else {
                node = node.children.get(ch);
            }

        }

    }


    public void search(String prefix) {
        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
        }

        StringBuilder word = new StringBuilder().append(prefix);

        searchHelp(word, prefix, node);

        System.out.println("_________________");
    }


    private static void searchHelp(StringBuilder word, String prefix, TrieNode node) {

        for (Character ch : node.children.keySet()) {

            word.append(ch);

            searchHelp(word, prefix, node.children.get(ch));

            word.replace(0, word.length(), prefix);

        }

        if (node.leaf) {
            System.out.println(word);
        }


    }


}
