package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
Написать метод, который вычисляет факториал - произведение всех чисел от 1 до введенного числа включая его.

Пример вычислений: 4! = factorial(4) = 1*2*3*4
Пример вывода: 24

1. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 1



*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {

        if (n < 0) return "0";
        long fact = 1;
        BigInteger bi = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }
        String result = bi.toString();

        return result;


       /* double result = 0;
        int number = 0;
        if (n < 0)  {
            return "0";
        } else if (n == 0 || n == 1) {
            return "1";
        } else if (n <= 150) {

            for (int i = 1; i < n; i++) {
                if (i == 1) {
                    result = (n * (n - i));
                } else {
                    result = result * (n - i);
                }
            }
        } return Double.toString(result);*/
    }
}

