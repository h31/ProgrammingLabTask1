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
        assertEquals(false, testTrie.find("word"));
        testTrie.insert("word");
        assertEquals(true, testTrie.find("word"));
        testTrie.insert("worry");
        assertEquals(true, testTrie.find("worry"));
        assertEquals(true, testTrie.find("wor"));
        assertEquals(false, testTrie.find("hello"));
        testTrie.insert("kotlin");
        assertEquals(true, testTrie.find("kotlin"));
        testTrie.delete("kotlin");
        assertEquals(false, testTrie.find("kotlin"));
        testTrie.delete("word");
        assertEquals(false, testTrie.find("word"));
        assertEquals(true, testTrie.find("worry"));
        logger.info("Test finished");
    }
}
