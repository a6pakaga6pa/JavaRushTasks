package com.javarush.task.task19.task1925;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура


*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {

        /*String file1Path = args[0];
        String file2Path = args[1];*/
        String file1Path = "C:\\Users\\sereb\\Documents\\file1.txt";
        String file2Path = "C:\\Users\\sereb\\Documents\\file2.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file1Path));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2Path));
        ArrayList<String> list = new ArrayList<String>();

        while(reader.ready()) {
            String[] words = reader.readLine().split(" ");
            list.addAll(Arrays.asList(words));
        }

        reader.close();

        int counter = 0;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).length() > 6) {
                writer.write(list.get(i));
                counter = i;
                break;
            }
        }

        for (int i = counter + 1; i < list.size() ; i++) {
            if(list.get(i).length() > 6) {
                writer.write("," + list.get(i));
            }

        }

        writer.close();

    }
}
