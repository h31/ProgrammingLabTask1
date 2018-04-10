package ru.spbstu.kspt.task1;

import java.util.*;

public class Trie {

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
            if (node.children.get(ch) != null) {
                if (node.branch) {
                    node = node.children.remove(ch);
                } else {
                    node = node.children.get(ch);
                }
            }
        }
    }

    private ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> search(String prefix) {
        TrieNode node = root;
        list.clear();
        char c = ' ';
        for (char ch : prefix.toCharArray()) {
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                throw new IllegalArgumentException("No results for: " + prefix);
            }
            c = ch;
        }
        if (!node.branch && c != ' ') {
            for (char ch : node.children.keySet()) {
                StringBuilder prefixBuilder = new StringBuilder(prefix);
                if (node.children.get(ch) == null) break;
                prefixBuilder.append(ch);
                searchHelp(prefixBuilder, prefixBuilder.toString(), node.children.get(ch));
            }
        } else {
            StringBuilder word = new StringBuilder(prefix);
            searchHelp(word, prefix, node);
        }
        if (list == null) {
           throw new IllegalArgumentException("no results for: " + prefix);
        }
        return list;
    }

    private void searchHelp(StringBuilder word, String prefix, TrieNode node) {
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

    @Override
    public String toString() {
        return toStringHelp(root, new StringBuilder(), 0);
    }

    private String toStringHelp(TrieNode node, StringBuilder word, int i) {

        for (Character ch : node.children.keySet()) {
            StringBuilder strB = new StringBuilder();
            strB.append(addSpace(i)).append(ch);
            if (node.children != null) {
                toStringHelp(node.children.get(ch), word, i + 1);
                word.insert(0, strB.append("\r").toString());
            }

        }



        return word.toString();
    }

    private static Map<Integer, String> spacesMap = new HashMap<>();

    private String addSpace(int i) {
        String result = spacesMap.get(i);
        if (result == null) {
            StringBuilder indent = new StringBuilder();
            for (int k = 0; k < i; k++) {
                indent.append(" ");
            }
            result = indent.toString();
            spacesMap.put(i, result);
        }
        return result;
    }

    public boolean equals(Trie anTrie) {
        return this.toString().equals(anTrie.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }

}
