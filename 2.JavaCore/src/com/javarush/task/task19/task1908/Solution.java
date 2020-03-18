package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1


*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Path = reader.readLine();
        String file2Path = reader.readLine();

        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file1Path));
        List<String> list = new ArrayList<>();
        while(fileReader.ready()) {
            list.add(fileReader.readLine());
            }

        fileReader.close();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2Path));

        for(String line : list) {
            String[] elements = line.split(" ");
            for (String element : elements) {
                try {
                    int a = Integer.parseInt(element);
                    fileWriter.write(a + " ");
                } catch (Exception e) {

                }
            }
        }
        fileWriter.close();
    }
}
