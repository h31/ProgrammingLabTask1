package myRubiksCube;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter cube size: ");
        int n = reader.nextInt();

        Cube cube = new Cube(n);

        boolean B = true;

        while (B) {
            System.out.println("What'll we do?");
            Scanner look = new Scanner(System.in);
            String l = look.nextLine();
            switch (l) {
                case "Print": {
                    CubePrinter printC1 = new CubePrinter(n);
                    printC1.Print(cube);
                    break;
                }
                case "Stop": {
                    System.out.println("Досвидули))0)");
                    B = false;
                    break;
                }
                case "Left": {
                    cube.rotateLeft();
                    break;
                }
                case "Right": {
                    cube.rotateRight();
                    break;
                }
                case "Up": {
                    cube.rotateUp();
                    break;
                }
                case "Down": {
                    cube.rotateDown();
                    break;
                }
                case "F": {
                    cube.spin(1);
                    break;
                }
                case "F'": {
                    cube.spin(2);
                    break;
                }
                case "R": {
                    cube.rotateLeft();
                    cube.spin(1);
                    cube.rotateRight();
                    break;
                }
                case "R'": {
                    cube.rotateLeft();
                    cube.spin(2);
                    cube.rotateRight();
                    break;
                }
                case "L": {
                    cube.rotateRight();
                    cube.spin(1);
                    cube.rotateLeft();
                    break;
                }
                case "L'": {
                    cube.rotateRight();
                    cube.spin(2);
                    cube.rotateLeft();
                    break;
                }
                case "U": {
                    cube.rotateDown();
                    cube.spin(1);
                    cube.rotateUp();
                    break;
                }
                case "U'": {
                    cube.rotateDown();
                    cube.spin(2);
                    cube.rotateUp();
                    break;
                }
                case "D": {
                    cube.rotateUp();
                    cube.spin(1);
                    cube.rotateDown();
                    break;
                }
                case "D'": {
                    cube.rotateUp();
                    cube.spin(2);
                    cube.rotateDown();
                    break;
                }
                case "Shuffle": {
                    cube.shuffle();
                    break;
                }
            }
        }
    }
}

