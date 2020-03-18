package com.javarush.task.task19.task1926;

/* 
Перевертыши
1. Считать с консоли имя файла. Считать содержимое файла.
2. Для каждой строки в файле:
2.1. переставить все символы в обратном порядке.
2.2. вывести на экран.
3. Закрыть потоки.

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА


*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();

      //  String filePath = "C:\\Users\\sereb\\Documents\\file.cfg";
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));


        while(fileReader.ready()){
            String line = fileReader.readLine();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length ; i++) {
                System.out.print(chars[chars.length - i - 1]);
            }
            System.out.println("");
        }

        reader.close();
        fileReader.close();

    }
}
