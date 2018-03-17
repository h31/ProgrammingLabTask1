package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        fieldTest.devastate(0, 0);
        assertEquals(0, fieldTest.searchLongestSequenceHorizontally(1));

        fieldTest.addCross(0, 0);
        fieldTest.addCross(1, 1);
        fieldTest.addCross(2, 1);
        fieldTest.addCross(2, 2);
        assertEquals(3, fieldTest.searchLongestSequenceDiagonally(1));

        fieldTest.addCross(0, 0);
        fieldTest.addCross(1, 1);
        fieldTest.addCross(2, 1);
        fieldTest.addCross(2, 2);
        assertEquals(0, fieldTest.searchLongestSequenceDiagonally(0));

        fieldTest.addCross(0, 0);
        fieldTest.addCross(3, 1);
        fieldTest.addCross(2, 1);
        fieldTest.addCross(2, 2);
        fieldTest.addCross(2, 4);
        assertEquals(3, fieldTest.searchLongestSequenceDiagonally(1));

        logger.info("Test finished");
    }
}