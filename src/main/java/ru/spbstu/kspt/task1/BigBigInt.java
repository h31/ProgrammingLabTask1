package ru.spbstu.kspt.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
Объекты данного класса (bbInt) - положительные числа длинной от одного, до 2^31-1 элементов
Объекты умеют:
    +сравниваться
    +складываться
    +вычитаться
    +умножаться
    -делиться
    -находить остаток от деления
 */


class BigBigInt {

    private String value;//Хранимое значение исходного огромного числа (bbInt)

    String getValue() {//Получение значения bbInt
        return value;
    }

    BigBigInt(String string) { //Конструктор класса
        //Обработка впередиидущих '0' и ' '
        int i;
        for (i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '0' && string.charAt(i) != ' ') {
                break;
            }
            if (i == string.length() - 1 && string.charAt(i) == '0') {
                value = "0";
                return;
            }
        }
        //Преобразование строик в число без впередиидущих '0' и ' '
        char[] help = new char[string.length() - i];
        string.getChars(i, string.length(), help, 0);
        value = new String(help);
        //Обработка ввода строки не содержащей чисел
        if (value.compareTo("") == 0) {
            System.out.println("Ошибка ввода числа");
            value = null;
        }
    }

    int Comparison(BigBigInt bbInt) {//Сравнение двух bbInt
        int result = -2;
        if (this.value.compareTo(bbInt.value) == 0) {
            result = 0;
            return result;
        }
        if (this.value.length() > bbInt.value.length()) {
            result = 1;
            return result;
        }
        if (this.value.length() < bbInt.value.length()) {
            result = -1;
            return result;
        }
        for (int i = 0; i < Math.min(this.value.length(), bbInt.value.length()); i++) {
            if (this.value.charAt(i) > bbInt.value.charAt(i)) {
                result = 1;
                return result;
            }
            if (this.value.charAt(i) < bbInt.value.charAt(i)) {
                result = -1;
                return result;
            }
        }
        System.out.println("Ошибка при попытке сравнения");
        return result;
    }

    static BigBigInt addition(BigBigInt bbInt1, BigBigInt bbInt2) {//Сумма двух bbInt
        if (bbInt1.Comparison(bbInt2) < 0) {
            BigBigInt bbInt;
            bbInt = bbInt1;
            bbInt1 = bbInt2;
            bbInt2 = bbInt;
        }
        String answer = "";
        String str2 = "";
        for (int i = 0; i < bbInt1.value.length() - bbInt2.value.length(); i++) {
            str2 = str2 + "0";
        }
        str2 = str2 + bbInt2.value;
        boolean ten = false;
        int help;
        for (int i = bbInt1.value.length() - 1; i >= 0; i--) {
            if (ten)
                help = 1;
            else
                help = 0;
            help += Integer.parseInt(bbInt1.value.charAt(i) + "") + Integer.parseInt(str2.charAt(i) + "");
            if (help >= 10) {
                ten = true;
                help -= 10;
            } else
                ten = false;
            answer = Integer.toString(help) + answer;
        }
        if (ten)
            answer = "1" + answer;
        return new BigBigInt(answer);
    }

    static BigBigInt subtraction(BigBigInt bbInt1, BigBigInt bbInt2) {//Разность двух bbInt
        if (bbInt1.Comparison(bbInt2) < 0) {
            BigBigInt bbInt;
            bbInt = bbInt1;
            bbInt1 = bbInt2;
            bbInt2 = bbInt;
        }
        String answer = "";
        String str2 = "";
        for (int i = 0; i < bbInt1.value.length() - bbInt2.value.length(); i++) {
            str2 = str2 + "0";
        }
        str2 = str2 + bbInt2.value;
        boolean ten = false;
        int help;
        for (int i = bbInt1.value.length() - 1; i >= 0; i--) {
            if (ten)
                help = -1;
            else
                help = 0;
            help += Integer.parseInt(bbInt1.value.charAt(i) + "") - Integer.parseInt(str2.charAt(i) + "");
            if (help < 0) {
                ten = true;
                help += 10;
            } else
                ten = false;
            answer = Integer.toString(help) + answer;
        }
        return new BigBigInt(answer);
    }

    static BigBigInt multiplication(BigBigInt bbInt1, BigBigInt bbInt2) {//Произведение двух bbIn
        if (bbInt1.Comparison(bbInt2) < 0) {
            BigBigInt bbInt;
            bbInt = bbInt1;
            bbInt1 = bbInt2;
            bbInt2 = bbInt;
        }
        BigBigInt answer = new BigBigInt("0");
        for (int i = bbInt2.value.length() - 1; i >= 0; i--) {
            int help = 0;
            String ans = "";
            for (int j = bbInt1.value.length() - 1; j >= 0; j--) {
                help += Integer.parseInt(bbInt2.value.charAt(i) + "") * Integer.parseInt(bbInt1.value.charAt(j) + "");
                ans = (help % 10) + ans;
                help /= 10;
            }
            ans = Integer.toString(help) + ans;
            for (int j = i; j < bbInt2.value.length() - 1; j++)
                ans = ans + "0";
            answer = BigBigInt.addition(answer, new BigBigInt(ans));
        }
        return answer;
    }

    static BigBigInt division(BigBigInt bbInt1, BigBigInt bbInt2) {//Деление двух bbInt
        BigBigInt bbInt;
        if (bbInt1.Comparison(bbInt2) < 0) {
            bbInt = bbInt1;
            bbInt1 = bbInt2;
            bbInt2 = bbInt;
        }
        bbInt = new BigBigInt("0");
        String str2;
        String counter = "0";
        do {
            str2 = addition(bbInt, bbInt2).value;
            bbInt = new BigBigInt(str2);
            counter = addition(new BigBigInt(counter), new BigBigInt("1")).value;
        } while (bbInt1.Comparison(bbInt) == 1);
        if (bbInt.Comparison(bbInt1) == 1)
            counter = subtraction(new BigBigInt(counter), new BigBigInt("1")).value;
        return new BigBigInt(counter);
    }

    static BigBigInt residue(BigBigInt bbInt1, BigBigInt bbInt2) {//Остаток от деления двух bbInt
        return new BigBigInt("В процессе разработки");
    }
}
