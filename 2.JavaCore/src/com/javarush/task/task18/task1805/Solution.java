package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83


*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(path);
        List<Integer> allData = new ArrayList<>();


        int data = 0;
        while (fileInputStream.available() > 0) {
            data = fileInputStream.read();
            allData.add(data);
        }
        fileInputStream.close();
        reader.close();

        Collections.sort(allData);
        int min = allData.get(0);
        System.out.print(min + " ");
        for (int i = 1; i < allData.size(); i++) {
            if(allData.get(i) != min) {
                System.out.print(allData.get(i));
                System.out.print(" ");
                min = allData.get(i);
            }
        }


   //     allData.forEach(x -> System.out.print(x + " "));
    }
}
