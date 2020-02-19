package com.javarush.task.task18.task1826;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.



*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args[0].equals("-e")) {
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            while(inputStream.available() > 0) {
                outputStream.write((inputStream.read())+5);
            }
            inputStream.close();
            outputStream.close();
        } else if(args[0].equals("-d")) {
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            while(inputStream.available() > 0) {
                outputStream.write((inputStream.read())-5);
            }
            inputStream.close();
            outputStream.close();
        }
    }
}
