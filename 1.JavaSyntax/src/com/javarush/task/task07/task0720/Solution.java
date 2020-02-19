package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Перестановочка подоспела
Ввести с клавиатуры 2 числа N и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.

Примечание: запрещено создавать больше одного списка.


*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(i, scanner.next());
        }

        for (int i = 0; i < m; i++) {
            int firstElement = list.size();

            list.add(list.size(), list.get(0));
            list.remove(0);
        }

        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));

        }

        //напишите тут ваш код
    }
}
