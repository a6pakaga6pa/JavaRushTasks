package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3

Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.


*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();

        int max;
        int count= 1;
        for (int i = 0; i < 10 ; i++) {
            int currentNum = scanner.nextInt();
            list.add(i, currentNum);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            if (i != 9) {
                if (list.get(i).equals(list.get(i - 1))) {

                    count++;
                } else {
                    result.add(0, count);
                    count = 1;
                }

            } else {
                if (list.get(i).equals(list.get(i - 1))) {
                    count++;
                    result.add(0, count);
                } else {
                    result.add(0, count);
                    count = 1;
                }
            }
        }
        max = Collections.max(result);
        System.out.println(max);


        //напишите тут ваш код

    }
}