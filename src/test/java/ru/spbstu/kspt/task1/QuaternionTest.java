package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.jupiter.api.Assertions.*;


class QuaternionTest {
    private static final Logger logger = LogManager.getLogger(QuaternionTest.class);

    @Test
    void abs(){
        assertEquals( 8.602325267042627, new Quaternion(2.0, 3.0, 5.0, 6.0).abs());
        assertEquals(9.670056876771719, new Quaternion(2.1, 3.5, 4.7, 7.4).abs());
        assertEquals(8.710074626545975, new Quaternion(2.25,3.86,4.92,5.63).abs());
    }

    @Test
    void conjugate(){
        assertEquals(new Quaternion(2.0, -3.0, -4.0, -5.0), new Quaternion(2.0, 3.0, 4.0, 5.0).conjugate());
        assertEquals(new Quaternion (5.68, -3.73, -7.92, -3.98), new Quaternion (5.68, 3.73, 7.92, 3.98).conjugate());
    }
}
