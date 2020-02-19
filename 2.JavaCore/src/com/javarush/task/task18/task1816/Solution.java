package com.javarush.task.task18.task1816;

/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {


        FileInputStream inputStream = new FileInputStream(args[0]);
        byte[] fileContent = new byte[inputStream.available()];
        int bytesAmount = inputStream.read(fileContent);
        int count = 0;

        for (int i = 0; i < bytesAmount; i++) {
            if((fileContent[i] > 64 && fileContent[i] < 91) || (fileContent[i] > 96 && fileContent[i] < 123)) {
                count++;
            }
        }
        inputStream.close();
        System.out.println(count);

    }
}
