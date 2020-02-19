package com.javarush.task.task04.task0404;

/* 
Учет котов
Напиши код в методе addNewCat, чтобы при его вызове количество котов увеличивалось на 1.
За количество котов отвечает переменная catsCount.


*/

public class Cat {
    private static int catsCount = 0;

    public static void addNewCat() {
        Cat.catsCount++;
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
