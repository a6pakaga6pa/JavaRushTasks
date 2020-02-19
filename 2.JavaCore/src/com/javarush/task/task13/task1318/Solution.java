package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = null;
        BufferedInputStream buffer = null;

        try {
            String path = reader.readLine();
            inputStream = new FileInputStream(path);
            buffer = new BufferedInputStream(inputStream);
            while(buffer.available() > 0) {
                char c = (char)buffer.read();
                System.out.print(c);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            inputStream.close();
            buffer.close();
            reader.close();
        }
        // напишите тут ваш код
    }
}