package ru.spbstu.kspt.task1;
import java.io.*;

public class Files {

    public static void main(String[] args){
        writeFile("/Users/Ferrero/IdeaProjects3/ProgrammingLabTask1/src/main/resources/trains/","test.txt","");

    }

    public static void addDirectory(String dir) {
        File directory = new File(dir);

        if (!directory.exists()) {
            boolean created = directory.mkdir();
            if (created) {
                System.out.println("Каталог " + dir + " успешно создан");
            } else {
                System.out.println("Не получается создать каталог!");
            }

        } else {
            System.out.println("Каталог " + dir + " уже существует!");
        }
    }
    public static void addFileToDirectory(String name, String dir){
        File file1 = new File(dir, name);

        if (file1.exists()){
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

    public static void readFile(String dir, String name) {
        StringBuilder result = new StringBuilder();
        try (FileInputStream file = new FileInputStream(dir + name)){
            System.out.println("Файл " + dir + name + ", размером " + file.available() + " байт принят в работу");

            byte[] buffer = new byte[file.available()];
            file.read(buffer, 0, file.available());
            System.out.println("Содержимое файла:");
            for(int i = 0; i < buffer.length; i++){
                result.append((char)buffer[i]);
            }
            file.close();

        }
        catch (IOException ex){
            System.out.println(ex.getMessage());

        }
        System.out.println(result);

    }

    public static void writeFile(String dir, String name, String text){
        File f = new File(dir+name);

        if (!f.exists()) {
            System.out.println("Файла " + name + " еще не существует!");
            addFileToDirectory(name, dir);
        }

        try(FileOutputStream file = new FileOutputStream(dir + name)) {
            byte[] buffer = text.getBytes();

            file.write(buffer, 0, buffer.length);

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
