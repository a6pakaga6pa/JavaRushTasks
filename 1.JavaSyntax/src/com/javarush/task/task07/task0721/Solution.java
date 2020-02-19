package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 
Минимаксы в массивах
Создать массив на 20 чисел.
Заполнить его числами с клавиатуры.
Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.


*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[20];

        for (int i = 0; i < 20; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        int maximum;
        int minimum;

        maximum = numbers[19];
        minimum = numbers[0];

        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}
