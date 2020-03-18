package com.javarush.task.task19.task1909;

/* 
Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки "." на знак "!".
Результат вывести во второй файл.
Закрыть потоки.


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

        for(String text: list) {
            String newText = text.replace('.', '!');
            fileWriter.write(newText);
        }
        fileWriter.close();


    }
}
