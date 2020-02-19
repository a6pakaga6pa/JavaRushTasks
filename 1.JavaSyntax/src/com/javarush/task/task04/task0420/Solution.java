package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
Выведенные числа должны быть разделены пробелом.


*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        int first;
        int second;
        if (num1>=num2 && num1>=num3 && num2>=num3)
            System.out.println(num1+" "+num2+" "+num3);
         else if(num1>=num2 && num1>=num3 && num2<=num3)
            System.out.println(num1+" "+num3+" "+num2);
        else if(num2>=num1 && num2>=num3 && num1>=num3)
            System.out.println(num2+" "+num1+" "+num3);
        else if(num2>=num1 && num2>=num3 && num1<=num3)
            System.out.println(num2+" "+num3+" "+num1);
        else if(num3>=num1 && num3>=num2 && num1>=num2)
            System.out.println(num3+" "+num1+" "+num2);
        else if(num3>=num1 && num3>=num2 && num1<=num2)
            System.out.println(num3+" "+num2+" "+num1);

        //напишите тут ваш код

    }
}
