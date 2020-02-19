package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Массивный максимум
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива


*/

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        int[] list = new int[20];
        for (int i = 0; i < 20 ; i++) {
            list[i] = scanner.nextInt();

        }
        // создай и заполни массив
        return list;
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]>max) max = array[i];

        }

        // найди максимальное значение
        return max;
    }
}
