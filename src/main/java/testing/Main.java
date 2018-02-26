package testing;

import java.util.LinkedHashMap;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        String result;
        Scanner sc = new Scanner(System.in);
        result = timeToString(sc.nextInt());

        System.out.println(result);
    }


    private static String timeToString(int seconds) {
        if (seconds > 86399) { throw new IllegalArgumentException("Некорректно введенное время!");}
        StringBuilder result = new StringBuilder();
        int hour = seconds / 3600;
        int minutes = seconds % 3600 / 60;
        int sec = seconds - hour * 3600 - minutes * 60;

        if (hour < 10) {
            result.append(0).append(hour).append(":");
        }
        else {
            result.append(hour).append(":");
        }

        if (minutes < 10){
            result.append(0).append(minutes).append(":");
        }
        else {
            result.append(minutes).append(":");
        }

        if (sec < 10){
            result.append(0).append(sec);
        }
        else {
            result.append(sec);
        }
        return result.toString();
    }
}