package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1Path = reader.readLine();
        String file2Path = reader.readLine();
        String file3Path = reader.readLine();

        FileInputStream file2InputStream = new FileInputStream(file2Path);
        FileInputStream file3InputStream = new FileInputStream(file3Path);
        FileOutputStream file1OutputStream = new FileOutputStream(file1Path, true);

        while(file2InputStream.available() > 0) {
            int data = file2InputStream.read();
            file1OutputStream.write(data);
        }

        while(file3InputStream.available() > 0) {
            int data = file3InputStream.read();
            file1OutputStream.write(data);
        }

        reader.close();
        file1OutputStream.close();
        file2InputStream.close();
        file3InputStream.close();

    }
}
