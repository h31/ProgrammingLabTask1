package myClass;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter cube size: ");
        int n = reader.nextInt();

        Cube cube = new Cube(n);

        while (true) {
            System.out.println("What'll we do?");
            Scanner look = new Scanner(System.in);
            String l = look.nextLine();
            if (Objects.equals(l, "Print")) {
                PrintCube printC1 = new PrintCube(n);
                printC1.Print(cube);
            }
            if (Objects.equals(l, "Stop")) {
                System.out.println("Досвидули))0)");
                break;
            }
            if (Objects.equals(l, "Left")) {
                cube.RotateLeft();
            }
            if (Objects.equals(l, "Right")) {
                cube.RotateRight();
            }
            if (Objects.equals(l, "Up")) {
                cube.RotateUp();
            }
            if (Objects.equals(l, "Down")) {
                cube.RotateDown();
            }
            if (Objects.equals(l, "F")) {
                cube.Spin(1);
            }
            if (Objects.equals(l, "F'")) {
                cube.Spin(2);
            }
            if (Objects.equals(l, "R")) {
                cube.RotateLeft();
                cube.Spin(1);
                cube.RotateRight();
            }
            if (Objects.equals(l, "R'")) {
                cube.RotateLeft();
                cube.Spin(2);
                cube.RotateRight();
            }
            if (Objects.equals(l, "L")) {
                cube.RotateRight();
                cube.Spin(1);
                cube.RotateLeft();
            }
            if (Objects.equals(l, "L'")) {
                cube.RotateRight();
                cube.Spin(2);
                cube.RotateLeft();
            }
            if (Objects.equals(l, "U")) {
                cube.RotateDown();
                cube.Spin(1);
                cube.RotateUp();
            }
            if (Objects.equals(l, "U'")) {
                cube.RotateDown();
                cube.Spin(2);
                cube.RotateUp();
            }
            if (Objects.equals(l, "D")) {
                cube.RotateUp();
                cube.Spin(1);
                cube.RotateDown();
            }
            if (Objects.equals(l, "D'")) {
                cube.RotateUp();
                cube.Spin(2);
                cube.RotateDown();
            }
            if (Objects.equals(l, "Random")) {
                cube.Random();
            }
        }
    }
}

