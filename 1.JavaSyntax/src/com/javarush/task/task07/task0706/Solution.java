package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Улицы и дома
1. Создать массив на 15 целых чисел.
2. Ввести в него значения с клавиатуры.
3. Пускай индекс элемента массива является номером дома, а значение - число жителей, проживающих в доме.
Дома с нечетными номерами расположены на одной стороне улицы, с четными - на другой. Выяснить, на какой стороне улицы проживает больше жителей.
4. Вывести на экран сообщение: "В домах с нечетными номерами проживает больше жителей." или "В домах с четными номерами проживает больше жителей."

Примечание:
дом с порядковым номером 0 считать четным.


*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] big = new int[15];
        int[] even = new int[8];
        int[] odd = new int[7];
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i <15 ; i++) {
            big[i] = scanner.nextInt();
        }

        for (int i = 0; i <8 ; i++) {
            even[i] = big[i*2];
            sumEven += even[i];
        }

        for (int i = 0; i <7 ; i++) {
            odd[i] = big[2*i+1];
            sumOdd += odd[i];
        }

        if(sumEven>sumOdd) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");


        //напишите тут ваш код
    }
}
