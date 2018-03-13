package ru.spbstu.kspt.task1;

public interface QuaternionInterface {

    Quaternion multiplyOnScalar(double scalar1);

    Quaternion getConjugate();

    double abs();

    Quaternion add(Quaternion q);

    Quaternion substract(Quaternion q);

    Quaternion inverse();

    Quaternion normalize();

    double getNorm();

    Quaternion multiply(Quaternion q);

    double determineAngle();

    Vector3 determineAxis();
}
