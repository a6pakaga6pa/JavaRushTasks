package com.javarush.task.task04.task0437;

/* 
Треугольник из восьмерок
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.

Пример вывода на экран:
8
88
888
8888
88888
888888
8888888
88888888
888888888
8888888888


*/

public class Solution {
    public static void main(String[] args) {

        for (int j = 1; j <=10 ; j++) {
            for (int i = 1; i <=j ; i++) {
                System.out.print(8);
            }
            System.out.println();
        }


        //напишите тут ваш код

    }
}
