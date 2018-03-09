package ru.spbstu.kspt.task1;

public interface QuaternionInterface {

    Quaternion scalarMultiplication(double scalar1);

    Quaternion conjugate();

    double module();

    Quaternion plus(Quaternion q);

    Quaternion minus(Quaternion q);

    Quaternion inverse();

    double norm();

    Quaternion multiply(Quaternion q);

    double determineAngle();

    Point determineAxis();

}
