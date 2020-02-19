package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Проверка на упорядоченность
1. Введи с клавиатуры 10 слов в список строк.
2. Определить, является ли список упорядоченным по возрастанию длины строки.
3. В случае отрицательного ответа вывести на экран индекс первого элемента, нарушающего такую упорядоченность.


*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10 ; i++) {
            list.add(i, scanner.nextLine());
        }

        int currentLength = 0;
        for (int i = 0; i < 10; i++) {
            int length = list.get(i).length();
            if (length <= currentLength) {
                System.out.println(i);
                break;}
            else currentLength = list.get(i).length();

        }
        //напишите тут ваш код
    }
}

