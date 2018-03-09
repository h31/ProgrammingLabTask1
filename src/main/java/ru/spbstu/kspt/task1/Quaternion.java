package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.*;

/**
 * Quaternion class
 */

public class Quaternion implements QuaternionInterface {

    private static final Logger logger = LogManager.getLogger(ru.spbstu.kspt.task1.Quaternion.class.getName());

    private Point vector;

    private double scalar;

    public static double round(double value) {
        int scale = (int) Math.pow(10, 9);
        return (double) Math.round(value * scale) / scale;
    }

    Quaternion(Point vector, double scalar) {
        this.vector = vector;
        this.scalar = round(scalar);
        logger.debug("Quaternion value is " + this);
    }

    Quaternion(double angle, Point axis) {
        Point vector = axis.normal();
        double scalar = cos(angle / 2.0);
        double x = vector.x * sin(angle / 2.0);
        double y = vector.y * sin(angle / 2.0);
        double z = vector.z * sin(angle / 2.0);
        this.vector = new Point(x, y, z);
        this.scalar = round(scalar);
        logger.debug("Quaternion value is " + this);
    }

    public Point getVector() {
        return vector;
    }

    public double getScalar() {
        return scalar;
    }

    public void setVector(Point p) {
        this.vector = p;
    }

    public void setScalar(double d) {
        this.scalar = d;
    }

    public Quaternion scalarMultiplication(double scalar1) {
        return new Quaternion(new Point(
                scalar1 * vector.x,
                scalar1 * vector.y,
                scalar1 * vector.z
        ),
                scalar1 * this.scalar);
    }

    public Quaternion conjugate() {
        return new Quaternion(new Point(-vector.x, -vector.y, -vector.z), scalar);
    }

    public double module() {
        return sqrt(pow(vector.x, 2.0) + pow(vector.y, 2.0) + pow(vector.z, 2.0) + pow(scalar, 2.0));
    }

    public Quaternion plus(Quaternion other) {
        return new Quaternion(new Point(
                vector.x + other.vector.x,
                vector.y + other.vector.y,
                vector.z + other.vector.z
        ),
                scalar + other.scalar);
    }

    public Quaternion minus(Quaternion other) {
        return new Quaternion(new Point(
                vector.x - other.vector.x,
                vector.y - other.vector.y,
                vector.z - other.vector.z
        ),
                scalar - other.scalar);
    }

    public Quaternion inverse() {
        return this.conjugate().scalarMultiplication(1 / pow(this.module(), 2.0));
    }

    public double norm() {
        return round(vector.x * vector.x + vector.y * vector.y + vector.z * vector.z + scalar * scalar);
    }

    public Quaternion multiply(Quaternion other) {
        return new Quaternion(new Point(
                scalar * other.vector.x + vector.x * other.scalar + vector.y * other.vector.z - vector.z * other.vector.y,
                scalar * other.vector.y - vector.x * other.vector.z + vector.y * other.scalar + vector.z * other.vector.x,
                scalar * other.vector.z + vector.x * other.vector.y - vector.y * other.vector.x + vector.z * other.scalar
        ),
                scalar * other.scalar - vector.x * other.vector.x - vector.y * other.vector.y - vector.z * other.vector.z);
    }


    public double determineAngle() {
        return acos(scalar / this.module()) * 2.0;
    }

    public Point determineAxis() {
        double mod = this.module();
        double x = this.vector.x / mod;
        double y = this.vector.y / mod;
        double z = this.vector.z / mod;
        return new Point(x, y, z);
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
        else s += "- " + abs(vector.y) + "j ";
        if (vector.z > 0) s += "+ " + vector.z + "k ";
        else s += "- " + abs(vector.z) + "k ";
        if (scalar > 0) s += "+ " + scalar;
        else s += "- " + abs(scalar);
        return s;
    }
}