package myClass;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Введите размер кубика: ");
        int n = reader.nextInt();

        Cube cube = new Cube(n);

        PrintCube prntC = new PrintCube(n);
        prntC.Print(cube);
        int k = 0;
        do {
            System.out.println("Что будем с ним делать?");
            Scanner look = new Scanner(System.in);
            String l = look.nextLine();
            if (Objects.equals(l, "Закончить")) {
                System.out.println("Досвидули))0)");
                k = k - 1000000;
            }
            if (Objects.equals(l, "Влево")) {
                cube.RotateLeft();
                System.out.println("Кубик повернут влево. Вывести на экран?");
                Scanner look1 = new Scanner(System.in);
                String k1 = look1.nextLine();
                if (Objects.equals(k1, "Да")) {
                    PrintCube printC1 = new PrintCube(n);
                    printC1.Print(cube);
                }
            }
            if (Objects.equals(l, "Вправо")) {
                cube.RotateRight();
                System.out.println("Кубик повернут вправо. Вывести на экран?");
                Scanner look2 = new Scanner(System.in);
                String k2 = look2.nextLine();
                if (Objects.equals(k2, "Да")) {
                    PrintCube printC1 = new PrintCube(n);
                    printC1.Print(cube);
                }
            }
            if (Objects.equals(l, "Вверх")) {
                cube.RotateUp();
                System.out.println("Кубик повернут вверх. Вывести на экран?");
                Scanner look3 = new Scanner(System.in);
                String k3 = look3.nextLine();
                if (Objects.equals(k3, "Да")) {
                    PrintCube printC1 = new PrintCube(n);
                    printC1.Print(cube);
                }
            }
            if (Objects.equals(l, "Вниз")) {
                cube.RotateDown();
                System.out.println("Кубик повернут вниз. Вывести на экран?");
                Scanner look4 = new Scanner(System.in);
                String k4 = look4.nextLine();
                if (Objects.equals(k4, "Да")) {
                    PrintCube printC1 = new PrintCube(n);
                    printC1.Print(cube);
                }
            }
            ++k;
        } while (k >= 0);
    }
}

