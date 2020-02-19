package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Переверни массив
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Вывести на экран элементы массива в обратном порядке, каждое значение выводить с новой строки.


*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] list = new int[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[list.length - 1 - i]);

        }

        //напишите тут ваш код
    }
}

