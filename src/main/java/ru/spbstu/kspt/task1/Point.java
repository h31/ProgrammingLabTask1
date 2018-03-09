package ru.spbstu.kspt.task1;

import static java.lang.Math.sqrt;
import static ru.spbstu.kspt.task1.Quaternion.round;

public class Point {

        public final double x;

        public final double y;

        public final double z;

        public Point(double x, double y, double z) {
            this.x = round(x);
            this.y = round(y);
            this.z = round(z);
        }

        public Point normal() {
            double length = this.length();
            double x1 = x / length;
            double y1 = y / length;
            double z1 = z / length;
            return new Point(x1, y1, z1);
        }

        private double length() {
            return sqrt(x * x + y * y + z * z);
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

