package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе, в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б",
где а, б - искомые значения.

Пример:
а) при вводе чисел
2
5
6
получим вывод
количество отрицательных чисел: 0
количество положительных чисел: 3

Пример:
б) при вводе чисел
-2
-5
6
получим вывод
количество отрицательных чисел: 2
количество положительных чисел: 1


*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int countPositive = 0;
        int countNegative = 0;

        if (a>0){
            countPositive++;
            if (b>0) {
                countPositive++;
                if(c>0) {
                    countPositive++;
                } else { if (c!=0)
                    countNegative++;
                }
            } else { if (b!=0)
                countNegative++;
                if(c>0) {
                    countPositive++;
                } else { if (c!=0)
                    countNegative++;
                }
            }
        } else { if (a!=0)
            countNegative++;
            if (b>0) {
                countPositive++;
                if(c>0) {
                    countPositive++;
                } else { if (c!=0)
                    countNegative++;
                }
            } else { if (b!=0)
                countNegative++;
                if(c>0) {
                    countPositive++;
                } else { if (c!=0)
                    countNegative++;
                }
            }
        }



        System.out.println("количество отрицательных чисел: "+countNegative);
        System.out.println("количество положительных чисел: "+countPositive);
        //напишите тут ваш код

    }
}
