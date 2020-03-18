package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.


*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();
      //  String filePath = "C:\\Users\\sereb\\Documents\\file.cfg";
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));

        while(fileReader.ready()) {
            final String[] line = {fileReader.readLine()};
            map.forEach((key, value) -> line[0] = line[0].replaceAll("\\b" + key + "\\b", value));
            System.out.println(line[0]);
        }
       /* while(fileReader.ready()){
            lines.add(fileReader.readLine());
        }

        fileReader.close();
       // lines.add(fileReader.readLine());

        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i).split(" ");
            for (int j = 0; j < words.length; j++) {
                for (Map.Entry<Integer, String> pair : map.entrySet()) {
                    int key = pair.getKey();
                    String a = String.valueOf(key);
                    String b = words[j];
                    if(String.valueOf(key).equals(words[j])) {
                        words[j] = pair.getValue();
                        break;
                    }
                }
            }
            String newLine = "";
            for (int j = 0; j < words.length; j++) {
                newLine += words[j] + " ";
            }
            System.out.println(newLine);
        }*/
    }
}
