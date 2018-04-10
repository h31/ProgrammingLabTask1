package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {



    @Test
    void insertAndDeleteTest() {
        Trie testTrie = new Trie();
        testTrie.insert("wolk");
        testTrie.insert("kotAssFirst");
        testTrie.insert("russian");
        testTrie.insert("walt");
        testTrie.insert("roll");
        testTrie.insert("rrrrock");
        testTrie.insert("word");
        testTrie.insert("world");
        testTrie.insert("wored");
        testTrie.insert("worry");
        testTrie.insert("kotlin");
        testTrie.insert("rrrrrrrrrr");
        assertEquals(true, testTrie.find("word"));
        assertEquals(true, testTrie.find("worry"));
        assertEquals(false, testTrie.find("hello"));
        assertEquals(true, testTrie.find("kotlin"));
        assertEquals(true, testTrie.find("wolk"));
        assertEquals(true, testTrie.find("kotAssFirst"));
        assertEquals(true, testTrie.find("russian"));
        assertEquals(true, testTrie.find("rrrrock"));
        assertEquals(true, testTrie.find("walt"));
        assertEquals(true, testTrie.find("roll"));
        assertEquals(true, testTrie.find("rrrrrrrrrr"));
        assertEquals(true, testTrie.find("kotlin"));
        testTrie.delete("world");
        assertEquals(false, testTrie.find("world"));
        testTrie.delete("rrrrock");
        assertEquals(false, testTrie.find("rrrrock"));
        testTrie.delete("russian");
        assertEquals(false, testTrie.find("russian"));
        testTrie.delete("kotAssFirst");
        assertEquals(false, testTrie.find("kotAssFirst"));
        testTrie.delete("roll");
        assertEquals(false, testTrie.find("roll"));
        testTrie.delete("walt");
        assertEquals(false, testTrie.find("walt"));
        testTrie.delete("worry");
        assertEquals(false, testTrie.find("worry"));
        assertEquals(true, testTrie.find("word"));
        testTrie.delete("kotlin");
        assertEquals(false, testTrie.find("kotlin"));
    }

    @Test
    void searchTest() {
        ArrayList<String> list = new ArrayList<>();
        Trie trie = new Trie();
        trie.insert("worry");
        trie.insert("world");
        trie.insert("word");
        trie.insert("wored");
        trie.insert("kotlin");
        trie.insert("kotassfirst");
        trie.insert("wolt");
        trie.insert("wolk");
        list.add("word");
        list.add("wored");
        list.add("world");
        list.add("worry");
        assertEquals(list ,trie.search("wor"));
        list.clear();
        list.add("kotassfirst");
        list.add("kotlin");
        assertEquals(list, trie.search("kot"));
        list.clear();
        list.add("wolk");
        list.add("wolt");
        list.add("word");
        list.add("wored");
        list.add("world");
        list.add("worry");
        assertEquals(list, trie.search("wo"));
        list.clear();
        try {
            trie.search("hello");
        }
        catch (IllegalArgumentException e){
            assertEquals("No results for: hello", e.getMessage());
        }
    }

    @Test
    void toStringTest() {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hey");
        trie.insert("hola");
        Assertions.assertEquals("h\r o\r  l\r   a\r e\r" + "  y\r" + "  l\r   l\r    o\r", trie.toString());
    }

    @Test
    void equalsTest() {
        Trie firstTrie = new Trie();
        Trie secondTrie = new Trie();
        firstTrie.insert("hello");
        secondTrie.insert("hello");
        assertFalse(new Trie().equals(secondTrie));
        assertTrue(firstTrie.equals(secondTrie));
    }
}
