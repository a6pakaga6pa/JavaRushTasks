package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
Ввести с клавиатуры число.
Если число положительное, то увеличить его в два раза.
Если число отрицательное, то прибавить единицу.
Если введенное число равно нулю, необходимо вывести ноль.
Вывести результат на экран.


*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number > 0) {
            number = number*2;
            System.out.println(number);
        } else if (number < 0) {
            number = number + 1;
            System.out.println(number);
        } else {
            System.out.println(number);
        }
        //напишите тут ваш код

    }

}