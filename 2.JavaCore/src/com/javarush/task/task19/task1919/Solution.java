package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0


*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        //String filePath = "C:\\Users\\sereb\\Documents\\all.cfg";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> names = new ArrayList<>();
        List<Double> values = new ArrayList<>();
        TreeMap<String, Double> result = new TreeMap<>();

        while(reader.ready()){
            String line = reader.readLine().trim();
            String[] content = line.split(" ");
            names.add(content[0]);
            values.add(Double.parseDouble(content[1]));
        }
        reader.close();

        double valuesSum = 0;
        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < values.size(); j++) {
                String name1 = names.get(i);
                String name2 = names.get(j);
                if(names.get(i).equals(names.get(j))) {
                    valuesSum += values.get(j);
                }
            }
            result.put(names.get(i), valuesSum);
            valuesSum = 0;
        }

        result.forEach((k,v) -> System.out.println(k + " " + v));

    }
}
