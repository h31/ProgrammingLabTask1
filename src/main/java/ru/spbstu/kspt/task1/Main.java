package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.*;

/**
 * Main class
 */

public class Main {

    public static Quaternion getQuaternionByAxisAndAngle(Point axis, double angle) {
        double scalar = cos(angle / 2.0);
        double x = axis.x * sin(angle / 2.0);
        double y = axis.y * sin(angle / 2.0);
        double z = axis.z * sin(angle / 2.0);
        return new Quaternion(new Point(x, y, z), scalar);
    }

    public static double determineAngle(Quaternion q) {
        return acos(q.scalar) * 2.0;
    }

    public static Point determineAxis(Quaternion q) {
        double a = 2.0 * asin(q.scalar);
        double x = q.vector.x / a;
        double y = q.vector.y / a;
        double z = q.vector.z / a;
        return new Point(x, y, z);
    }

    static double round(double value) {
        int scale = (int) Math.pow(10, 9);
        return (double) Math.round(value * scale) / scale;
    }

    public static class Point {

        private final double x;

        private final double y;

        private final double z;

        public Point(double x, double y, double z) {
            this.x = round(x);
            this.y = round(y);
            this.z = round(z);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ", " + z + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj instanceof Point) {
                Point other = (Point) obj;
                return x == other.x && y == other.y && z == other.z;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(x);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(y);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(z);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }


    public static class Quaternion {

        private final Point vector;

        private final double scalar;

        Quaternion(Point vector, double scalar) {
            this.vector = vector;
            this.scalar = round(scalar);
        }

        public Point getVector() {
            return vector;
        }

        double getScalar() {
            return scalar;
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

        double module() {
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
            return "" + vector.x + "i + " + vector.y + "j + " + vector.z + "k + " + scalar + "";
        }
    }
}
