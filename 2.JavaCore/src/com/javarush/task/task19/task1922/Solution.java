package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
А Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова - подходит, выводим
Д А А Д //2 слова - подходит, выводим


*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
       // String filePath = "C:\\Users\\sereb\\Documents\\all.cfg";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        int count = 0;

        while(bufferedReader.ready()) {
            count = 0;
            String line = bufferedReader.readLine().trim();
            String[] buffer = line.split(" ");
            for (String word : words) {
                for(String item : buffer) {
                    if (word.equals(item)) {
                        count++;
                }
                }
            }
            if(count == 2) System.out.println(line);
        }  bufferedReader.close();
    }
}
