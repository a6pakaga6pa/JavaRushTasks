package com.javarush.task.task04.task0407;

/* 
Кошки во Вселенной
Написать код, чтобы правильно считалось количество созданных котов (count) и на экран выдавалось правильное их количество.


*/

public class Solution {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.count++;
        //напишите тут ваш код

        Cat cat2 = new Cat();
        cat2.count++;
        //напишите тут ваш код

        System.out.println("The cat count is " + Cat.count);
    }

    public static class Cat {
        public static int count = 0;
    }
}