package ru.spbstu.kspt.task1;

/**
 * Объекты данного класса (bbInt) - положительные числа длинной от одного, до 2^31-1 элементов
 * Объекты умеют:
 * +сравниваться
 * +складываться
 * +вычитаться
 * +умножаться
 * -делиться
 * -находить остаток от деления
 */


class BigBigInt {

    private String value;//Хранимое значение исходного огромного числа (bbInt)

    String getValue() {//Получение значения bbInt
        return value;
    }

    BigBigInt(String string) { //Конструктор класса
        //Преобразование строик в число без впередиидущих '0' и ' '
        string = string.replaceAll("\\D", "");
        string = string.replaceFirst("^0+(?!$)", "");
        //Обработка ввода строки не содержащей чисел
        value = string;
        if (value.isEmpty()) {
            System.out.println("Ошибка ввода числа");
            value = null;
        }
    }

    static int compare(BigBigInt bbInt1, BigBigInt bbInt2) {//Сравнение двух bbInt
        int result = -2;
        if (bbInt1.value.compareTo(bbInt2.value) == 0) return 0;
        if (bbInt1.value.length() > bbInt2.value.length()) return 1;
        if (bbInt1.value.length() < bbInt2.value.length()) return -1;
        for (int i = 0; i < Math.min(bbInt1.value.length(), bbInt2.value.length()); i++) {
            if (bbInt1.value.charAt(i) > bbInt2.value.charAt(i)) return 1;
            if (bbInt1.value.charAt(i) < bbInt2.value.charAt(i)) return -1;
        }
        System.out.println("Ошибка при попытке сравнения");
        return result;
    }

    static BigBigInt add(BigBigInt bbInt1, BigBigInt bbInt2) {//Сумма двух bbInt
        if (compare(bbInt1, bbInt2) < 0) {
            BigBigInt bbInt = bbInt1;
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
            StringBuilder builder = new StringBuilder();
            answer = builder.append(Integer.toString(help)).append(answer).toString();
        }
        if (ten)
            answer = "1" + answer;
        return new BigBigInt(answer);
    }

    static BigBigInt subtract(BigBigInt bbInt1, BigBigInt bbInt2) {//Разность двух bbInt
        if (compare(bbInt1, bbInt2) < 0) {
            BigBigInt bbInt = bbInt1;
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

    static BigBigInt multiply(BigBigInt bbInt1, BigBigInt bbInt2) {//Произведение двух bbIn
        if ((bbInt1 == new BigBigInt("0")) || (bbInt2 == new BigBigInt("0"))) return new BigBigInt("0");
        if (compare(bbInt1, bbInt2) < 0) {
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
            answer = BigBigInt.add(answer, new BigBigInt(ans));
        }
        return answer;
    }

    static BigBigInt divide(BigBigInt bbInt1, BigBigInt bbInt2) {//Деление двух bbInt
        BigBigInt bbInt;
        if (compare(bbInt1, bbInt2) < 0) {
            bbInt = bbInt1;
            bbInt1 = bbInt2;
            bbInt2 = bbInt;
        }
        bbInt = new BigBigInt("0");
        String str2;
        String counter = "0";
        do {
            str2 = add(bbInt, bbInt2).value;
            bbInt = new BigBigInt(str2);
            counter = add(new BigBigInt(counter), new BigBigInt("1")).value;
        } while (compare(bbInt1, bbInt) == 1);
        if (compare(bbInt, bbInt1) == 1)
            counter = subtract(new BigBigInt(counter), new BigBigInt("1")).value;
        return new BigBigInt(counter);
    }

    static BigBigInt remain(BigBigInt bbInt1, BigBigInt bbInt2) {//Остаток от деления двух bbInt
        if ((bbInt1 == new BigBigInt("0")) || (bbInt2 == new BigBigInt("0"))) return new BigBigInt("0");
        BigBigInt bbInt;
        if (compare(bbInt1, bbInt2) < 0) {
            bbInt = bbInt1;
            bbInt1 = bbInt2;
            bbInt2 = bbInt;
        }
        bbInt = new BigBigInt("0");
        String str2;
        String counter = "0";
        do {
            str2 = add(bbInt, bbInt2).value;
            bbInt = new BigBigInt(str2);
            counter = add(new BigBigInt(counter), new BigBigInt("1")).value;
        } while (compare(bbInt1, bbInt) == 1);
        if (compare(bbInt1, bbInt) == 0) return new BigBigInt("0");
        else {
            bbInt = subtract(bbInt, bbInt2);
            counter = subtract(bbInt1, bbInt).value;
        }
        return new BigBigInt(counter);
    }

}
