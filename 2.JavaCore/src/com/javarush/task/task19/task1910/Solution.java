package com.javarush.task.task19.task1910;

/* 
Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.

Закрыть потоки.


*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Path = reader.readLine();
        String file2Path = reader.readLine();

        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file1Path));
        Writer out;
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2Path));
        while(fileReader.ready()) {
            String newLine = fileReader.readLine().replaceAll("\\p{Punct}", "");
            fileWriter.write(newLine);
        }
        fileReader.close();
        fileWriter.close();

    }
}
