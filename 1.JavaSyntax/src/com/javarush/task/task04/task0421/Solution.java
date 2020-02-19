package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение "Имена идентичны".
Если имена разные, но их длины равны - вывести сообщение - "Длины имен равны".
Если имена и длины имен разные - ничего не выводить.


*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.next();
        String name2 = scanner.next();
        if (name1.equals(name2)) System.out.println("Имена идентичны");
        else if(name1.length() == name2.length()) System.out.println("Длины имен равны");

        //напишите тут ваш код

    }
}
