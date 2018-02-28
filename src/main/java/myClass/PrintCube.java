package myClass;

public class PrintCube {

    private char[][] arr;
    private int n;

    PrintCube(int n) {
        this.arr = new char[n * 8 + 1][n * 18 + 1];
        this.n = n;

        for (int i = 0; i < n * 8 + 1; ++i) {
            for (int j = 0; j < n * 18 + 1; ++j) {
                arr[i][j] = ' ';
            }
        }

        for (int i = 0; i < n * 8 + 1; i = i + 2) {
            for (int j = 1; j < n * 18 + 1; j = j + 6) {
                for (int k = j; k < j + 5; k++) {
                    arr[i][k] = '-';
                }
            }
        }

        for (int i = 1; i < n * 8 + 1; i = i + 2) {
            for (int j = 0; j < n * 18 + 1; j = j + 6) {
                arr[i][j] = '|';
                arr[i - 1][j] = '+';
            }
        }
        for (int j = 0; j < n * 18 + 1; j = j + 6) {
            arr[n * 8][j] = '+';
        }
    }

    public void Print(Cube cube) {
        char[][][] ptr = cube.Get();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                arr[i * 2 + 1][n * 6 + 3 + j * 6] = ptr[0][i][j];
                arr[i * 2 + n * 2 + 1][3 + j * 6] = ptr[1][i][j];
                arr[i * 2 + n * 2 + 1][n * 6 + 3 + j * 6] = ptr[2][i][j];
                arr[i * 2 + n * 2 + 1][n * 12 + 3 + j * 6] = ptr[3][i][j];
                arr[i * 2 + n * 4 + 1][n * 6 + 3 + j * 6] = ptr[4][i][j];
                arr[i * 2 + n * 6 + 1][n * 6 + 3 + j * 6] = ptr[5][i][j];
            }
        }

        for (int i = 0; i < n * 8 + 1; ++i) {
            for (int j = 0; j < n * 18 + 1; ++j) {
                System.out.print(arr[i][j]);
            }
            System.out.print("\n");
        }
    }
}
