package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.jupiter.api.Assertions.*;


class QuaternionTest {
    private static final Logger logger = LogManager.getLogger(QuaternionTest.class);

    private void assertQuaternion(Quaternion q, Quaternion p, double delta){
      if (Math.abs(q.a - p.a) >= delta || Math.abs(q.b - p.b) >= delta ||
          Math.abs(q.c - p.c) >= delta || Math.abs(q.d - p.d) >= delta)
          throw new AssertionError();
    }

    private void assertQuaternion(Quaternion q, Quaternion p){
        assertQuaternion(q, p, 1e-4);
    }

    @Test
    void abs(){
        assertEquals( 8.6023, new Quaternion(2.0, 3.0, 5.0, 6.0).abs(), 1e-4);
        assertEquals(9.6700, new Quaternion(2.1, 3.5, 4.7, 7.4).abs(),1e-4);
        assertEquals(8.7100, new Quaternion(2.25,3.86,4.92,5.63).abs(),1e-4);
    }

    @Test
    void conjugate(){
        assertEquals(new Quaternion(2.0, -3.0, -4.0, -5.0), new Quaternion(2.0, 3.0, 4.0, 5.0).conjugate());
        assertEquals(new Quaternion (5.68, -3.73, -7.92, -3.98), new Quaternion (5.68, 3.73, 7.92, 3.98).conjugate());
    }

    @Test
    void plus(){
        Quaternion q = new Quaternion(2.0, 3.0, 4.0, 5.0);
        Quaternion p = new Quaternion (3.0, 4.0, 5.0, 6.0);
        Quaternion l = new Quaternion (5.0, 7.0, 9.0, 11.0);
        assertEquals(l, q.plus(q, p));
    }

    @Test
    void minus() {
        Quaternion q = new Quaternion(2.0, 3.0, 4.0, 5.0);
        Quaternion p = new Quaternion(3.0, 4.0, 5.0, 6.0);
        Quaternion l = new Quaternion(-1.0, -1.0, -1.0, -1.0);
        assertEquals(l, q.minus(q, p));
    }

    @Test
    void multConst(){
        Quaternion q = new Quaternion(2.0, 3.0, 4.0, 5.0);
        Quaternion l = new Quaternion(8.0, 12.0, 16.0, 20.0);
        double p = 4.0;
        assertEquals(l, q.multConst(q, p));
    }

    @Test
    void mult(){
        Quaternion q = new Quaternion(2.0, 3.0, 4.0, 5.0);
        Quaternion p = new Quaternion(3.0, 4.0, 5.0, 6.0);
        Quaternion l = new Quaternion(-56.0, 16.0, 24.0, 26.0);
        assertEquals(l, q.mult(q, p));
        }

    @Test
    void divide(){
        Quaternion q = new Quaternion(2.0, 3.0, 4.0, 5.0);
        double p = 2.0;
        assertEquals(new Quaternion (1.0, 1.5, 2.0, 2.5), q.divide(q, p));
    }

    @Test
    void angleDetermination(){
       Quaternion q = new Quaternion(2.0, 4.0, 3.0, 5.0);
       assertEquals(0.7610, q.angleDetermination(q), 1e-4);

    }
}
