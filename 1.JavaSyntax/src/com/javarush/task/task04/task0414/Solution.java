package com.javarush.task.task04.task0414;

/* 
Количество дней в году
Ввести с клавиатуры год, определить количество дней в году. Результат вывести на экран в следующем виде:
количество дней в году: x
, где
х - 366 для високосного года,
х - 365 для обычного года.

Подсказка:
В високосном году - 366 дней, тогда как в обычном - 365.
1) если год делится без остатка на 400 это високосный год;
2) в оставшихся годах после этого, если год делится без остатка на 100, то это обычный год;
3) в оставшихся годах после этого, если год делится без остатка на 4, то это високосный год;
4) все оставшиеся года невисокосные.
Так, годы 1700, 1800 и 1900 не являются високосными, так как они кратны 100 и не кратны 400.
Годы 1600 и 2000 - високосные, так как они кратны 100 и кратны 400.
Годы 2100, 2200 и 2300 - не високосные.


*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int bigYear = 366;
        int smallYear = 365;
        int a = year%400;
        int b = year%100;
        int c = year%4;
        String option1 = "количество дней в году: "+bigYear;
        String option2 = "количество дней в году: "+smallYear;

        if (a == 0) System.out.println(option1);
        else if (b == 0) System.out.println(option2);
        else if (c ==0) System.out.println(option1);
        else System.out.println(option2);

        //напишите тут ваш код

    }
}