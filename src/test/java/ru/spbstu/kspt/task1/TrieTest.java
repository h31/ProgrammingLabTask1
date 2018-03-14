package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrieTest {
    private static final Logger logger = LogManager.getLogger(MainTest.class);

    @Test
    void exampleTest() {
        logger.info("Test started");
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
        assertEquals(true, testTrie.find("word"));
        testTrie.insert("worty");
        assertEquals(true, testTrie.find("worty"));
        assertEquals(false, testTrie.find("hello"));
        testTrie.insert("kotlin");
        assertEquals(true, testTrie.find("kotlin"));
        testTrie.insert("rrrrrrrrrr");
        assertEquals(true, testTrie.find("rrrrrrrrrr"));
        testTrie.search("wor");
        testTrie.search("kot");
        testTrie.search("rrr");
        testTrie.search("hello");
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
        testTrie.delete("worty");
        assertEquals(false, testTrie.find("worty"));
        assertEquals(true, testTrie.find("word"));
        testTrie.delete("kotlin");
        assertEquals(false, testTrie.find("kotlin"));



        logger.info("Test finished");
    }
}
