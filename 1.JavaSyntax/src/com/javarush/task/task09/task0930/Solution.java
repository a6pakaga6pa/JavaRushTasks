package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел).
Слова вывести в возрастающем порядке, числа - в убывающем.

Пример ввода:
Вишня
1
Боб
3
Яблоко
22
0
Арбуз

Пример вывода:
Арбуз
22
Боб
3
Вишня
1
0
Яблоко
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> numbersOrder = new ArrayList<>();
        ArrayList<Integer> wordsOrder = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                numbers.add(Integer.parseInt(array[i]));
                numbersOrder.add(i);
            } else {
                words.add(array[i]);
                wordsOrder.add(i);
            }
        }

        Collections.sort(numbers);
        ArrayList<Integer> numbersDesc = new ArrayList<>();
        for (int i = 0; i < numbers.size() ; i++) {
            numbersDesc.add(i, numbers.get(numbers.size() - i - 1));
        }

       // Collections.sort(words);

        String[] wordsArray = new String[words.size()];
        for (int i = 0; i < wordsArray.length; i++) {
            wordsArray[i] = words.get(i);
        }

        for(int i = 0; i< wordsArray.length; i++) {
            for (int j = i+1; j < wordsArray.length; j++) {
                if(isGreaterThan(wordsArray[i], wordsArray[j])) {
                    String temp = wordsArray[i];
                    wordsArray[i] = wordsArray[j];
                    wordsArray[j] = temp;
                }
            }
        }

        for (int i = 0; i < numbersDesc.size(); i++) {
            int test = numbersOrder.get(i);
            array[test] = String.valueOf(numbersDesc.get(i));

        }

        for (int i = 0; i < wordsArray.length; i++) {
            int test = wordsOrder.get(i);
            array[test] = wordsArray[i];

        }




        // напишите тут ваш код
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
