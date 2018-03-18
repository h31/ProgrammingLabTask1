package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    private static final Logger logger = LogManager.getLogger(FieldTest.class);

    @Test
    void firstTest() {
        logger.info("Test started");

        Field fieldTest = new Field(4);
        assertEquals(0, fieldTest.searchLongestSequenceHorizontally(1));
        assertEquals(0, fieldTest.searchLongestSequenceVertically(1));
        assertEquals(0, fieldTest.searchLongestSequenceDiagonally(1));

        fieldTest.addCross(0, 0);
        fieldTest.addNought(1, 1);
        fieldTest.devastate(0, 0);
        fieldTest.devastate(1, 1);
        assertEquals(0, fieldTest.searchLongestSequenceHorizontally(1));

        fieldTest.addCross(0, 0);
        fieldTest.addCross(1, 1);
        fieldTest.addCross(2, 1);
        fieldTest.addCross(2, 2);
        assertEquals(3, fieldTest.searchLongestSequenceDiagonally(1));
        assertEquals(0, fieldTest.searchLongestSequenceDiagonally(0));

        fieldTest.addCross(0, 0);
        fieldTest.addCross(3, 1);
        fieldTest.addCross(1, 2);
        fieldTest.addCross(3, 0);
        fieldTest.addNought(2, 3);
        fieldTest.addCross(0, 3);
        assertEquals(4, fieldTest.searchLongestSequenceDiagonally(1));

        fieldTest.devastate(0, 0);
        fieldTest.devastate(3, 0);
        fieldTest.devastate(0, 3);
        fieldTest.devastate(1, 1);
        fieldTest.devastate(3, 1);
        fieldTest.devastate(2, 1);
        fieldTest.devastate(2, 2);
        fieldTest.devastate(2, 3);
        fieldTest.addNought(1, 0);
        fieldTest.addNought(2, 0);
        fieldTest.addNought(3, 0);
        fieldTest.addNought(0, 1);
        fieldTest.addNought(2, 1);
        fieldTest.addNought(3, 1);
        fieldTest.addCross(1, 1);
        assertEquals(3, fieldTest.searchLongestSequenceHorizontally(0));
        assertEquals(2, fieldTest.searchLongestSequenceVertically(0));

        logger.info("Test finished");
    }

    @Test
    void secondTest() {
        logger.info("Test started");

        Field fieldTest = new Field(5);
        fieldTest.addCross(0, 0);
        fieldTest.addNought(1, 0);
        fieldTest.addCross(2, 0);
        fieldTest.addCross(3, 0);
        fieldTest.addCross(4, 0);
        fieldTest.addCross(0, 1);
        fieldTest.addCross(1, 1);
        fieldTest.addNought(2, 1);
        fieldTest.addCross(3, 1);
        fieldTest.addCross(4, 1);
        fieldTest.addNought(0, 2);
        fieldTest.addNought(1, 2);
        fieldTest.addCross(2, 2);
        fieldTest.addCross(3, 2);
        fieldTest.addCross(4, 2);
        fieldTest.addCross(0, 3);
        fieldTest.addCross(1, 3);
        fieldTest.addNought(2, 3);
        fieldTest.addCross(3, 3);
        fieldTest.addNought(4, 3);
        fieldTest.addCross(0, 4);
        fieldTest.addCross(1, 4);
        fieldTest.addCross(2, 4);
        fieldTest.addCross(3, 4);
        fieldTest.addNought(4, 4);
        assertEquals(5, fieldTest.searchLongestSequenceVertically(1));
        assertEquals(4, fieldTest.searchLongestSequenceHorizontally(1));
        assertEquals(5, fieldTest.searchLongestSequenceDiagonally(1));

        logger.info("Test finished");
    }
}