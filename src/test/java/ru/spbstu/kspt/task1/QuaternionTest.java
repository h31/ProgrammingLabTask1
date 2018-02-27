package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

class QuaternionTest {
    private static final Logger logger = LogManager.getLogger(QuaternionTest.class);

    @Test
    void plus() {
        Quaternion q = new Quaternion(new Quaternion.Point(0.2, 45.0, 3.2), 10.7);
        Quaternion q1 = new Quaternion(new Quaternion.Point(1.0, 20.8, 71.3), 13.2);
        Quaternion q2 = new Quaternion(new Quaternion.Point(1.2, 65.8, 74.5), 23.9);
        Quaternion q3 = new Quaternion(new Quaternion.Point(2.2, 86.6, 145.8), 37.1);
        assertEquals(q2,q.plus(q1));
        assertEquals(q3,q1.plus(q2));
    }

    @Test
    void scalarMultiplication() {
        assertEquals(new Quaternion(new Quaternion.Point(36.6, 30.0, 25.2), 6.0),
                new Quaternion(new Quaternion.Point(6.1, 5.0, 4.2), 1.0).scalarMultiplication(6.0));
        assertEquals(new Quaternion(new Quaternion.Point(0.7, -35.7, 22.4), 7.42),
                new Quaternion(new Quaternion.Point(0.1, -5.1, 3.2), 1.06).scalarMultiplication(7.0));
    }

    @Test
    void getters() {
        Quaternion q = new Quaternion(new Quaternion.Point(1.0, 5.2, 8.6), 57.0);
        Quaternion q1 = new Quaternion(new Quaternion.Point(-11.0, 5.52, 18.6), -559.4);
        assertEquals(new Quaternion.Point(1.0, 5.2, 8.6), q.getVector());
        assertEquals(57.0, q.getScalar());
        assertEquals(new Quaternion.Point(-11.0, 5.52, 18.6), q1.getVector());
        assertEquals(-559.4, q1.getScalar());
    }

    @Test
    void module() {
        assertEquals(8.279021983302133, new Quaternion(new Quaternion.Point(1.0, 2.85, 3.256),
                        6.987 ).module());
        assertEquals(43.23958949851397, new Quaternion(new Quaternion.Point(5.4, -42.11, 2.2),
                -7.9 ).module());
    }

    @Test
    void minus() {
        Quaternion q = new Quaternion(new Quaternion.Point(4.1, 54.556, 62.3408), 768.7);
        Quaternion q1 = new Quaternion(new Quaternion.Point(5.65, 8.756, 75.3258), 854.3);
        Quaternion q2 = new Quaternion(new Quaternion.Point(1.55, -45.8, 12.985), 85.6);
        Quaternion q3 = new Quaternion(new Quaternion.Point(-2.55, -100.356, -49.3558), -683.1);
        assertEquals(q,q1.minus(q2));
        assertEquals(q3,q2.minus(q));
    }

    @Test
    void norm() {
        assertEquals(10647.0, new Quaternion(new Quaternion.Point(55.0, 87.0, 2.0), 7.0).norm());
        assertEquals(1791.48, new Quaternion(new Quaternion.Point(5.0, 41.8, -1.8), 4.0).norm());
    }

    @Test
    void conjugate() {
        assertEquals( new Quaternion(new Quaternion.Point(-123.0, -878.7, -45.2), 78.0),
                new Quaternion(new Quaternion.Point(123.0, 878.7, 45.2), 78.0).conjugate());
        assertEquals( new Quaternion (new Quaternion.Point(0.0, 78.7, 45.2), -561.4),
                new Quaternion(new Quaternion.Point(0.0, -78.7, -45.2), -561.4).conjugate());
    }

    @Test
    void inverse() {
        assertEquals(new Quaternion(new Quaternion.Point(-0.033333333, -0.066666667, -0.1), 0.133333333),
                new Quaternion(new Quaternion.Point(1.0, 2.0, 3.0), 4.0).inverse());
        assertEquals(new Quaternion(new Quaternion.Point(0.133333333, -0.1, 0.066666667), 0.033333333),
                new Quaternion(new Quaternion.Point(-4.0, 3.0, -2.0), 1.0).inverse());
    }

    @Test
    void multiplication() {
        assertEquals(new Quaternion(new Quaternion.Point(84.0, 135.0, 87.0),-90.0),
                new Quaternion(new Quaternion.Point(1.0, 10.0, 8.0),15.0 )
                        .multiply(new Quaternion(new Quaternion.Point(4.0, 6.0, 7.0), 2.0)));
        assertEquals(new Quaternion(new Quaternion.Point(38.0, -89.0, 67.0),183.0),
                new Quaternion(new Quaternion.Point(11.0, -7.0, 1.0),14.0 )
                        .multiply(new Quaternion(new Quaternion.Point(-3.0, 2.0, 4.0), 10.0)));
    }

    @Test
    void getQuaternionByAxisAndAngle() {
        Quaternion q = new Quaternion(new Quaternion.Point(0.707106781, 0.0, 0.0), 0.707106781);
        Quaternion q1 = new Quaternion(new Quaternion.Point(0.0, -1.0, 0.0), 0.0);
        assertEquals(q, Quaternion.getQuaternionByAxisAndAngle(new Quaternion.Point(1.0, 0.0, 0.0), PI / 2.0));
        assertEquals(q1, Quaternion.getQuaternionByAxisAndAngle(new Quaternion.Point(0.0, -1.0, 0.0), PI ));
    }


   @Test
    void determineAngle() {
       Quaternion q = new Quaternion(new Quaternion.Point(1.0, 1.0, 1.0), 1.0);
       Quaternion q1 = new Quaternion(new Quaternion.Point(-2.0, 1.0, 4.0), 2.0);
       Quaternion q2 = new Quaternion(new Quaternion.Point(-1.0, -1.0, 1.0), -1.0);
       Quaternion q3 = new Quaternion(new Quaternion.Point(0.7071, 0.0, 0.0), 0.7071);
       assertEquals((2.0 * PI) / 3.0, Quaternion.determineAngle(q), 1e-10);
       assertEquals(2.318558961454817, Quaternion.determineAngle(q1), 1e-10);
       assertEquals((4.0 * PI) / 3.0, Quaternion.determineAngle(q2), 1e-10);
       assertEquals(PI / 2.0, Quaternion.determineAngle(q3));
   }

   @Test
    void determineAxis() {
       Quaternion q = new Quaternion(new Quaternion.Point(1.0, 1.0, 1.0), 1.0);
       Quaternion q2 = new Quaternion(new Quaternion.Point(-2.0, 2.0, -4.0), 1.0);
       Quaternion q3 = new Quaternion(new Quaternion.Point(0.7071, 0.0, 0.0), 0.7071);
       assertEquals(new Quaternion.Point(0.5, 0.5, 0.5), Quaternion.determineAxis(q));
       assertEquals(new Quaternion.Point(-0.4, 0.4, -0.8), Quaternion.determineAxis(q2));
       assertEquals(new Quaternion.Point(0.707106781, 0.0, 0.0), Quaternion.determineAxis(q3));
   }
}