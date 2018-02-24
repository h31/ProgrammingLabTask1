package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static final Logger logger = LogManager.getLogger(MainTest.class);


    @Test
    void plus() {
        Main.Quaternion q = new Main.Quaternion(new Main.Point(0.2, 45.0, 3.2), 10.7);
        Main.Quaternion q1 = new Main.Quaternion(new Main.Point(1.0, 20.8, 71.3), 13.2);
        Main.Quaternion q2 = new Main.Quaternion(new Main.Point(1.2, 65.8, 74.5), 23.9);
        assertEquals(q2,q.plus(q1));
    }

    @Test
    void scalarMultiplication() {
        assertEquals(new Main.Quaternion(new Main.Point(36.6, 30.0, 25.2), 6.0),
                new Main.Quaternion(new Main.Point(6.1, 5.0, 4.2), 1.0).scalarMultiplication(6.0));
    }

    @Test
    void getters() {
        Main.Quaternion q = new Main.Quaternion(new Main.Point(1.0, 5.2, 8.6), 57.0);
        assertEquals(new Main.Point(1.0, 5.2, 8.6), q.getVector());
        assertEquals(57.0, q.getScalar());
    }

    @Test
    void module() {
        assertEquals(8.279021983302133, new Main.Quaternion(new Main.Point(1.0, 2.85, 3.256),
                        6.987 ).module());
    }

    @Test
    void minus() {
        assertEquals(new Main.Quaternion(new Main.Point(4.1, 54.556, 62.3408), 768.7),
                new Main.Quaternion(new Main.Point(5.65, 8.756, 75.3258), 854.3)
                .minus(new Main.Quaternion(new Main.Point(1.55, -45.8, 12.985), 85.6)));
    }

    @Test
    void norm() {
        assertEquals(new Main.Quaternion(new Main.Point(3025.0, 7590.417129, 6.0025), 55.621764),
                new Main.Quaternion(new Main.Point(55.0, 87.123, 2.45), 7.458).norm());
    }

    @Test
    void conjugate() {
        assertEquals( new Main.Quaternion(new Main.Point(-123.0, -878.7, -45.2), 78.0),
                new Main.Quaternion(new Main.Point(123.0, 878.7, 45.2), 78.0).conjugate());
    }

    @Test
    void reciprotical() {
        assertEquals(new Main.Quaternion(new Main.Point(-0.033333333, -0.066666667, -0.1), 0.133333333),
                new Main.Quaternion(new Main.Point(1.0, 2.0, 3.0), 4.0).reciprocal());
    }

    @Test
    void multiplication() {
        assertEquals(new Main.Quaternion(new Main.Point(84.0, 135.0, 87.0),-90.0),
                new Main.Quaternion(new Main.Point(1.0, 10.0, 8.0),15.0 )
                        .multiply(new Main.Quaternion(new Main.Point(4.0, 6.0, 7.0), 2.0)));
    }

}
