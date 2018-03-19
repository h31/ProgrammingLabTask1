package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Quaternion class
 */
public class Quaternion {

    private static final Logger logger = LogManager.getLogger(Quaternion.class);


        public double a;
        public double b;
        public double c;
        public double d;

        public Quaternion(double a, double b, double c, double d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public Quaternion conjugate() {
            return new Quaternion(a, -b, -c, -d);
        }

        public double abs() {
            return Math.sqrt(a * a + b * b + c * c + d * d);
        }

        public Quaternion inverse() throws ArithmeticException {
            return Quaternion.divide(this.conjugate(), a * a + b * b + c * c + d * d);
        }

        public Quaternion plus(Quaternion p) {
            return new Quaternion(this.a + p.a, this.b + p.b, this.c + p.c, this.d + p.d);
        }

        public Quaternion minus(Quaternion p) {
            return new Quaternion(this.a - p.a, this.b - p.b, this.c - p.c, this.d - p.d);
        }

        public Quaternion multConst(Quaternion p, double cst) {
            return new Quaternion(p.a * cst, p.b * cst, p.c * cst, p.d * cst);
        }

        public Quaternion mult(Quaternion p) {
            return new Quaternion(this.a * p.a - this.b * p.b - this.c * p.c - this.d * p.d,
                    this.a * p.b + this.b * p.a + this.c * p.d - this.d * p.c,
                    this.a * p.c - this.b * p.d + this.c * p.a + this.d * p.b,
                    this.a * p.d + this.b * p.c - this.c * p.b + this.d * p.a);
        }

        public static Quaternion divide(Quaternion p, double divisor) throws ArithmeticException {
            if (divisor == 0) throw new ArithmeticException("division by zero");
            return new Quaternion(p.a / divisor, p.b / divisor, p.c / divisor, p.d / divisor);
        }

        @Override
        public boolean equals(Object obj){
            if (this == obj) return true;
            if (obj instanceof Quaternion){
                Quaternion other = (Quaternion) obj;
                return a == other.a && b == other.b && c == other.c && d == other.d;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int result;
            long boo;
            boo = Double.doubleToLongBits(a);
            result = (int) (boo ^ (boo >>> 32));
            boo = Double.doubleToLongBits(b);
            result = 31 * result + (int) (boo ^ (boo >>> 32));
            boo = Double.doubleToLongBits(c);
            result = 31 * result + (int) (boo ^ (boo >>> 32));
            boo = Double.doubleToLongBits(d);
            result = 31 * result + (int) (boo ^ (boo >>> 32));
            return result;
        }


        @Override
        public String toString() {
            return a +
                ((b < 0)? " - " : " + ") + Math.abs(b) + "*i" +
                ((c < 0)? " - " : " + ") + Math.abs(c) + "*j" +
                ((d < 0)? " - " : " + ") + Math.abs(d) + "*k";
          }

    public static Quaternion buildOfQuaternion(Axis d, double angle) {
        double s = Math.sin(angle / 2.0) ;
        return new Quaternion(d.x * s, d.y * s,d.z  * s, Math.cos(angle / 2.0));
    }

    public Axis axisDetermine(Quaternion q) {
        return new Axis(q.a, q.b, q.c);
    }

    public double angleDetermine(Quaternion q){
        return Math.acos(q.d /  Math.sqrt(q.a * q.a + q.b * q.b + q.c * q.c)) * 2.0;
    }
}

