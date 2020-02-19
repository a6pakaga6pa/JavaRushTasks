package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


*/

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new LinkedList<>();

        String number = "";

        String file1Path = reader.readLine();
        String file2Path = reader.readLine();

        FileOutputStream file2os = new FileOutputStream(file2Path);
        FileInputStream file1is = new FileInputStream(file1Path);

        byte[] buffer = new byte[file1is.available()];

        int count = file1is.read(buffer);
        for (int i = 0; i < count; i++) {
            if(buffer[i] != 32) {
                char symbol = (char)buffer[i];
                number = number + symbol;
            } else {
                list.add(number);
                number = "";

            }
        }
        list.add(number);

        for (String value : list) {
            int finalNumber = (int) Math.round(Double.parseDouble(value));
            String s = Integer.toString(finalNumber);
            file2os.write(s.getBytes());
            file2os.write(32);
        }
        file1is.close();
        reader.close();
        file2os.close();
    }
}
