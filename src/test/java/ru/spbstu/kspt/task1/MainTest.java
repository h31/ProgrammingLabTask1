package ru.spbstu.kspt.task1;

import myClass.Cube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    private static final Logger logger = LogManager.getLogger(MainTest.class);

    @Test
    void exampleTest() {
        logger.info("Test started");
        assertEquals(10, 10);
        logger.info("Test finished");
    }
}

class testCube {

    Cube result = new Cube(3);
    Cube actual = new Cube(3);

    @Test
    public void rotateUp() {
        result.RotateUp();
        assertArrayEquals(result.cube[0], actual.cube[2]);
        assertArrayEquals(result.cube[2], actual.cube[4]);
        assertArrayEquals(result.cube[4], actual.cube[5]);
        assertArrayEquals(result.cube[5], actual.cube[0]);
    }

    @Test
    void rotateRight() {
        result.RotateRight();
        assertArrayEquals(result.cube[1], actual.cube[5]);
        assertArrayEquals(result.cube[2], actual.cube[1]);
        assertArrayEquals(result.cube[3], actual.cube[2]);
        assertArrayEquals(result.cube[5], actual.cube[3]);
    }

    @Test
    public void rotateDown() {
        result.RotateDown();
        assertArrayEquals(result.cube[0], actual.cube[5]);
        assertArrayEquals(result.cube[2], actual.cube[0]);
        assertArrayEquals(result.cube[4], actual.cube[2]);
        assertArrayEquals(result.cube[5], actual.cube[4]);
    }

    @Test
    void rotateLeft() {
        result.RotateLeft();
        assertArrayEquals(result.cube[5], actual.cube[1]);
        assertArrayEquals(result.cube[1], actual.cube[2]);
        assertArrayEquals(result.cube[2], actual.cube[3]);
        assertArrayEquals(result.cube[3], actual.cube[5]);
    }
}
