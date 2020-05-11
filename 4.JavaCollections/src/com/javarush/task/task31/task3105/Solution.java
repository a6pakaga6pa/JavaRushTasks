package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.


*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, ByteArrayOutputStream> map = new TreeMap<>();
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1]));
        ZipEntry entry;
        while((entry = zipIn.getNextEntry())!=null){
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            String name = entry.getName();
            byte[] bytes = new byte[(int)entry.getSize()];
            int count = 0;
            while ((count = zipIn.read(bytes)) != -1)
                byteArrayOutputStream.write(bytes, 0, count);
            map.put(name, byteArrayOutputStream);
            zipIn.closeEntry();
        }
        zipIn.close();


        FileOutputStream outStr = new FileOutputStream(args[1]);
        ZipOutputStream zipOut = new ZipOutputStream(outStr);
        zipOut.putNextEntry(new ZipEntry(""+Paths.get(args[0]).getFileName()));
        Files.copy(Paths.get(args[0]), zipOut);
        zipOut.closeEntry();

        for(Map.Entry<String, ByteArrayOutputStream> pair : map.entrySet()){
            String name = pair.getKey();
            byte[] buff = pair.getValue().toByteArray();
            System.out.println(buff);
            zipOut.putNextEntry(new ZipEntry(name));
            zipOut.write(buff, 0, buff.length);
            zipOut.closeEntry();
        }

        zipOut.close();

    }


    }
     /*   String filePath = "D:/test/file.txt";
        String zipPath = "D:/test/test.zip";
        Path file = Paths.get(filePath);
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipPath));
        ZipEntry entry;
        Map<String, byte[]> map = new HashMap<>();
        while((entry = zipInputStream.getNextEntry()) != null) {
            byte[] buff = new byte[(int)entry.getSize()];
            zipInputStream.read(buff);
            String fileName = entry.getName();
            map.put(fileName, buff);
            zipInputStream.closeEntry();
        }
        zipInputStream.close();

    ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipPath));
    FileInputStream fileInputStream = new FileInputStream(filePath);
    byte[] buff = fileInputStream.readAllBytes();
    map.put(file.getFileName().toString(), buff);
    map.forEach((k, v) -> System.out.println(k + " : " + v));
        for (Map.Entry<String, byte[]> pair: map.entrySet()) {
            entry = new ZipEntry(pair.getKey());
            zipOutputStream.putNextEntry(entry);
            zipOutputStream.write(pair.getValue());
            zipOutputStream.closeEntry();
        }
        zipOutputStream.closeEntry();
    fileInputStream.close();
}*/

