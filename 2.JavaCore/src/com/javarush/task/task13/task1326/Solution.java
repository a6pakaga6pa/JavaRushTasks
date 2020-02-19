package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10


*/

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader = new BufferedReader(new InputStreamReader(fileInputStream));
        ArrayList<Integer> list = new ArrayList<>();
        String line;
        while ((line = reader. readLine())!=null){
            int number = Integer.parseInt(line);
            if (number%2==0) {
                list.add(number);
            }
        }

        reader.close();
        fileInputStream.close();

        Collections.sort(list);

        for (Integer i : list) System.out.println(i);

        // напишите тут ваш код
    }
}
