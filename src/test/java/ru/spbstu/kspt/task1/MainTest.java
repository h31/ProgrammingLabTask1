package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static final Logger logger = LogManager.getLogger(MainTest.class);

    @Test
    void exampleTest() {
        logger.info("Test started");
        BST a = new BST();
        Node root = null;
        root = a.insert(root,5);
        root = a.insert(root,8);
        root = a.insert(root,6);
        root = a.insert(root,10);
        root = a.insert(root,15);
        root = a.insert(root,12);
        root = a.insert(root,13);
        root = a.insert(root,4);
        root = a.insert(root,3);
        assertEquals(true,a.searchElement(root,6));
        assertEquals(false,a.searchElement(root,7));
        /*Тесты для leftElement*/
        assertEquals(6,a.leftElement(root,8));
        assertEquals(12,a.leftElement(root,15));
        /*Тесты для rightElement*/
        assertEquals(8,a.rightElement(root,5));
        assertEquals(15,a.rightElement(root,10));
        /*Тесты для parrentElement*/
        assertEquals(5,a.parentElement(root,8));
        assertEquals(8,a.parentElement(root,10));
        assertEquals(10,a.parentElement(root,15));
        logger.info("Test finished");
    }
}
