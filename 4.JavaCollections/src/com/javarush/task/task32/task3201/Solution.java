package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
В метод main приходят три параметра:
1) fileName - путь к файлу;
2) number - число, позиция в файле;
3) text - текст.
Записать text в файл fileName начиная с позиции number.
Запись должна производиться поверх старых данных, содержащихся в файле.
Если файл слишком короткий, то записать в конец файла.
Используй RandomAccessFile и его методы seek и write.


*/
public class Solution {
    public static void main(String... args) throws IOException {
        /*String pathFile = "D:\\test\\file.txt";
        int number = 23;
        String text = "Some text";*/
        int number = Integer.parseInt(args[1]);
        String pathFile = args[0];
        String text = args[2];
                RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        if(randomAccessFile.length() > number){
            randomAccessFile.seek(number);

        } else {
            randomAccessFile.seek(randomAccessFile.length());
        }
        randomAccessFile.write(text.getBytes());

        randomAccessFile.close();

    }
}
