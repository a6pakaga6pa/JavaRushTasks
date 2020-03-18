package com.javarush.task.task19.task1906;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод



*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath1 = reader.readLine();
        String filePath2 = reader.readLine();

        reader.close();

        FileReader fileReader = new FileReader(filePath1);
        FileWriter fileWriter = new FileWriter(filePath2);
        int count = 0;
        while(fileReader.ready()) {
            int data = fileReader.read();
            count++;
            if(count%2 == 0) {
                fileWriter.write(data);
            }
        }
        fileReader.close();
        fileWriter.close();

    }
}
