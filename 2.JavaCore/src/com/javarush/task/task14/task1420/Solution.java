package com.javarush.task.task14.task1420;

/* 
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.


*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static int number1, number2;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        number1 = Integer.parseInt(reader.readLine());
        number2 = Integer.parseInt(reader.readLine());
        if(number1 <= 0 || number2 <= 0) throw new Exception();

        while (number1 != number2) {
            if (number1 > number2) {
                number1 = number1 - number2;
            } else {
                number2 = number2 - number1;
            }
        }
        System.out.println(number1);

        /*List<Integer> array1 = new ArrayList<>();
        List<Integer> array2 = new ArrayList<>();


        for (int i = 2; i <= number1; i++) {
            if (number1 == 1) {
               break;
            } else {
                int a = number1 % i;
                if (a == 0) {
                    number1 = number1 / i;
                    array1.add(i);
                    i = 1;
                }
            }
        }

        for (int i = 2; i <= number2; i++) {
            if (number2 == 1) {
               break;
            } else {
                int a = number2 % i;
                if (a == 0) {
                    number2 = number2 / i;
                    array2.add(i);
                    i = 1;
                }
            }
        }

        array1.sort(Comparator.reverseOrder());
        array2.sort(Comparator.reverseOrder());

        int nod = 1;

        for (int i = 0; i < array1.size() - 1; i++) {
           if (array2.get(0).equals(array1.get(i))) {
               nod = array1.get(i);
               break;
           }

        }
        System.out.println(nod);*/
        reader.close();


    }
}

