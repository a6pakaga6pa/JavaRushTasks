package com.javarush.task.task13.task1315;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Solution {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = null;
        BufferedInputStream buffer = null;

        try {

            inputStream = new FileInputStream("C:\\Users\\sereb\\Documents\\1.cfg");

            buffer = new BufferedInputStream(inputStream);

            while(buffer.available()>0) {

                char c = (char)buffer.read();

                System.out.println("Был прочитан символ " + c);
            }
        } catch(Exception e) {

            e.printStackTrace();

        } finally {

            inputStream.close();
            buffer.close();
        }
    }
}
