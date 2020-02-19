package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.

Пример вывода на экран:
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS
SSSSSSSSSS


*/

public class Solution {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        while (b<=10) {
            a=1;
            while (a <= 10) {
                System.out.print("S");
                a++;
            }
            System.out.println();
            b++;
        }


        }
    }
