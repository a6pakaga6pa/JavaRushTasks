package com.javarush.task.task19.task1920;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
      //  String filePath = "C:\\Users\\sereb\\Documents\\all.cfg";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        TreeMap<String, Double> result = new TreeMap<>();

        while(reader.ready()){
            String line = reader.readLine().trim();
            String[] content = line.split(" ");
            double currentValue = Double.parseDouble(content[1]);
            result.merge(content[0], currentValue, (oldVal, newVal) -> oldVal + newVal);
         //   result.forEach((k, v) -> System.out.println(k + " " + v));
         //   System.out.println(" ");
        }
        reader.close();

     //   result.forEach((k, v) -> System.out.println(k + " " + v));
     /*   result.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(System.out::println);*/

     double max = 0;
     for(Map.Entry<String, Double> pair : result.entrySet()) {
         double value = pair.getValue();
         if(value > max) max = value;
     }

        for(Map.Entry<String, Double> pair : result.entrySet()) {
            if(pair.getValue() == max) {
                System.out.println(pair.getKey());
            }
        }
    }
}
