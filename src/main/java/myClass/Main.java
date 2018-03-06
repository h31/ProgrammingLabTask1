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
            else if (Objects.equals(l, "Stop")) {
                System.out.println("Досвидули))0)");
                break;
            }
            else if (Objects.equals(l, "Left")) {
                cube.RotateLeft();
            }
            else if (Objects.equals(l, "Right")) {
                cube.RotateRight();
            }
            else if (Objects.equals(l, "Up")) {
                cube.RotateUp();
            }
            else if (Objects.equals(l, "Down")) {
                cube.RotateDown();
            }
            else if (Objects.equals(l, "F")) {
                cube.Spin(1);
            }
            else if (Objects.equals(l, "F'")) {
                cube.Spin(2);
            }
            else if (Objects.equals(l, "R")) {
                cube.RotateLeft();
                cube.Spin(1);
                cube.RotateRight();
            }
            else if (Objects.equals(l, "R'")) {
                cube.RotateLeft();
                cube.Spin(2);
                cube.RotateRight();
            }
            else if (Objects.equals(l, "L")) {
                cube.RotateRight();
                cube.Spin(1);
                cube.RotateLeft();
            }
            else if (Objects.equals(l, "L'")) {
                cube.RotateRight();
                cube.Spin(2);
                cube.RotateLeft();
            }
            else if (Objects.equals(l, "U")) {
                cube.RotateDown();
                cube.Spin(1);
                cube.RotateUp();
            }
            else if (Objects.equals(l, "U'")) {
                cube.RotateDown();
                cube.Spin(2);
                cube.RotateUp();
            }
            else if (Objects.equals(l, "D")) {
                cube.RotateUp();
                cube.Spin(1);
                cube.RotateDown();
            }
            else if (Objects.equals(l, "D'")) {
                cube.RotateUp();
                cube.Spin(2);
                cube.RotateDown();
            }
            else if (Objects.equals(l, "Random")) {
                cube.Random();
            }
        }
    }
}

