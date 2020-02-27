package com.javarush.task.task18.task1827;

/* 
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "Cp1251"));
        //    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true)));
        //    FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
            int maxId = 0;

            while(reader.ready()) {
                String currentLine = reader.readLine();
                int currentId = Integer.parseInt(currentLine.substring(0,8).trim());
                if (currentId > maxId) maxId = currentId;
            }

            int newId = maxId + 1;

            String id = String.format("%-8d", newId);
            String productName = String.format("%-30s", args[1]);
            if(productName.length() > 30) {
                productName = productName.substring(0,30);
            }
            String price = String.format("%-8s", args[2]);
            String quantity = String.format("%-4s", args[3]);
            writer.write("\n");
            writer.write(id);
            writer.write(productName);
            writer.write(price);
            writer.write(quantity);

            reader.close();
            writer.close();
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }
}
