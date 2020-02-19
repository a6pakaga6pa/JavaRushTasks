package com.javarush.task.task04.task0413;

/* 
День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название
"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье",
если введен номер больше 7 или меньше 1 - вывести "такого дня недели не существует".

Пример для номера 5:
пятница

Пример для номера 10:
такого дня недели не существует


*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int dow = scanner.nextInt();
        if (dow==1) System.out.println("понедельник");
        else if (dow==2) System.out.println("вторник");
        else if (dow==3) System.out.println("среда");
        else if (dow==4) System.out.println("четверг");
        else if (dow==5) System.out.println("пятница");
        else if (dow==6) System.out.println("суббота");
        else if (dow==7) System.out.println("воскресенье");
        else System.out.println("такого дня недели не существует");
        //напишите тут ваш код

    }
}