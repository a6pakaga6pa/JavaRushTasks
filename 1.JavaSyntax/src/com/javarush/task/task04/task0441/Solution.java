package com.javarush.task.task04.task0441;

/* 
Как-то средненько
Ввести с клавиатуры три числа, вывести на экран среднее из них.
Т.е. не самое большое и не самое маленькое.
Если все числа равны, вывести любое из них.


*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        if(num1>=num2 && num1>=num3 && num3 <= num2) System.out.println(num2);
        else if(num2>=num3 && num2>=num1 && num3 <= num1) System.out.println(num1);
        else if(num3>=num1 && num3>=num2 && num2 <= num1) System.out.println(num1);
        else if(num3>=num1 && num3>=num2 && num2 >= num1) System.out.println(num2);
        else System.out.println(num3);


        //напишите тут ваш код

    }
}
