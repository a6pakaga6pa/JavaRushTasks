package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
. Создай список из слов "мама", "мыла", "раму".
2. После каждого слова вставь в список строку, содержащую слово "именно".
3. Вывести результат на экран, каждый элемент списка с новой строки.


*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add(0, "мама");
        list.add(1, "мыла");
        list.add(2, "раму");

        for (int i = 0; i <3 ; i++) {
            list.add(list.size() - 2 +i , "именно");
        }

        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }
        //напишите тут ваш код
    }
}
