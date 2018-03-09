package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main class
 */
public class Main{

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static class Quaternion {
    private double a;
    private double b;
    private double c;
    private double d;

    public Quaternion(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Quaternion conjugation() {
        return new Quaternion(a, -b, -c, -d);
    }
    public double abs() {
        return Math.sqrt(a * a  + b * b + c * c + d * d);
    }
    public Quaternion inverse() throws ArithmeticException {
        return Quaternion.division(this.conjugation(), a * a  + b * b + c * c + d * d);
    }

    public static Quaternion plus(Quaternion p, Quaternion q) {
        return new Quaternion(p.a + q.a, p.b + q.b, p.c + q.c, p.d + q.d);
    }
    public static Quaternion minus(Quaternion p, Quaternion q) {
        return new Quaternion(p.a - q.a, p.b - q.b, p.c - q.c, p.d - q.d);
    }
    public static Quaternion multConst(Quaternion p, double cst) {
        return new Quaternion(p.a * cst, p.b * cst, p.c * cst, p.d * cst);
    }
    public static Quaternion mult(Quaternion p, Quaternion q) {
        return new Quaternion(p.a * q.a - p.b * q.b - p.c * q.c - p.d * q.d,
                p.a * q.b + p.b * q.a + p.c * q.d - p.d * q.c,
                p.a * q.c - p.b * q.d + p.c * q.a + p.d * q.b,
                p.a * q.d + p.b * q.c - p.c * q.b + p.d * q.a);
    }

    public static Quaternion division(Quaternion p, double divisor) throws ArithmeticException {
        if (divisor == 0) throw new ArithmeticException("division by zero");
        return new Quaternion(p.a / divisor, p.b / divisor, p.c / divisor, p.d / divisor);
        }
}

    public static Quaternion rotation(double x, double y, double z, double angle) {
        double r = Math.sqrt(x * x + y * y + z * z);
        double s = Math.sin(angle / 2.0) / r;
        return new Quaternion(x * s, y * s, z * s, Math.cos(angle / 2.0));
    }

    public static class Axis{
    private double x;
    private double y;
    private double z;

    public Axis(double x, double y, double z){
        double r =  Math.sqrt(x * x + y * y + z * z);
        x = this.x / r;
        y = this.y / r;
        z = this.z / r;
    }
    }
    public static Axis axisDetermination(Quaternion q){
        return new Axis (q.a, q.b, q.c);
    }

    public static double angleDetermination(Quaternion q){
        return Math.acos(q.d /  Math.sqrt(q.a * q.a + q.b * q.b + q.c * q.c)) * 2.0;
    }
}


