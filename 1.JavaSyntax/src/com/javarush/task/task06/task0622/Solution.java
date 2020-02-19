package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Числа по возрастанию
Числа по возрастанию
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.

Пример ввода:
3
2
15
6
17

Пример вывода:
2
3
6
15
17


*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int first, second, third, fourth, fifth;
        int num1, num2, num3, num4, num5;

        num1 = scanner.nextInt();
        first = num1;

        num2 = scanner.nextInt();
        if (num2 >= first) second = num2;
        else {
            first = num2;
            second = num1;
        }

        num3 = scanner.nextInt();
        if (num3 >= second) third = num3;
            else if (num3 >= first && num3 < second){
                third = second;
                second = num3;
            } else {
                third = second;
                second = first;
                first = num3;
            }

         num4 = scanner.nextInt();
            if (num4 >= third) fourth = num4;
            else if (num4 < third && num4 > second) {
                fourth = third;
                third = num4;
            } else if (num4 < second && num4 > first) {
                fourth = third;
                third = second;
                second = num4;
            } else {
                fourth = third;
                third = second;
                second = first;
                first = num4;
            }

        num5 = scanner.nextInt();
        if (num5 >= fourth) fifth = num5;
        else if (num5 < fourth && num5 > third) {
            fifth = fourth;
            fourth = num5;
        } else if (num5 < third && num5 > second) {
            fifth = fourth;
            fourth = third;
            third = num5;
        } else if (num5 < second && num5 > first) {
            fifth = fourth;
            fourth = third;
            third = second;
            second = num5;}
        else {
                fifth = fourth;
                fourth = third;
                third = second;
                second = first;
                first = num5;
            }





        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);
        System.out.println(fifth);
        //напишите тут ваш код
    }
}
