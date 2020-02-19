package com.javarush.task.task04.task0428;

/* 
Положительное число
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел среди этих трех.

Примеры:
а) при вводе чисел
-4
6
6
получим вывод
2

б) при вводе чисел
-6
-6
-3
получим вывод
0
в) при вводе чисел
0
1
2
получим вывод
2

*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int count = 0;

        if (a>0) {
            count++;
            if(b>0){
                count++;
                if(c>0) count++;
            }else if(c>0) count++;
        } else if(b>0) {
            count++; if(c>0){
                count++;
            }
        } else if(c>0)
            count++;
        System.out.println(count);
        //напишите тут ваш код

    }
}
