package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3. Должна быть выведена одна строка.


*/

public class Solution {


    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int min;
        int max;
        int minIndex = 0;
        int maxIndex = 0;


        for (int i = 0; i < 10 ; i++) {
            list.add(i, scanner.nextLine());

        }

        min = list.get(0).length();
        max = list.get(0).length();

        for (int i = 0; i < 10 ; i++) {
            if (list.get(i).length() < min){
                min = list.get(i).length();
                minIndex = i;
            }
            if (list.get(i).length() > max){
                max = list.get(i).length();
                maxIndex = i;
            }

        }

if (minIndex < maxIndex) System.out.println(list.get(minIndex));
        else System.out.println(list.get(maxIndex));



        //напишите тут ваш код
    }
}
