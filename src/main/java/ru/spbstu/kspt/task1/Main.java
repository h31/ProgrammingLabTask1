package ru.spbstu.kspt.task1;

/**
 * Main class
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        BigBigInt bbInt1;
        BigBigInt bbInt2;

        do {
            System.out.println("Введите ПЕРВОЕ число из интервала [0,+oo]");
            String string1 = in.nextLine();
            bbInt1 = new BigBigInt(string1);
        }while (bbInt1.getValue() == null);

        do {
            System.out.println("Введите ВТОРОЕ число из интервала [0,+oo]");
            String string2 = in.nextLine();
            bbInt2 = new BigBigInt(string2);
        }while (bbInt2.getValue() == null);

        System.out.println("Первое число: " + bbInt1.getValue());
        System.out.println("Второе число: " + bbInt2.getValue());
        System.out.println("Сравнение двух чисел:           " + BigBigInt.compare(bbInt1, bbInt2));
        System.out.println("Сумма двух чисел:               " + BigBigInt.add(bbInt1, bbInt2).getValue());
        System.out.println("Разность двух чисел:            " + BigBigInt.subtract(bbInt1, bbInt2).getValue());
        System.out.println("Произведение двух чисел:        " + BigBigInt.multiply(bbInt1, bbInt2).getValue());
        System.out.println("Деление двух чисел:             " + BigBigInt.divide(bbInt1, bbInt2).getValue());
        System.out.println("Остаток от деления двух чисел:  " + BigBigInt.remain(bbInt1, bbInt2).getValue());
    }
}