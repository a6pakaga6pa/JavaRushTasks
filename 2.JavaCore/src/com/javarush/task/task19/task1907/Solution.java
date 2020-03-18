package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathName = reader.readLine();

        FileReader fileReader = new FileReader(pathName);
        StringBuilder builder = new StringBuilder();
        int count = 0;
        while(fileReader.ready()){
            char symbol = (char)fileReader.read();
            builder.append(symbol);
        }

        String[] allText = builder.toString().split("\\W+");
        for (int i = 0; i < allText.length; i++) {
            if(allText[i].equals("world")) count++;
        }
       // System.out.println(Arrays.toString(allText));
        System.out.println(count);
        reader.close();
        fileReader.close();

    }
}
