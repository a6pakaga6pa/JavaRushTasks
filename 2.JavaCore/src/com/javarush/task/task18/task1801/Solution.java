package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

/* 
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(path);

        int maxByte = 0;
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if(data > maxByte) maxByte = data;
        }

        System.out.println(maxByte);
        reader.close();
        fileInputStream.close();

    }
}
