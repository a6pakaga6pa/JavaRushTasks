package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.Scanner;

/* 
Задача по алгоритмам
Написать программу, которая:
1. считывает с консоли число N, которое должно быть больше 0
2. потом считывает N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.


*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int maximum = 0;
            int n = scanner.nextInt();
            if(n > 0) {

                for (int i = 1; i <= n; i++) {

                    int num = scanner.nextInt();
                    if(i==1) {
                        maximum = num;
                    } else if(num>=maximum) maximum=num;

                }
                System.out.println(maximum);
            }



        //напишите тут ваш код


    }
}
