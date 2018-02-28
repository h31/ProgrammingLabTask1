package myClass;

import java.util.Arrays;

public class Cube {
    private int n;
    private char[][][] cube;

    char[] symbols = {'W', 'R', 'B', 'O', 'Y', 'G'};
    char[] symbolsAdd = {' ', ' ', ' ', ' ', ' ', ' '};

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
        symbolsAdd[5] = symbols[1];
        symbolsAdd[1] = symbols[2];
        symbols[1] = symbolsAdd[1];
        symbolsAdd[2] = symbols[3];
        symbols[2] = symbolsAdd[2];
        symbolsAdd[3] = symbols[5];
        symbols[3] = symbolsAdd[3];
        symbols[5] = symbolsAdd[5];
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(cube[i][j], symbols[i]);
            }
        }
    }

    public void RotateRight() {
        symbolsAdd[1] = symbols[5];
        symbolsAdd[2] = symbols[1];
        symbolsAdd[3] = symbols[2];
        symbolsAdd[5] = symbols[3];
        symbols[1] = symbolsAdd[1];
        symbols[2] = symbolsAdd[2];
        symbols[3] = symbolsAdd[3];
        symbols[5] = symbolsAdd[5];
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(cube[i][j], symbols[i]);
            }
        }
    }

    public void RotateUp() {
        symbolsAdd[0] = symbols[2];
        symbolsAdd[2] = symbols[4];
        symbolsAdd[5] = symbols[0];
        symbolsAdd[4] = symbols[5];
        symbols[0] = symbolsAdd[0];
        symbols[2] = symbolsAdd[2];
        symbols[4] = symbolsAdd[4];
        symbols[5] = symbolsAdd[5];
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(cube[i][j], symbols[i]);
            }
        }
    }

    public void RotateDown() {
        symbolsAdd[0] = symbols[5];
        symbolsAdd[2] = symbols[0];
        symbolsAdd[5] = symbols[4];
        symbolsAdd[4] = symbols[2];
        symbols[0] = symbolsAdd[0];
        symbols[2] = symbolsAdd[2];
        symbols[4] = symbolsAdd[4];
        symbols[5] = symbolsAdd[5];
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(cube[i][j], symbols[i]);
            }
        }
    }
}


