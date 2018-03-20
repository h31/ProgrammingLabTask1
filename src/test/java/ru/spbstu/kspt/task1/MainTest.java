package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task1Graph.Graph;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static final Logger logger = LogManager.getLogger(MainTest.class);
    Graph g = new Graph();

    @Test
    void exampleTest() {
        logger.info("Test started");
        assertEquals(10, 10);
        logger.info("Test finished");
    }

    int s = g.getVertices().size();

    @Test
    void addVertexTest() {
        logger.info("Test started");
        g.addVertex("H");
        assertEquals(s + 1, g.getVertices().size());
        logger.info("Test finished");
    }

    @Test
    void deleteVertexTest() {
        logger.info("Test started");
        logger.info(s);
        logger.info(g.getArcs().size());
        //g.deleteVertex("A");
        logger.info(s);
        assertEquals(s - 1, g.getVertices().size());
        logger.info("Test finished");
    }

    @Test
    void addArcTest() {
        logger.info("Test started");
        Graph g = new Graph();
        logger.info(g);
        int s = g.getArcs().size();
        logger.info(s);
        g.addArc("BA", 25, "B", "A");
        logger.info(s);
        assertEquals(s + 1, g.getArcs().size());
        logger.info("Test finished");
    }

    @Test
    void deleteArcTest() {
        logger.info("Test started");
        Graph g = new Graph();
        logger.info(g);
        int s = g.getArcs().size();
        logger.info(s);
        g.deleteArc("AB");
        logger.info(s);
        assertEquals(s - 1, g.getArcs().size());
        logger.info("Test finished");
    }

    @Test
    void changeVertexName() {
        logger.info("Test started");
        Graph g = new Graph();
        g.changeVertexName("EC", "EtoC");
        assertEquals(1, g.getArcs().size());
        logger.info("Test finished");
    }
}
