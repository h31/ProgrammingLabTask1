package ru.spbstu.kspt.task1;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Trie {
    private static final Logger logger = LogManager.getLogger(Main.class);

    static class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<>();
        boolean branch;
    }
    TrieNode root = new TrieNode();


    public void insert(String str) {
        TrieNode node = root;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
                if (node != root) {
                    node.children.get(ch).branch = true;
                }
            } else if (node.branch) {
                node.branch = false;
            }
            node = node.children.get(ch);
        }
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
        return true;
    }


    public void delete(String str) {
        TrieNode node = root;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (node.branch) {
                node = node.children.remove(ch);
            } else {
                node = node.children.get(ch);
            }
        }
    }
    ArrayList list = new ArrayList<String>();


    public ArrayList<String> search(String prefix) {
        TrieNode node = root;
        list.clear();
        for (char ch : prefix.toCharArray()) {
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                logger.error("No results for: " + prefix);
                return list;
            }
        }
        StringBuilder word = new StringBuilder().append(prefix);
        searchHelp(word, prefix, node);
        return list;
    }


    private void searchHelp(StringBuilder word, String prefix, TrieNode node) {
        TrieNode bazeNode = node;
        Character c = ' ';
        for (Character ch : node.children.keySet()) {
            word.append(ch);
            searchHelp(word, prefix, node.children.get(ch));
            word.replace(0, word.length(), prefix);
            c = ch;
        }
        if (node.children.get(c) == null) {
            list.add(word.toString());
        }
    }


    public boolean equals(Trie trie, Trie anTrie) {
        TrieNode node1 = root;
        TrieNode node2 = root;
        return trie.equals(anTrie);
    }


    public String toString() {
        return toStringHelp(root, 0);
    }
    StringBuilder strB = new StringBuilder();

    private String toStringHelp(TrieNode node, int i) {
        StringBuilder word = new StringBuilder();
        Character c = ' ';
        for (Character ch : node.children.keySet()) {
            word.append(indentation(i)).append(ch).append("\r");
            toStringHelp(node.children.get(ch), i + 1);
            strB = strB.append(word, 0, word.length());
        }

        if (node.children == null) {
            return word.toString();
        } else return word.toString();
    }

   static Map<Integer, String> indentsMap = new HashMap<>();

   public String indentation(int i){
        String result = indentsMap.get(i);
        if (result == null) {
            StringBuilder indent = new StringBuilder();
            for (int k = 0; k < i; k++) {
                indent.append(" ");
            }
            result = indent.toString();
            indentsMap.put(i, result);
        }
        return result;
   }




}
