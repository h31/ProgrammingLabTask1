package ru.spbstu.kspt.task1;
public class Statics {

    static String timeToString(Integer seconds) {
        final int secondsInDay = 60 * 60 * 24;
        if (seconds > secondsInDay) {
            throw new IllegalArgumentException("Некорректно введенное время!");
        }
        StringBuilder result = new StringBuilder();
        int hour = seconds / 3600;
        int minutes = seconds % 3600 / 60;
        int sec = seconds - hour * 3600 - minutes * 60;

        result.append(makeNotationMoreCorrect(hour)).append(":")
                .append(makeNotationMoreCorrect(minutes))
                .append(makeNotationMoreCorrect(sec));
        return result.toString();
    }

    static String makeNotationMoreCorrect(int element) {
        if (element < 10) {
            return "0" + element;
        } else {
            return "" + element;
        }
    }
}
