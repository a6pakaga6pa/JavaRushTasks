package com.javarush.task.task18.task1817;

/* 
Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.


*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        byte[] fileContent = new byte[inputStream.available()];
        int bytesAmount = inputStream.read(fileContent);
        int spaceCount = 0;

        for (int i = 0; i < bytesAmount; i++) {
            if(fileContent[i] == 32) spaceCount++;
        }

        String formattedDouble = String.format("%.2f", (double)spaceCount/bytesAmount*100);
        System.out.println(formattedDouble);
        inputStream.close();

    }
}
