package com.javarush.task.task18.task1809;

/* 
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Path = reader.readLine();
        String file2Path = reader.readLine();

        FileInputStream inputStream = new FileInputStream(file1Path);
        FileOutputStream outputStream = new FileOutputStream(file2Path);


        byte[] buffer = new byte[inputStream.available()];

        int count = inputStream.read(buffer);
        byte[] copy = new byte[count];
        for (int i = 0; i < count; i++) {
            copy[i] = buffer[buffer.length - i - 1];
        }
        outputStream.write(copy, 0, count);

        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
