package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacFieldTest {
    private static final Logger logger = LogManager.getLogger(TicTacFieldTest.class);

    @Test
    void standartTest() {
        logger.info("Test started");

        TicTacField testField = new TicTacField(3);
        testField.addCross(0, 0);
        testField.addCross(1, 1);
        testField.addCross(2, 2);
        testField.clear(1, 1);
        testField.addNought(2, 0);
        testField.addNought(2, 1);

        assertEquals(1, testField.longestCrossSequenceSize());
        assertEquals(2, testField.longestNoughtSequenceSize());

        testField.addCross(1, 1);

        assertEquals(3, testField.longestCrossSequenceSize());

        StringBuilder coordinates = new StringBuilder();
        for (Cell cell : testField.longestCrossSequence()) {
            coordinates.append(cell.toString());
        }

        assertEquals("[0,0][1,1][2,2]", coordinates.toString());

        logger.info("Final Field: \n" + testField.toString());
        logger.info("Test finished");
    }

    @Test
    void bigTest() {
        logger.info("Test started");

        TicTacField testField = new TicTacField(1000);
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
        logger.info("Test finished");
    }
}
