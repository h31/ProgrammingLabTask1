package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeFieldTest {
    private static final Logger logger = LogManager.getLogger(TicTacToeFieldTest.class);

    @Test
    void standartTest() {
        logger.info("Test started");

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

        StringBuilder coordinates = new StringBuilder();
        for (CellPosition cell : testField.longestCrossSequence()) {
            coordinates.append(cell.toString());
        }

        assertEquals("[0,0][2,2]", coordinates.toString());

        logger.info("Final Field: \n" + testField.toString());
        logger.info("Test finished");
    }

    @Test
    void diagonalTest() {
        logger.info("Diagonal Test started");

        TicTacToeField testField = new TicTacToeField(4);

        testField.addCross(3, 0);
        testField.addCross(2, 1);
        assertEquals(2, testField.longestCrossSequenceSize());

        testField.addCross(3, 2);
        assertEquals(2, testField.longestCrossSequenceSize());

        testField.addCross(1, 2);
        testField.addCross(0, 3);
        assertEquals(4, testField.longestCrossSequenceSize());

        logger.info("Final Field: \n" + testField.toString());
        logger.info("Diagonal Test finished");
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

        logger.info("Final Field: \n" + testField.toString());
        logger.info("Big Test finished");
    }
}
