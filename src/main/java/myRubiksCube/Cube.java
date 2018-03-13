package myRubiksCube;

import java.util.Arrays;
import java.util.Random;

public class Cube {
    public char[][][] cube;
    public int size;

    char[] symbols = {'W', 'R', 'B', 'O', 'Y', 'G'};

    public Cube(int size) {
        this.size = size;
        this.cube = new char[6][size][size];

        // Кубик заполняется в собранное состояние

        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < size; ++j) {
                Arrays.fill(cube[i][j], symbols[i]);
            }
        }
    }

    public char[][][] Get() {
        return cube;
    }


    public void rotateLeft() {
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

    public void rotateRight() {
        rotateLeft();
        rotateLeft();
        rotateLeft();
    }

    public void rotateUp() {
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

    public void rotateDown() {
        rotateUp();
        rotateUp();
        rotateUp();
    }

    public void spin(int direction) {
        rotate(direction, 2);
        char c;
        for (int i = 0; i < size; ++i) {
            if (direction == 1) {
                c = cube[1][size - i - 1][size - 1];
                cube[1][size - i - 1][size - 1] = cube[4][0][size - i - 1];
                cube[4][0][size - i - 1] = cube[3][i][0];
                cube[3][i][0] = cube[0][size - 1][i];
                cube[0][size - 1][i] = c;
            } else {
                c = cube[1][size - i - 1][size - 1];
                cube[1][size - i - 1][size - 1] = cube[0][size - 1][i];
                cube[0][size - 1][i] = cube[3][i][0];
                cube[3][i][0] = cube[4][0][size - i - 1];
                cube[4][0][size - i - 1] = c;
            }
        }
    }

    public void rotate(int position, int numCube) {
        char[][] help = new char[size][size];

        if (position == 1) {
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    help[i][j] = cube[numCube][size - 1 - j][i];
                }
            }
        } else {
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    help[i][j] = cube[numCube][j][size - 1 - i];
                }
            }
        }
        cube[numCube] = help;
    }

    public void shuffle() {
        for (int i = 0; i < 20; ++i) {
            Random random = new Random();
            int number = random.nextInt(13);
            switch (number) {
                case 0: spin(1); break;
                case 1: spin(2); break;
                case 2: rotateLeft(); spin(1); rotateRight(); break;
                case 3: rotateLeft(); spin(2); rotateRight(); break;
                case 4: rotateRight(); spin(1); rotateLeft(); break;
                case 5: rotateRight(); spin(2); rotateLeft(); break;
                case 6: rotateDown(); spin(1); rotateUp(); break;
                case 7: rotateDown(); spin(2); rotateUp(); break;
                case 8: rotateLeft();
                case 9: rotateRight();
                case 10: rotateUp();
                case 11: rotateDown();
                case 12: rotateUp(); spin(1); rotateDown(); break;
                case 13: rotateUp(); spin(2); rotateDown(); break;
            }
        }
    }
}





