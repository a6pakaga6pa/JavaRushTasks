package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
В начало списка
1. Создай список строк в методе main.
2. Добавь в него 10 строчек с клавиатуры, но только добавлять не в конец списка, а в начало.
3. Используя цикл выведи содержимое на экран, каждое значение с новой строки.


*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String a;
        for (int i = 0; i <10 ; i++) {
            a = scanner.nextLine();
            list.add(0, a);
            
        }

        for (int i = 0; i <10 ; i++) {
            System.out.println(list.get(i));

        }

        //напишите тут ваш код
    }
}
