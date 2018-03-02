package myClass;

import java.util.Arrays;

public class Cube {
    private char[][][] cube;
    private char[][] arr;
    private int n;

    char[] symbols = {'W', 'R', 'B', 'O', 'Y', 'G'};

    Cube(int n) {
        this.n = n;
        this.cube = new char[6][n][n];

        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(cube[i][j], symbols[i]);
            }
        }
    }

    public char[][][] Get() {
        return cube;
    }

    int x = 0, y = 0;

    public void RotateOpposite() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cube[x][i][j] = cube[x][j][i];
                cube[y][i][j] = cube[y][j][i];
            }
        }
    }

    char[][] help = new char[0][];
    char[][] help1 = new char[0][];

    public void RotateLeft() {
        y = 5;
        RotateOpposite();
        help = cube[1];
        help1 = cube[5];
        cube[5] = help;
        help = cube[2];
        cube[1] = help;
        help = cube[3];
        cube[2] = help;
        cube[3] = help1;
    }

    public void RotateRight() {
        RotateLeft();
        RotateLeft();
        RotateLeft();
    }

    public void RotateUp() {
        x = 1;
        y = 3;
        RotateOpposite();
        help1 = cube[0];
        help = cube[5];
        cube[5] = help1;
        help1 = cube[2];
        cube[0] = help1;
        help1 = cube[4];
        cube[2] = help1;
        cube[4] = help;
    }

    public void RotateDown() {
        RotateUp();
        RotateUp();
        RotateUp();
    }

    public void SpinFront() {
        char[][] help = cube[2].clone();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cube[2][i][j] = help[j][n - i - 1];
            }
        }
        char[] h = cube[0][n - 1].clone();
        char c;
        for (int i = 0; i < n; ++i) {
            cube[0][n - 1][i] = cube[1][n - i - 1][n - 1];
        }
        for (int i = 0; i < n; ++i) {
            c = cube[3][i][0];
            cube[3][i][0] = h[i];
            h[i] = c;
        }
        for (int i = 0; i < n; ++i) {
            c = cube[4][0][i];
            cube[4][0][i] = h[n - i - 1];
            h[n - i - 1] = c;
        }
        for (int i = 0; i < n; ++i) {
            cube[1][i][n - 1] = h[n - i - 1];
        }
    }

    public void SpinRight() {
        RotateRight();
        SpinFront();
        RotateLeft();
    }
}



