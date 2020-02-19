package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Выражаемся покороче
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.


*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> minList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String text;
        String a;
        for (int i = 0; i <5 ; i++) {
            a = scanner.nextLine();
            list.add(i, a);
            }

        int min = (list.get(0)).length();
        String minElement = null;
        for (int i = 1; i < 5; i++) {
            text = list.get(i);
            if(text.length()<=min) min = text.length();

        }
        for (int i = 0; i < 5; i++) {
            if(list.get(i).length()==min) System.out.println(list.get(i));

        }

        //напишите тут ваш код
    }
}
