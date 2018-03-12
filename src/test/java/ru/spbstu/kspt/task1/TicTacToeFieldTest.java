package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TicTacToeFieldTest {
    private static final Logger logger = LogManager.getLogger(TicTacToeFieldTest.class);

    @Test
    void standartTest() {
        logger.info("Standart Test started");

        TicTacToeField testField = new TicTacToeField(3);

        assertEquals(0, testField.longestNoughtSequenceSize());

        testField.addCross(0, 0);
        testField.addCross(1, 1);
        testField.addCross(2, 2);
        assertEquals(3, testField.longestCrossSequenceSize());

        testField.addNought(2, 0);
        testField.addNought(2, 1);
        assertEquals(2, testField.longestNoughtSequenceSize());

        testField.clear(1, 1);
        assertEquals(1, testField.longestCrossSequenceSize());

        testField.addCross(1, 1);

        assertEquals("[0,0][2,2]", testField.longestCrossSequence().toString());
        assertEquals("[1,1]", testField.longestCrossSequence().getDirection().toString());

        TicTacToeField otherField = new TicTacToeField(3);
        otherField.addCross(0, 0);
        otherField.addCross(1, 1);
        otherField.addCross(2, 2);
        assertNotEquals(testField, otherField);

        otherField.addNought(2, 0);
        otherField.addNought(2, 1);
        assertEquals(testField, otherField);

        logger.info("Final Field: \n" + testField.toString());
        logger.info("Standart Test finished");
    }

    @Test
    void sequenceTest() {
        logger.info("Sequence Test started");

        TicTacToeField testField = new TicTacToeField(4);

        testField.addCross(3, 0);
        testField.addCross(2, 1);
        testField.addCross(1, 2);
        testField.addCross(0, 3);

        testField.addCross(2, 0);
        testField.addCross(1, 1);
        testField.addCross(0, 2);
        assertEquals(4, testField.longestCrossSequenceSize());

        testField.clear(2, 1);
        assertEquals(3, testField.longestCrossSequenceSize());

        testField.clear(1, 1);
        testField.addNought(3, 1);
        testField.addCross(3, 2);
        assertEquals(2, testField.longestCrossSequenceSize());

        testField.clear(3, 1);
        testField.addCross(3, 1);
        assertEquals(3, testField.longestCrossSequenceSize());

        testField.addCross(2, 2);
        assertEquals(4, testField.longestCrossSequenceSize());

        logger.info("Final Field: \n" + testField.toString());
        logger.info("Sequence Test finished");
    }

    @Test
    void bigTest() {
        logger.info("Big Test started");

        TicTacToeField testField = new TicTacToeField(1000);
        for (int i = 0; i < 1000; i++) {
            testField.addCross(i, i);
            for (int k = 0; k < 1000; k++) {
                if (i == 999) break;
                testField.addNought(i + i % 2, k);
            }
        }

        assertEquals(1000, testField.longestNoughtSequenceSize());
        assertEquals(1, testField.longestCrossSequenceSize());

        logger.debug("Final Field: \n" + testField.toString());
        logger.info("Big Test finished");
    }
}
