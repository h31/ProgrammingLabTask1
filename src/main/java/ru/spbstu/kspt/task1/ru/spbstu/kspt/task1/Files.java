package ru.spbstu.kspt.task1;

import java.io.*;
import java.util.*;

public class Files {

    public static void main(String[] args) {
    }

    /*public static void addFileToDirectory(String name, String dir) {
       File file1 = new File(dir, name);

       if (file1.exists()) {
           System.out.println("Файл " + name + " уже существует в директории " + dir);
       } else {

           try {
               if (file1.createNewFile()) {
                   System.out.println("Успешно создан новый файл " + name + " в каталоге " + dir);
               }
           } catch (IOException ex) {
               System.out.println("Ошибка при создании файла!");
           }
       }
   }
    static String readFile(String dir, String name) {
        StringBuilder result = new StringBuilder();
        try (FileInputStream file = new FileInputStream(dir + name)) {
            System.out.println("Файл " + dir + name + ", размером " + file.available() + " байт принят в работу");

            byte[] buffer = new byte[file.available()];
            file.read(buffer, 0, file.available());
            for (byte aBuffer : buffer) {
                result.append((char) aBuffer);
                System.out.print((char) aBuffer);
            }
            file.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        return result.toString();
    }

    public static void openFile(String dir, String name) {

        System.out.println(readFile(dir, name));
    }

    public static void writeFile(String dir, String name, String text) {
        File f = new File(dir + name);
        boolean rewrite = true;
        if (!f.exists()) {
            System.out.println("Файла " + name + " еще не существует!");
            addFileToDirectory(name, dir);
        } else {
            System.out.println("Файл " + name + " уже существует! Перезаписать? y / n");
            Scanner in = new Scanner(System.in);
            switch (in.next()) {
                case ("y"):
                    rewrite = true;
                    break;
                case "n":
                    rewrite = false;
                    break;
                default:
                    rewrite = false;
                    System.out.println("Некорректный ввод! Перезапись запрещена.");
                    break;
            }

        }
        if (rewrite) {
            try (FileOutputStream file = new FileOutputStream(dir + name)) {
                byte[] buffer = text.getBytes();

                file.write(buffer, 0, buffer.length);
                System.out.println("Файл " + name + " был успешно записан в директорию " + dir);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Запись файла " + name + " была запрещена пользователем.");
        }
    }

    public static void addStringToFile(String dir, String name, String text) {
        String currentText = readFile(dir, name);

        writeFile(dir, name, currentText + text);
    }
    */
}