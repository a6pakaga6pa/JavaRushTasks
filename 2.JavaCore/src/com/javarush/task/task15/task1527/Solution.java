package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double: 3.14


*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String objStringValue = "";
        double value = 0;


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        int index = url.indexOf("?");
        String afterQuest = url.substring(index+1);
        String[] params = afterQuest.split("&");
      //  for (String str: params) System.out.println(str);
        for (int i = 0; i < params.length ; i++) {
            if (params[i].contains("obj")) {
                int objPlace = params[i].indexOf("=");
                String objName = params[i].substring(0, objPlace);
                String objValue = params[i].substring(objPlace + 1);
                params[i] = objName;

                try{
                    value = Double.parseDouble(objValue);
                } catch (Exception e) {
                    objStringValue = objValue;
                }

            }
            else if (params[i].contains("=")) {
                String paramsCut = params[i].substring(0, params[i].indexOf("="));
                params[i] = paramsCut;
            }

        }
        for (String str: params) {
            System.out.print(str);
            System.out.print(" ");
        }
        System.out.println("");
        if (value != 0) {
            alert(value);
        }

        if (!objStringValue.equals("")) {
            alert(objStringValue);
        }


    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
