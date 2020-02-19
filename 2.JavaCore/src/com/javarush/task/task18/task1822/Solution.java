package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
      /*  List<Character> data = new LinkedList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);

        while(fileInputStream.available() > 0) {
            int symbol = fileInputStream.read();
            if (symbol != 10){
                char symbolChar = (char)symbol;
                data.add(symbolChar);
            } else if(Character.getNumericValue(data.get(0)) == Integer.parseInt(args[0])) {
                data.forEach(System.out::print);
                break;
            } else data.removeAll(data);
            }
        fileInputStream.close();*/

      reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "Cp1251"));
      while(reader.ready()){
          String line = reader.readLine();
          String[] lineArray = line.split(" ");
          if(lineArray[0].equals(args[0])) {
              System.out.println(line);

          }
      }
        reader.close();


    }
}
