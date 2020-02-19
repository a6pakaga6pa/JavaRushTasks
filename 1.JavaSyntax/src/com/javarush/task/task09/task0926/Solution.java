package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.Scanner;

/* 
Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов-массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.



*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> array = new ArrayList<>();
        int[] first = new int[5];
        for (int i = 0; i < 5; i++) {
            int random = (int)(Math.random()*1000);
            first[i] = random;
        }
        int[] second = new int[2];
        for (int i = 0; i < 2; i++) {
            int random = (int) (Math.random() * 1000);
            second[i] = random;
        }
        int[] third = new int[4];
        for (int i = 0; i < 4; i++) {
            int random = (int) (Math.random() * 1000);
            third[i] = random;
        }
        int[] fourth = new int[7];
        for (int i = 0; i < 7; i++) {
            int random = (int) (Math.random() * 1000);
            fourth[i] = random;
        }
        int[] fifth = new int[0];
        array.add(first);
        array.add(second);
        array.add(third);
        array.add(fourth);
        array.add(fifth);

        //напишите тут ваш код
        return array;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
