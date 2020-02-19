package com.javarush.task.task05.task0527;

/* 
Том и Джерри
Создай классы Dog, Cat, Mouse.
Добавь по три поля в каждый класс, на твой выбор.
Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.

Пример:
Mouse jerryMouse = new Mouse("Jerry", 12 , 5),
где 12 - высота в см,
5 - длина хвоста в см.


*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Cat tom = new Cat("Tom", 2, "Meaw!");
        Dog dog = new Dog("Barto", 3, "Bow-Wow!");

        //напишите тут ваш код
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Dog {
        String name;
        int age;
        String say;

        public Dog(String name, int age, String say) {
            this.name = name;
            this.age = age;
            this.say = say;
        }
    }

    public static class Cat {
        String name;
        int age;
        String say;

        public Cat(String name, int age, String say) {
            this.name = name;
            this.age = age;
            this.say = say;
        }
    }



    //напишите тут ваш код
}
