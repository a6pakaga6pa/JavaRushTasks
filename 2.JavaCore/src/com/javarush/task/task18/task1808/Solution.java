package com.javarush.task.task18.task1808;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        //opening streams
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
        FileOutputStream fileOutputStream3 = new FileOutputStream(file3);

        //buffer for all file content
        byte[] buffer = new byte[fileInputStream.available()];

        //bytes amount of all file
        int count = fileInputStream.read(buffer);

        if(count%2 == 0) {
            fileOutputStream2.write(buffer, 0, count/2);
            fileOutputStream3.write(buffer, count/2, count/2);
        } else {
            fileOutputStream2.write(buffer, 0, count/2 + 1);
            fileOutputStream3.write(buffer, count/2 + 1, count/2);
        }

        reader.close();
        fileInputStream.close();
        fileOutputStream2.close();
        fileOutputStream3.close();

    }
}
