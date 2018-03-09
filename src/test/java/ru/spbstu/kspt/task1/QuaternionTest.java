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
        logger.info("Test on addition of Quaternions has started");
        Quaternion q = new Quaternion(new Point(0.2, 45.0, 3.2), 10.7);
        Quaternion q1 = new Quaternion(new Point(1.0, 20.8, 71.3), 13.2);
        Quaternion q2 = new Quaternion(new Point(1.2, 65.8, 74.5), 23.9);
        Quaternion q3 = new Quaternion(new Point(2.2, 86.6, 145.8), 37.1);
        assertEquals(q2,q.plus(q1));
        assertEquals(q3,q1.plus(q2));
        logger.info("Test on addition of Quaternions has finished");
    }

    @Test
    void scalarMultiplication() {
        logger.info("Test on scalar multiplication has started");
        assertEquals(new Quaternion(new Point(36.6, 30.0, 25.2), 6.0),
                new Quaternion(new Point(6.1, 5.0, 4.2), 1.0).scalarMultiplication(6.0));
        assertEquals(new Quaternion(new Point(0.7, -35.7, 22.4), 7.42),
                new Quaternion(new Point(0.1, -5.1, 3.2), 1.06).scalarMultiplication(7.0));
        logger.info("Test on scalar multiplication has finished");
    }

    @Test
    void getters() {
        logger.info("Test of getters has started");
        Quaternion q = new Quaternion(new Point(1.0, 5.2, 8.6), 57.0);
        Quaternion q1 = new Quaternion(new Point(-11.0, 5.52, 18.6), -559.4);
        assertEquals(new Point(1.0, 5.2, 8.6), q.getVector());
        assertEquals(57.0, q.getScalar());
        assertEquals(new Point(-11.0, 5.52, 18.6), q1.getVector());
        assertEquals(-559.4, q1.getScalar());
        logger.info("Test of getters has finished");
    }

    @Test
    void module() {
        logger.info("Test on module computation has started");
        assertEquals(8.279021983302133, new Quaternion(new Point(1.0, 2.85, 3.256),
                        6.987 ).module());
        assertEquals(43.23958949851397, new Quaternion(new Point(5.4, -42.11, 2.2),
                -7.9 ).module());
        logger.info("Test on module computation has finished");
    }

    @Test
    void minus() {
        logger.info("Test on subtraction of Quaternions has started");
        Quaternion q = new Quaternion(new Point(4.1, 54.556, 62.3408), 768.7);
        Quaternion q1 = new Quaternion(new Point(5.65, 8.756, 75.3258), 854.3);
        Quaternion q2 = new Quaternion(new Point(1.55, -45.8, 12.985), 85.6);
        Quaternion q3 = new Quaternion(new Point(-2.55, -100.356, -49.3558), -683.1);
        assertEquals(q,q1.minus(q2));
        assertEquals(q3,q2.minus(q));
        logger.info("Test on substraction of Quaternions has finished");
    }

    @Test
    void norm() {
        logger.info("Test on computing norm of Quaternion has started");
        assertEquals(10647.0, new Quaternion(new Point(55.0, 87.0, 2.0), 7.0).norm());
        assertEquals(1791.48, new Quaternion(new Point(5.0, 41.8, -1.8), 4.0).norm());
        logger.info("Test on computing norm of Quaternion has finished");
    }

    @Test
    void conjugate() {
        logger.info("Test on computing Quaternion conjugation has started");
        assertEquals( new Quaternion(new Point(-123.0, -878.7, -45.2), 78.0),
                new Quaternion(new Point(123.0, 878.7, 45.2), 78.0).conjugate());
        assertEquals( new Quaternion (new Point(0.0, 78.7, 45.2), -561.4),
                new Quaternion(new Point(0.0, -78.7, -45.2), -561.4).conjugate());
        logger.info("Test on computing Quaternion conjugation has finished");
    }

    @Test
    void inverse() {
        logger.info("Test on computing Quaternion invertion has started");
        assertEquals(new Quaternion(new Point(-0.033333333, -0.066666667, -0.1), 0.133333333),
                new Quaternion(new Point(1.0, 2.0, 3.0), 4.0).inverse());
        assertEquals(new Quaternion(new Point(0.133333333, -0.1, 0.066666667), 0.033333333),
                new Quaternion(new Point(-4.0, 3.0, -2.0), 1.0).inverse());
        logger.info("Test on computing Quaternion invertion has finished");
    }

    @Test
    void multiplication() {
        logger.info("Test on multiplication of Quaternion has started");
        assertEquals(new Quaternion(new Point(84.0, 135.0, 87.0),-90.0),
                new Quaternion(new Point(1.0, 10.0, 8.0),15.0 )
                        .multiply(new Quaternion(new Point(4.0, 6.0, 7.0), 2.0)));
        assertEquals(new Quaternion(new Point(38.0, -89.0, 67.0),183.0),
                new Quaternion(new Point(11.0, -7.0, 1.0),14.0 )
                        .multiply(new Quaternion(new Point(-3.0, 2.0, 4.0), 10.0)));
        logger.info("Test on multiplication of Quaternion has finished");
    }

    @Test
    void getQuaternionByAxisAndAngle() {
        logger.info("Test on getting Quaternion by axis and angle has started");
        Quaternion q1 = new Quaternion(new Point(0.707106781, 0.0, 0.0), 0.707106781);
        Quaternion q2 = new Quaternion(new Point(0.0, -1.0, 0.0), 0.0);
        Quaternion q11 = new Quaternion(PI / 2, new Point(1.0, 0.0, 0.0));
        Quaternion q22 = new Quaternion(PI, new Point(0.0, -1.0, 0.0));
        assertEquals(q1, q11);
        assertEquals(q2, q22);
        logger.info("Test on getting Quaternion by axis and angle has finished");
    }


   @Test
    void determineAngle() {
       logger.info("Test on angle determination has started");
       Quaternion q = new Quaternion(new Point(1.0, 1.0, 1.0), 1.0);
       Quaternion q1 = new Quaternion(new Point(-2.0, 1.0, 4.0), 2.0);
       Quaternion q2 = new Quaternion(new Point(-1.0, -1.0, 1.0), -1.0);
       Quaternion q3 = new Quaternion(new Point(0.7071, 0.0, 0.0), 0.7071);
       assertEquals((2.0 * PI) / 3.0, q.determineAngle(), 1e-10);
       assertEquals(2.318558961454817, q1.determineAngle(), 1e-10);
       assertEquals((4.0 * PI) / 3.0, q2.determineAngle(), 1e-10);
       assertEquals(PI / 2.0, q3.determineAngle());
       logger.info("Test on angle determination has finished");
   }

   @Test
    void determineAxis() {
       logger.info("Test on axis determination has started");
       Quaternion q = new Quaternion(new Point(1.0, 1.0, 1.0), 1.0);
       Quaternion q2 = new Quaternion(new Point(-2.0, 2.0, -4.0), 1.0);
       Quaternion q3 = new Quaternion(new Point(0.7071, 0.0, 0.0), 0.7071);
       assertEquals(new Point(0.5, 0.5, 0.5), q.determineAxis());
       assertEquals(new Point(-0.4, 0.4, -0.8), q2.determineAxis());
       assertEquals(new Point(0.707106781, 0.0, 0.0), q3.determineAxis());
       logger.info("Test on axis determination has finished");
   }
}