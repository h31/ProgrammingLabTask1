package ru.spbstu.kspt.task1;

public class Axis {
    public double x;
    public double y;
    public double z;

    public Axis(double x, double y, double z) {
        double r = Math.sqrt(x * x + y * y + z * z);
        this.x = x / r;
        this.y = y / r;
        this.z = z / r;
    }
}