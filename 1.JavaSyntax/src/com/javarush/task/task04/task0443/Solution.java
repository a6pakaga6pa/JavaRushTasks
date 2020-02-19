package com.javarush.task.task04.task0443;

/* 
Как назвали, так назвали
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.


Вывести на экран текст:
"Меня зовут name.
Я родился d.m.y"



*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        System.out.println("Меня зовут "+name+".\nЯ родился "+day+"."+month+"."+year);


    }
}
