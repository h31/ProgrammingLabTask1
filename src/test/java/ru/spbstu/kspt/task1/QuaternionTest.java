package ru.spbstu.kspt.task1;

import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

class QuaternionTest {

    private static final Logger logger = LogManager.getLogger(QuaternionTest.class);

    private void assertQuaternions(Quaternion q, Quaternion q1, double delta) {
        if ((Math.abs(q.scalar - q1.scalar) >= delta) || (Math.abs(q.vector.x - q1.vector.x) >= delta)
                || (Math.abs(q.vector.y - q1.vector.y) >= delta) || (Math.abs(q.vector.z - q1.vector.z) >= delta)) {
            throw new AssertionError();
        }
    }

    private void assertVectors(Vector3 v, Vector3 v1, double delta) {
        if ((Math.abs(v.x - v1.x) >= delta) || (Math.abs(v.y - v1.y) >= delta)
                || (Math.abs(v.z - v1.z) >= delta)) {
            throw new AssertionError();
        }
    }

    private void assertVectors3d(Vector3D v, Vector3D v1, double delta) {
        if ((Math.abs(v.getX() - v1.getX()) >= delta) || (Math.abs(v.getY() - v1.getY()) >= delta)
                || (Math.abs(v.getZ() - v1.getZ()) >= delta)) {
            throw new AssertionError();
        }
    }

    private void assertWithEtalon(Quaternion q, org.apache.commons.math3.complex.Quaternion q1, double delta) {
        if ((Math.abs(q.scalar - q1.getQ0()) >= delta) || (Math.abs(q.vector.x - q1.getQ1()) >= delta) ||
                (Math.abs(q.vector.y - q1.getQ2()) >= delta) || (Math.abs(q.vector.z - q1.getQ3()) >= delta)) {
            throw new AssertionError();
        }
    }

    @Test
    void add() {
        logger.info("Test on addition of Quaternions has started");
        Quaternion q0 = new Quaternion(new Vector3(0.2, 45.0, 3.2), 10.7);
        Quaternion q1 = new Quaternion(new Vector3(1.0, 20.8, 71.3), 13.2);
        Quaternion q2 = new Quaternion(new Vector3(1.2, 65.8, 74.5), 23.9);
        Quaternion q3 = new Quaternion(new Vector3(2.2, 86.6, 145.8), 37.1);
        org.apache.commons.math3.complex.Quaternion q00 = new org.apache.commons.math3.complex.Quaternion(10.7,
                new double[]{0.2, 45.0, 3.2});
        org.apache.commons.math3.complex.Quaternion q11 = new org.apache.commons.math3.complex.Quaternion(13.2,
                new double[]{1.0, 20.8, 71.3});
        org.apache.commons.math3.complex.Quaternion q22 = new org.apache.commons.math3.complex.Quaternion(23.9,
                new double[]{1.2, 65.8, 74.5});
        org.apache.commons.math3.complex.Quaternion q33 = new org.apache.commons.math3.complex.Quaternion(37.1,
                new double[]{2.2, 86.6, 145.8});
        assertQuaternions(q2, q0.add(q1), 1e-10);
        assertQuaternions(q3, q1.add(q2), 1e-10);
        assertWithEtalon(q2, q00.add(q11), 1e-10);
        assertWithEtalon(q3, q11.add(q22), 1e-10);
        logger.info("Test on addition of Quaternions has finished");
    }

    @Test
    void multiplyOnScalar() {
        logger.info("Test on scalar multiplication has started");
        Quaternion q0 = new Quaternion(new Vector3(36.6, 30.0, 25.2), 6.0);
        Quaternion q1 = new Quaternion(new Vector3(6.1, 5.0, 4.2), 1.0);
        Quaternion q2 = new Quaternion(new Vector3(0.7, -35.7, 22.4), 7.42);
        Quaternion q3 = new Quaternion(new Vector3(0.1, -5.1, 3.2), 1.06);
        org.apache.commons.math3.complex.Quaternion q11 = new org.apache.commons.math3.complex.Quaternion(1.0,
                new double[]{6.1, 5.0, 4.2});
        org.apache.commons.math3.complex.Quaternion q33 = new org.apache.commons.math3.complex.Quaternion(1.06,
                new double[]{0.1, -5.1, 3.2});
        assertQuaternions(q0, q1.multiplyOnScalar(6.0), 1e-10);
        assertQuaternions(q2, q3.multiplyOnScalar(7.0), 1e-10);
        assertWithEtalon(q0, q11.multiply(6.0), 1e-10);
        assertWithEtalon(q2, q33.multiply(7.0), 1e-10);
        logger.info("Test on scalar multiplication has finished");
    }

    @Test
    void getters() {
        logger.info("Test of getters has started");
        Quaternion q = new Quaternion(new Vector3(1.0, 5.2, 8.6), 57.0);
        Quaternion q1 = new Quaternion(new Vector3(-11.0, 5.52, 18.6), -559.4);
        assertEquals(new Vector3(1.0, 5.2, 8.6), q.getVector());
        assertEquals(57.0, q.getScalar());
        assertEquals(new Vector3(-11.0, 5.52, 18.6), q1.getVector());
        assertEquals(-559.4, q1.getScalar());
        logger.info("Test of getters has finished");
    }

    @Test
    void abs() {
        logger.info("Test on abs computation has started");
        assertEquals(4.441175069730982, new Quaternion(new Vector3(1.0, 2.85, 3.256),
                6.987).abs(), 1e-10);
        assertEquals(42.51178777703897, new Quaternion(new Vector3(5.4, -42.11, 2.2),
                -7.9).abs(), 1e-10);
        logger.info("Test on abs computation has finished");
    }

    @Test
    void substract() {
        logger.info("Test on subtraction of Quaternions has started");
        Quaternion q = new Quaternion(new Vector3(4.1, 54.556, 62.3408), 768.7);
        Quaternion q1 = new Quaternion(new Vector3(5.65, 8.756, 75.3258), 854.3);
        Quaternion q2 = new Quaternion(new Vector3(1.55, -45.8, 12.985), 85.6);
        Quaternion q3 = new Quaternion(new Vector3(-2.55, -100.356, -49.3558), -683.1);
        org.apache.commons.math3.complex.Quaternion q00 = new org.apache.commons.math3.complex.Quaternion(768.7,
                new double[]{4.1, 54.556, 62.3408});
        org.apache.commons.math3.complex.Quaternion q11 = new org.apache.commons.math3.complex.Quaternion(854.3,
                new double[]{5.65, 8.756, 75.3258});
        org.apache.commons.math3.complex.Quaternion q22 = new org.apache.commons.math3.complex.Quaternion(85.6,
                new double[]{1.55, -45.8, 12.985});
        assertQuaternions(q, q1.substract(q2), 1e-10);
        assertQuaternions(q3, q2.substract(q), 1e-10);
        assertWithEtalon(q, q11.subtract(q22), 1e-10);
        assertWithEtalon(q3, q22.subtract(q00), 1e-10);
        logger.info("Test on substraction of Quaternions has finished");
    }

    @Test
    void getNorm() {
        logger.info("Test on computing norm of Quaternion has started");
        Quaternion q0 = new Quaternion(new Vector3(55.0, 87.0, 2.0), 7.0);
        Quaternion q1 = new Quaternion(new Vector3(5.0, 41.8, -1.8), 4.0);
        org.apache.commons.math3.complex.Quaternion q00 = new org.apache.commons.math3.complex.Quaternion(7.0,
                new double[]{55.0, 87.0, 2.0});
        org.apache.commons.math3.complex.Quaternion q11 = new org.apache.commons.math3.complex.Quaternion(4.0,
                new double[]{5.0, 41.8, -1.8});
        assertEquals(103.18430113151904, q0.getNorm(), 1e-10);
        assertEquals(42.3258786087188, q1.getNorm(), 1e-10);
        assertEquals(103.18430113151904, q00.getNorm(), 1e-10);
        assertEquals(42.3258786087188, q11.getNorm(), 1e-10);
        logger.info("Test on computing norm of Quaternion has finished");
    }

    @Test
    void normalize() {
        logger.info("Test on computing normalized Quaternion has started");
        Quaternion q0 = new Quaternion(new Vector3(3.0, 1.0, 2.0), -4.0);
        Quaternion q1 = new Quaternion(new Vector3(1.0, 4.0, 1.8), 5.0);
        Quaternion q2 = new Quaternion(new Vector3(0.5477225575051661,
                0.18257418583505536, 0.3651483716701107), -0.7302967433402214);
        Quaternion q3 = new Quaternion(new Vector3(0.14867525836251314,
                0.5947010334500525, 0.26761546505252365), 0.7433762918125657);
        org.apache.commons.math3.complex.Quaternion q00 = new org.apache.commons.math3.complex.Quaternion(-4.0,
                new double[]{3.0, 1.0, 2.0});
        org.apache.commons.math3.complex.Quaternion q11 = new org.apache.commons.math3.complex.Quaternion(5.0,
                new double[]{1.0, 4.0, 1.8});
        assertQuaternions(q2, q0.normalize(), 1e-10);
        assertQuaternions(q3, q1.normalize(), 1e-10);
        assertWithEtalon(q2, q00.normalize(), 1e-10);
        assertWithEtalon(q3, q11.normalize(), 1e-10);
        logger.info("Test on computing normalized Quaternion has finished");
    }

    @Test
    void conjugate() {
        logger.info("Test on computing Quaternion conjugation has started");
        Quaternion q0 = new Quaternion(new Vector3(-123.0, -878.7, -45.2), 78.0);
        Quaternion q1 = new Quaternion(new Vector3(123.0, 878.7, 45.2), 78.0);
        Quaternion q2 = new Quaternion(new Vector3(0.0, 78.7, 45.2), -561.4);
        Quaternion q3 = new Quaternion(new Vector3(0.0, -78.7, -45.2), -561.4);
        org.apache.commons.math3.complex.Quaternion q11 = new org.apache.commons.math3.complex.Quaternion(78.0,
                new double[]{123.0, 878.7, 45.2});
        org.apache.commons.math3.complex.Quaternion q33 = new org.apache.commons.math3.complex.Quaternion(-561.4,
                new double[]{0.0, -78.7, -45.2});
        assertEquals(q0, q1.conjugate());
        assertEquals(q2, q3.conjugate());
        assertWithEtalon(q0, q11.getConjugate(), 1e-10);
        assertWithEtalon(q2, q33.getConjugate(), 1e-10);
        logger.info("Test on computing Quaternion conjugation has finished");
    }

    @Test
    void inverse() {
        logger.info("Test on computing Quaternion invertion has started");
        Quaternion q0 = new Quaternion(new Vector3(-0.033333333333, -0.06666666667, -0.1), 0.133333333333);
        Quaternion q1 = new Quaternion(new Vector3(1.0, 2.0, 3.0), 4.0);
        Quaternion q2 = new Quaternion(new Vector3(0.133333333333, -0.1, 0.066666666667), 0.033333333333);
        Quaternion q3 = new Quaternion(new Vector3(-4.0, 3.0, -2.0), 1.0);
        org.apache.commons.math3.complex.Quaternion q11 = new org.apache.commons.math3.complex.Quaternion(4.0,
                new double[]{1.0, 2.0, 3.0});
        org.apache.commons.math3.complex.Quaternion q33 = new org.apache.commons.math3.complex.Quaternion(1.0,
                new double[]{-4.0, 3.0, -2.0});
        System.out.println(q0);
        System.out.println(q1.inverse());
        assertQuaternions(q0, q1.inverse(), 1e-10);
        assertQuaternions(q2, q3.inverse(), 1e-10);
        assertWithEtalon(q0, q11.getInverse(), 1e-10);
        assertWithEtalon(q2, q33.getInverse(), 1e-10);
        logger.info("Test on computing Quaternion invertion has finished");
    }

    @Test
    void multiply() {
        logger.info("Test on multiplication of Quaternion has started");
        Quaternion q0 = new Quaternion(new Vector3(84.0, 135.0, 87.0), -90.0);
        Quaternion q1 = new Quaternion(new Vector3(1.0, 10.0, 8.0), 15.0);
        Quaternion q2 = new Quaternion(new Vector3(4.0, 6.0, 7.0), 2.0);
        Quaternion q3 = new Quaternion(new Vector3(38.0, -89.0, 67.0), 183.0);
        Quaternion q4 = new Quaternion(new Vector3(11.0, -7.0, 1.0), 14.0);
        Quaternion q5 = new Quaternion(new Vector3(-3.0, 2.0, 4.0), 10.0);
        org.apache.commons.math3.complex.Quaternion q11 = new org.apache.commons.math3.complex.Quaternion(15.0,
                new double[]{1.0, 10.0, 8.0});
        org.apache.commons.math3.complex.Quaternion q22 = new org.apache.commons.math3.complex.Quaternion(2.0,
                new double[]{4.0, 6.0, 7.0});
        org.apache.commons.math3.complex.Quaternion q44 = new org.apache.commons.math3.complex.Quaternion(14.0,
                new double[]{11.0, -7.0, 1.0});
        org.apache.commons.math3.complex.Quaternion q55 = new org.apache.commons.math3.complex.Quaternion(10.0,
                new double[]{-3.0, 2.0, 4.0});
        assertQuaternions(q0, q1.multiply(q2), 1e-10);
        assertQuaternions(q3, q4.multiply(q5), 1e-10);
        assertWithEtalon(q0, q11.multiply(q22), 1e-10);
        assertWithEtalon(q3, q44.multiply(q55), 1e-10);
        logger.info("Test on multiplication of Quaternion has finished");
    }

    @Test
    void getQuaternionByAxisAndAngle() {
        logger.info("Test on getting Quaternion by axis and angle has started");
        Quaternion q1 = new Quaternion(new Vector3(-0.707106781186, -0.0, -0.0), 0.707106781186);
        Quaternion q2 = new Quaternion(new Vector3(-0.0, 1.0, -0.0), 0.0);
        Quaternion q3 = new Quaternion(PI / 2, new Vector3(1.0, 0.0, 0.0));
        Quaternion q4 = new Quaternion(PI, new Vector3(0.0, -1.0, 0.0));
        Rotation r1 = new Rotation(new Vector3D(1.0, 0.0, 0.0), PI / 2, RotationConvention.VECTOR_OPERATOR);
        org.apache.commons.math3.complex.Quaternion q33 = new org.apache.commons.math3.complex.Quaternion(r1.getQ0(),
                new double[]{r1.getQ1(), r1.getQ2(), r1.getQ3()});
        Rotation r2 = new Rotation(new Vector3D(0.0, -1.0, 0.0), PI, RotationConvention.VECTOR_OPERATOR);
        org.apache.commons.math3.complex.Quaternion q44 = new org.apache.commons.math3.complex.Quaternion(r2.getQ0(),
                new double[]{r2.getQ1(), r2.getQ2(), r2.getQ3()});
        assertWithEtalon(q1, q33, 1e-10);
        assertWithEtalon(q2, q44, 1e-10);
        assertQuaternions(q1, q3, 1e-10);
        assertQuaternions(q2, q4, 1e-10);
        logger.info("Test on getting Quaternion by axis and angle has finished");
    }


    @Test
    void determineAngle() {
        logger.info("Test on angle determination has started");
        Quaternion q0 = new Quaternion(new Vector3(1.0, 1.0, 1.0), 1.0);
        Quaternion q1 = new Quaternion(new Vector3(-2.0, 1.0, 4.0), 2.0);
        Quaternion q2 = new Quaternion(new Vector3(-1.0, -1.0, 1.0), -1.0);
        Quaternion q3 = new Quaternion(new Vector3(0.7071, 0.0, 0.0), 0.7071);
        Rotation r0 = new Rotation(1.0, 1.0, 1.0, 1.0, true);
        Rotation r1 = new Rotation(2.0, -2.0, 1.0, 4.0, true);
        Rotation r2 = new Rotation(-1.0, -1.0, -1.0, 1.0, true);
        Rotation r3 = new Rotation(0.7071, 0.7071, 0.0, 0.0, true);
        assertEquals((2.0 * PI) / 3.0, q0.determineAngle(), 1e-10);
        assertEquals(2.318558961454817, q1.determineAngle(), 1e-10);
        assertEquals((2.0 * PI) / 3.0, q2.determineAngle(), 1e-10);
        assertEquals(PI / 2.0, q3.determineAngle(), 1e-10);
        assertEquals((2.0 * PI) / 3.0, r0.getAngle(), 1e-10);
        assertEquals(2.318558961454817, r1.getAngle(), 1e-10);
        assertEquals((2.0 * PI) / 3.0, r2.getAngle(), 1e-10);
        assertEquals(PI / 2.0, r3.getAngle(), 1e-10);
        logger.info("Test on angle determination has finished");
    }

    @Test
    void determineAxis() {
        logger.info("Test on axis determination has started");
        Quaternion q0 = new Quaternion(new Vector3(1.0, 1.0, 1.0), 1.0);
        Quaternion q1 = new Quaternion(new Vector3(-2.0, 2.0, -4.0), 1.0);
        Quaternion q2 = new Quaternion(new Vector3(0.7071, 0.0, 0.0), 0.7071);
        Rotation r0 = new Rotation(1.0, 1.0, 1.0, 1.0, true);
        Rotation r1 = new Rotation(1.0, -2.0, 2.0, -4.0, true);
        Rotation r2 = new Rotation(0.7071, 0.7071, 0.0, 0.0, true);
        assertVectors(new Vector3(-0.5773502692, -0.5773502692, -0.5773502692), q0.determineAxis(), 1e-10);
        assertVectors(new Vector3(0.4082482905, -0.4082482905, 0.8164965809), q1.determineAxis(), 1e-10);
        assertVectors(new Vector3(-1.0, -0.0, -0.0), q2.determineAxis(), 1e-10);
        assertVectors3d(new Vector3D(-0.5773502692, -0.5773502692, -0.5773502692),
                r0.getAxis(RotationConvention.VECTOR_OPERATOR), 1e-10);
        assertVectors3d(new Vector3D(0.4082482905, -0.4082482905, 0.8164965809),
                r1.getAxis(RotationConvention.VECTOR_OPERATOR), 1e-10);
        assertVectors3d(new Vector3D(-1.0, -0.0, -0.0),
                r2.getAxis(RotationConvention.VECTOR_OPERATOR), 1e-10);
        logger.info("Test on axis determination has finished");
    }
}