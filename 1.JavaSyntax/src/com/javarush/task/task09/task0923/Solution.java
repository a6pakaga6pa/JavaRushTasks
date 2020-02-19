package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Гласные и согласные
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы из введённой строки.
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
Пример ввода:
Мама мыла раму.

Пример вывода:
а а ы а а у
М м м л р м .


*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        char[] textChar = text.toCharArray();
        ArrayList<Character> vowelsList = new ArrayList<>();
        ArrayList<Character> notVowelsList = new ArrayList<>();
        for (int i = 0; i < textChar.length ; i++) {
            if (isVowel(textChar[i])) {
                vowelsList.add(textChar[i]);
            } else if (textChar[i] != ' ') {
                notVowelsList.add(textChar[i]);
            }
        }


        for (char vowels: vowelsList) {
            System.out.print(vowels + " ");
        }

        System.out.println();

        for (char notVowels: notVowelsList) {
            System.out.print(notVowels + " ");
        }


        //напишите тут ваш код
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}