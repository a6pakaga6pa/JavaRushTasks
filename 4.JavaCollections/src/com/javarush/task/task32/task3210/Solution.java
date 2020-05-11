package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
В метод main приходят три параметра:
1) fileName - путь к файлу;
2) number - число, позиция в файле;
3) text - текст.

Считать текст с файла начиная с позиции number, длинной такой же как и длинна переданного текста в третьем параметре.
Если считанный текст такой же как и text, то записать в конец файла строку 'true', иначе записать 'false'.
Используй RandomAccessFile и его методы seek(long pos), read(byte[] b, int off, int len), write(byte[] b).
Используй один из конструкторов класса String для конвертации считанной строчки в текст.


*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*String pathFile = "D:\\test\\file.txt";
        int number = 3;
        String text = "Some text";*/
        String pathFile = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

       int textLength = text.length();
       RandomAccessFile raf = new RandomAccessFile(pathFile, "rw");
       byte[] b = new byte[textLength];
       raf.seek(number);
       int count = raf.read(b, 0, textLength);
       String result = new String(b);
       raf.seek(raf.length());
       String t = "true";
       String f = "false";
       if(result.equals(text)) {
           raf.write(t.getBytes());
       } else raf.write(f.getBytes());
       raf.close();

    }
}
