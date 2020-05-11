package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;


/* 
Что внутри папки?
Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок - [количество папок в директории и поддиректориях]
Всего файлов - [количество файлов в директории и поддиректориях]
Общий размер - [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.

Квадратные скобки [ ] выводить на экран не нужно.


*/
public class Solution extends SimpleFileVisitor<Path> {
    static String mainPath;
    static int allSize;
    static int folderCount;
    static int filesCount;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String folderPath = reader.readLine();
        Path directory = Paths.get(folderPath);
        mainPath = directory.toAbsolutePath().toString();
        if(Files.isDirectory(directory)) {
            reader.close();
            Files.walkFileTree(directory, new Solution());
            System.out.println("Всего папок - " + folderCount);
            System.out.println("Всего файлов - " + filesCount);
            System.out.println("Общий размер - " + allSize);
        } else {
            System.out.println(folderPath + " - не папка");
            reader.close();
        }

    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if(Files.isDirectory(dir) && !dir.toAbsolutePath().toString().equals(mainPath)) folderCount++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file);
        filesCount++;
        allSize += content.length;
        return FileVisitResult.CONTINUE;
    }
}
