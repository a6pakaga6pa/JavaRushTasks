package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*String file1Path = "C:\\Users\\sereb\\Documents\\file1.txt";
        String file2Path = "C:\\Users\\sereb\\Documents\\file2.txt";*/
        String file1Path = args[0];
        String file2Path = args[1];
        BufferedReader reader = new BufferedReader(new FileReader(file1Path));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2Path));

        while(reader.ready()) {
            String line = reader.readLine();
            String[] buf = line.split(" ");
            for(String word : buf) {
                for (int i = 0; i < word.length(); i++) {
                    if(Character.isDigit(word.charAt(i))){
                        writer.write(word + " ");
                        break;
                    }
                }
            }
        }
        reader.close();
        writer.close();

    }
}
