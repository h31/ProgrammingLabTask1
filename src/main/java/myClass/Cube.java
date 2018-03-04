package myClass;

import java.util.Arrays;
import java.util.Random;

public class Cube {
    private char[][][] cube;
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


    public void RotateLeft() {
        char[][] help = cube[1];
        cube[1] = cube[2];
        cube[2] = cube[3];
        cube[3] = cube[5];
        cube[5] = help;
        rotate(1, 0);
        rotate(0, 4);
        rotate(1, 5);
        rotate(1, 5);
        rotate(1, 3);
        rotate(1, 3);
    }

    public void RotateRight() {
        RotateLeft();
        RotateLeft();
        RotateLeft();
    }

    public void RotateUp() {
        char[][] help;
        char[][] help1;

        help1 = cube[0];
        help = cube[5];
        cube[5] = help1;
        help1 = cube[2];
        cube[0] = help1;
        help1 = cube[4];
        cube[2] = help1;
        cube[4] = help;
        rotate(3, 1);
        rotate(1, 3);
    }

    public void RotateDown() {
        RotateUp();
        RotateUp();
        RotateUp();
    }

    public void Spin(int t) {
        rotate(t, 2);
        char c;
        for (int i = 0; i < n; ++i) {
            if (t == 1) {
                c = cube[1][n - i - 1][n - 1];
                cube[1][n - i - 1][n - 1] = cube[4][0][n - i - 1];
                cube[4][0][n - i - 1] = cube[3][i][0];
                cube[3][i][0] = cube[0][n - 1][i];
                cube[0][n - 1][i] = c;
            } else {
                c = cube[1][n - i - 1][n - 1];
                cube[1][n - i - 1][n - 1] = cube[0][n - 1][i];
                cube[0][n - 1][i] = cube[3][i][0];
                cube[3][i][0] = cube[4][0][n - i - 1];
                cube[4][0][n - i - 1] = c;
            }
        }
    }

    private void rotate(int t, int pos) {
        char[][] help = new char[n][n];

        if (t == 1) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    help[i][j] = cube[pos][n - 1 - j][i];
                }
            }
        } else {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    help[i][j] = cube[pos][j][n - 1 - i];
                }
            }
        }
        cube[pos] = help;
    }

    public void Random() {
        for (int i = 0; i < 20; ++i) {
            Random random = new Random();
            int number = random.nextInt(13);
            if (number == 0) {
                Spin(1);
            }
            if (number == 1) {
                Spin(2);
            }
            if (number == 2) {
                RotateLeft();
                Spin(1);
                RotateRight();
            }
            if (number == 3) {
                RotateLeft();
                Spin(2);
                RotateRight();
            }
            if (number == 4) {
                RotateRight();
                Spin(1);
                RotateLeft();
            }
            if (number == 5) {
                RotateRight();
                Spin(2);
                RotateLeft();
            }
            if (number == 6) {
                RotateDown();
                Spin(1);
                RotateUp();
            }
            if (number == 7) {
                RotateDown();
                Spin(2);
                RotateUp();
            }
            if (number == 8) {
                RotateLeft();
            }
            if (number == 9) {
                RotateRight();
            }
            if (number == 10) {
                RotateUp();
            }
            if (number == 11) {
                RotateDown();
            }
            if (number == 12) {
                RotateUp();
                Spin(1);
                RotateDown();
            }
            if (number == 13) {
                RotateUp();
                Spin(2);
                RotateDown();
            }
        }
    }
}





