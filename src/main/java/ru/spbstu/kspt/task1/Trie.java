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

            if (!node.children.keySet().contains(ch)) {
                return false;
            } else {
                node = node.children.get(ch);
            }

        }

        if (node.leaf) {
            return true;
        } else {
            return false;
        }

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


}
