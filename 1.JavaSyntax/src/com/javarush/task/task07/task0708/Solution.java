package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран. Если таких строк несколько, выведи каждую с новой строки.


*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String text;
        String a;
        for (int i = 0; i <5 ; i++) {
            strings.add(i, scanner.nextLine());
        }

        int max = (strings.get(0)).length();
        String maxElement = null;
        for (int i = 1; i < 5; i++) {
            text = strings.get(i);
            if(text.length()>=max) max = text.length();

        }
        for (int i = 0; i < 5; i++) {
            if(strings.get(i).length()==max) System.out.println(strings.get(i));

        }

        }
        //напишите тут ваш код
    }

