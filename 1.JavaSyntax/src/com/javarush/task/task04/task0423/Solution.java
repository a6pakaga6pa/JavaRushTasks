package com.javarush.task.task04.task0423;

/* 
Фейс-контроль
Ввести с клавиатуры имя и возраст. Если возраст больше 20 вывести надпись "И 18-ти достаточно".


*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int num = scanner.nextInt();
        if(num>20) System.out.println("И 18-ти достаточно");
        //напишите тут ваш код

    }
}
