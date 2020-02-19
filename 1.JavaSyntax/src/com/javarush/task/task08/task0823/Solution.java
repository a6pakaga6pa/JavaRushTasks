package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
мама мыла раму.

Пример вывода:
Мама Мыла Раму.


*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String[] allWords = string.split(" ");
        for (int i = 0; i < allWords.length; i++) {
            if (!allWords[i].equals("")) {
                allWords[i] = allWords[i].substring(0, 1).toUpperCase() + allWords[i].substring(1);
                System.out.print(allWords[i] + " ");
            } else System.out.print(" ");

            //напишите тут ваш код
        }
    }
}
