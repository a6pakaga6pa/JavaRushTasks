package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.

Подсказка:
нужно сравнивать с ascii-кодом символа ','.


*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution  {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath =  reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int count = 0;

        while(fileInputStream.available() > 0) {
            int symbol = fileInputStream.read();

            if(symbol == 44) count++;
        }
        reader.close();
        fileInputStream.close();
        System.out.println(count);
    }
}
