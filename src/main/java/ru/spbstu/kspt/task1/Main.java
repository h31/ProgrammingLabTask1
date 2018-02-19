package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        System.out.println("Сравнение двух чисел:           " + bbInt1.Comparison(bbInt2));
        System.out.println("Сумма двух чисел:               " + BigBigInt.addition(bbInt1, bbInt2).getValue());
        System.out.println("Разность двух чисел:            " + BigBigInt.subtraction(bbInt1, bbInt2).getValue());
        System.out.println("Произведение двух чисел:        " + BigBigInt.multiplication(bbInt1, bbInt2).getValue());
        System.out.println("Деление двух чисел:             " + BigBigInt.division(bbInt1, bbInt2).getValue());
        //System.out.println("Остаток от деления двух чисел:  " + BigBigInt.residue(bbInt1, bbInt2).getValue());
    }
}