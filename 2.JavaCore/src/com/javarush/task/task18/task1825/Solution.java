package com.javarush.task.task18.task1825;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.


*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, byte[]> allInfo = new TreeMap<>();
        String fileName = "";

        while(true){
            String filePath = reader.readLine();
            if(!filePath.equals("end")){
                FileInputStream inputStream = new FileInputStream(filePath);
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);

                int dotPlace = filePath.lastIndexOf(".");
                fileName = filePath.substring(0, dotPlace); //fileName to create

                int partPlace = filePath.lastIndexOf("t");
                String partNumberString = filePath.substring(partPlace + 1);  // finding out the part #
                int partNumber = Integer.parseInt(partNumberString);
                allInfo.put(partNumber, buffer);   // adding all info to the map
                inputStream.close();
            } else {
                break;
            }
        }

        File fileOutput = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutput, true);

        for (Map.Entry<Integer, byte[]> pair: allInfo.entrySet()) {
            outputStream.write(pair.getValue());
        }

        reader.close();
        outputStream.close();
    }
}
