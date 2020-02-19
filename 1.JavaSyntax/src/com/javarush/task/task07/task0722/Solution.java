package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Это конец
Создать список строк.
Ввести строки с клавиатуры и добавить их в список.
Вводить с клавиатуры строки, пока пользователь не введет строку "end". Саму строку "end" не учитывать.
Вывести строки на экран, каждую с новой строки.


*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int counter = 0;
        while(true) {
            String string = scanner.nextLine();
            if (!string.equals("end")) {
                list.add(string);
                counter++;
            } else break;

        }

            for (int i = 0; i < counter; i++) {
                System.out.println(list.get(i));
            }

        //напишите тут ваш код

    }
}