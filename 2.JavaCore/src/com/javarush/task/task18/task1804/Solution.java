package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(path);
        List<Integer> allData = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int data = 0;
        while (fileInputStream.available() > 0) {
            data = fileInputStream.read();
            allData.add(data);
        }

        for (int i = 0; i < allData.size(); i++) {
            int freq = Collections.frequency(allData, allData.get(i));
            map.put(allData.get(i), freq);
        }

        Map.Entry<Integer, Integer> minEntry = null;
        int minValue = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0)
            {
                minEntry = entry;
                minValue = minEntry.getValue();
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (entry.getValue() == minValue) {
                System.out.print(entry.getKey() + " ");
            }

        }

        reader.close();
        fileInputStream.close();
    }
}
