package com.javarush.task.task18.task1828;

/* 
Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        try {
            if (args[0].equals("-u")) {
                ArrayList<String> list = new ArrayList<>();
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
                while(reader.ready()) {
                    String currentLine = reader.readLine();
                    list.add(currentLine);
                }
                reader.close();
                int newId = Integer.parseInt(args[1]);
                for (int i = 0; i < list.size(); i++) {
                    String currentLineWithoutSpace = list.get(i).substring(0, 8).trim();
                    int currentId = Integer.parseInt(currentLineWithoutSpace.replaceAll("[^0-9]", ""));
                    if (currentId == newId) {
                        String id = String.format("%-8d", newId);
                        String productName = String.format("%-30s", args[2]);
                        String price = String.format("%-8s", args[3]);
                        String quantity = String.format("%-4s", args[4]);
                        String newLine = id + productName + price + quantity;
                        list.set(i, newLine);
                    }
                }

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
                for (String line: list) {
                    writer.write(line);
                    writer.write("\n");
                }
                writer.close();

            } else if (args[0].equals("-d")) {
                FileInputStream inF = new FileInputStream(filePath);
                BufferedReader in = new BufferedReader(new InputStreamReader(inF, "UTF-8"));
                ArrayList<String> list = new ArrayList<>();
                while(in.ready()) {
                    String currentLine = in.readLine();
                    list.add(currentLine);
                }
                reader.close();

                int newId = Integer.parseInt(args[1]);

                Iterator<String> iterator = list.iterator();
                while(iterator.hasNext()) {
                    String next = iterator.next();
                    String line = next.substring(0,8).trim();
                    String lineNew = line.replaceAll("[^0-9]", "");
                    int currentId = Integer.parseInt(lineNew);

                    if (currentId == newId) {
                        iterator.remove();
                    }
                }

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
                for (String line: list) {
                    writer.write(line);
                    writer.write("\n");
                }
                writer.close();
            }
        }catch (ArrayIndexOutOfBoundsException e){

        }

    }
}
