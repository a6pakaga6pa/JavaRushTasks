package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Общение одиноких массивов
1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк, индекс/номер ячейки которой совпадает с текущим индексом из массива чисел.

Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.


*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] text = new String[10];
        int[] num = new int[10];

        for (int i = 0; i < 10; i++) {
            text[i] = scanner.nextLine();
            num[i] = text[i].length();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println(num[i]);
        }

        }
        //напишите тут ваш код
    }

