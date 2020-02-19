package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() - читает с клавиатуры строку
int readInt() - читает с клавиатуры число
double readDouble() - читает с клавиатуры дробное число
boolean readBoolean() - читает с клавиатуры строку "true" или "false" и возвращает соответствующую логическую переменную true или false

Внимание: создавайте переменную для чтения данных с консоли (BufferedReader или Scanner) внутри каждого метода.


*/

public class ConsoleReader {


    public static String readString() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String num3 = scanner.nextLine();
        return num3;


        //напишите тут ваш код

    }

    public static int readInt() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        return num1;
        //напишите тут ваш код

    }

    public static double readDouble() throws Exception {
        Scanner scanner = new Scanner(System.in);
        double num2 = scanner.nextDouble();
        return num2;

        //напишите тут ваш код

    }

    public static boolean readBoolean() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean num4 = scanner.nextBoolean();
        return num4;
        //напишите тут ваш код

    }

    public static void main(String[] args) throws Exception {

        readString();
        System.out.println(readString());

    }
}
