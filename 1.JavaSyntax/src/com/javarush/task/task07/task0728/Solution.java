package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/* 
В убывающем порядке
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.


*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {

        Arrays.sort(array);
        int[] newArray = new int[20];
        for (int i = 0; i < array.length ; i++) {
            newArray[i] = array[array.length - 1 - i];
        }
        for (int i = 0; i < newArray.length ; i++) {
            array[i] = newArray[i];



        //напишите тут ваш код
    }
}
}
