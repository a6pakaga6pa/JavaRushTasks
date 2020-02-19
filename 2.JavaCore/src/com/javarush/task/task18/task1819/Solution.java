package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1Path = reader.readLine();
        String file2Path = reader.readLine();

        FileInputStream file1InputStream = new FileInputStream(file1Path);
        byte[] buffer1File = new byte[file1InputStream.available()]; // contains 1 file content
        int count1 = file1InputStream.read(buffer1File);

        FileOutputStream file1OutputStream = new FileOutputStream(file1Path);
        FileInputStream file2InputStream = new FileInputStream(file2Path);

        byte[] buffer2File = new byte[file2InputStream.available()]; // contains 2 file content
        int count2 = file2InputStream.read(buffer2File);

        file1OutputStream.write(buffer2File);
        file1OutputStream.write(buffer1File);

        reader.close();
        file1OutputStream.close();
        file2InputStream.close();
        file1InputStream.close();


    }
}
