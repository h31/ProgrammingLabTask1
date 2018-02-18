package ru.spbstu.kspt.task1;

import com.sun.crypto.provider.PBEKeyFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.applet.Main;

import static java.lang.Math.pow;

/**
 * Main class
 */
public class Quaternion {
    private final double[] axis;

    private final double angle;

    public Quaternion (double[] axis, double angle) {
        if (axis.length != 3) throw new ArrayStoreException();
    }

    public double[] getAxis() {
        return axis;
    }

    public double getAngle() {
        return angle;
    }

    public Quaternion scalarMultiplication(double scalar) {
        return new Quaternion(new double[]{
                scalar * axis[0],
                scalar * axis[1],
                scalar * axis[2]
        },
                scalar * angle);
    }

    public Quaternion conjugate() {
        return new Quaternion(new double[]{-axis[0], -axis[1], -axis[2]}, angle);
    }

    public double module() {
        return Math.sqrt(pow(axis[0], 2.0) + pow(axis[1], 2.0) + pow(axis[2], 2.0) + pow(angle, 2.0));
    }

    public Quaternion plus(Quaternion other) {
        return new Quaternion(new double[]{
                axis[0] + other.axis[0],
                axis[1] + other.axis[1],
                axis[2] + other.axis[2]
        },
        angle + other.angle);
    }

    public Quaternion minus(Quaternion other) {
        return new Quaternion(new double[]{
                axis[0] - other.axis[0],
                axis[1] - other.axis[1],
                axis[2] - other.axis[2]
        },
                angle + other.angle);
    }

    public Quaternion reciprotical() {
        return this.conjugate().scalarMultiplication(1 / this.module());
    }

    public Quaternion norm() {
        return new Quaternion(new double[]{
                axis[0] * axis[0],
                axis[1] * axis[1],
                axis[2] * axis[2]},
                angle * angle);
    }

    public Quaternion multiplication(Quaternion other) {
    return new Quaternion(new double[]{
            angle * other.angle + axis[0] * other.axis[0] + axis[1] * other.axis[1] - axis[2] * other.axis[2],
            angle * other.angle - axis[0] * other.axis[0] + axis[1] * other.axis[1] + axis[2] * other.axis[2],
            angle * other.angle + axis[0] * other.axis[0] - axis[1] * other.axis[1] + axis[2] * other.axis[2]
    },
            angle * other.angle - axis[0] * other.axis[0] - axis[1] * other.axis[1] - axis[2] * other.axis[2]);
    }


    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("Logging example");
        System.out.println("Hello World!");
    }
}
