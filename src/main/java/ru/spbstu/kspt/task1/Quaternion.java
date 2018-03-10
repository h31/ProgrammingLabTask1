package ru.spbstu.kspt.task1;

import org.apache.commons.math3.util.FastMath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.*;

/**
 * Quaternion class
 */

public class Quaternion implements QuaternionInterface {

    private static final Logger logger = LogManager.getLogger(ru.spbstu.kspt.task1.Quaternion.class.getName());

    public Vector3 vector;

    public double scalar;

    Quaternion(Vector3 vector, double scalar) {
        this.vector = vector;
        this.scalar = scalar;
        logger.debug("Quaternion value is " + this);
    }

    Quaternion(double angle, Vector3 axis) {
        Vector3 vector = axis.normalize();
        double scalar = cos(angle / 2.0);
        double x = vector.x * sin(angle / 2.0);
        double y = vector.y * sin(angle / 2.0);
        double z = vector.z * sin(angle / 2.0);
        this.vector = new Vector3(x, y, z).inverse();
        this.scalar = scalar;
        logger.debug("Quaternion value is " + this);
    }

    public Vector3 getVector() {
        return vector;
    }

    public double getScalar() {
        return scalar;
    }

    public Quaternion multiplyOnScalar(double scalar1) {
        return new Quaternion(new Vector3(
                scalar1 * vector.x,
                scalar1 * vector.y,
                scalar1 * vector.z
        ),
                scalar1 * this.scalar);
    }

    public Quaternion conjugate() {
        return new Quaternion(new Vector3(-vector.x, -vector.y, -vector.z), scalar);
    }

    public double abs() {
        return sqrt(pow(vector.x, 2.0) + pow(vector.y, 2.0) + pow(vector.z, 2.0));
    }

    public Quaternion add(Quaternion other) {
        return new Quaternion(vector.add(other.vector), scalar + other.scalar);
    }

    public Quaternion substract(Quaternion other) {
        return new Quaternion(vector.substract(other.vector), scalar - other.scalar);
    }

    public Quaternion inverse() {
        return this.conjugate().multiplyOnScalar(1 / pow(this.getNorm(), 2.0));
    }

    public double getNorm() {
        return sqrt(vector.x * vector.x + vector.y * vector.y + vector.z * vector.z + scalar * scalar);
    }

    public Quaternion normalize() {
        double norm = this.getNorm();
        return new Quaternion(
                new Vector3(vector.x / norm, vector.y / norm, vector.z / norm), scalar / norm);
    }

    public Quaternion multiply(Quaternion other) {
        return new Quaternion(new Vector3(
                scalar * other.vector.x + vector.x * other.scalar + vector.y * other.vector.z - vector.z * other.vector.y,
                scalar * other.vector.y - vector.x * other.vector.z + vector.y * other.scalar + vector.z * other.vector.x,
                scalar * other.vector.z + vector.x * other.vector.y - vector.y * other.vector.x + vector.z * other.scalar
        ),
                scalar * other.scalar - vector.x * other.vector.x - vector.y * other.vector.y - vector.z * other.vector.z);
    }

    public double determineAngle() {
        Quaternion q = this.normalize();
        if ((q.scalar > 0.1) || (q.scalar < -0.1)) {
            return 2 * asin(q.abs());
        } else if (q.scalar > 0) {
            return 2 * acos(-q.scalar);
        }
        return (FastMath.acos(q.scalar) * 2.0);
    }

    public Vector3 determineAxis() {
        Quaternion q = this.normalize();
        double norm = q.getNorm();
        double x = q.vector.x / norm;
        double y = q.vector.y / norm;
        double z = q.vector.z / norm;
        return new Vector3(x, y, z).normalize().inverse();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Quaternion) {
            Quaternion other = (Quaternion) obj;
            return vector.equals(other.vector) && scalar == other.scalar;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = vector.hashCode();
        temp = Double.doubleToLongBits(scalar);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        String s = "" + vector.x + "i ";
        if (vector.y > 0) s += "+ " + vector.y + "j ";
        else s += "- " + Math.abs(vector.y) + "j ";
        if (vector.z > 0) s += "+ " + vector.z + "k ";
        else s += "- " + Math.abs(vector.z) + "k ";
        if (scalar > 0) s += "+ " + scalar;
        else s += "- " + Math.abs(scalar);
        return s;
    }
}