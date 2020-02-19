package com.javarush.task.task04.task0403;

/* 
Как зовут кота?
Помогите коту обрести имя с помощью метода setName.


*/

public class Cat {
    private String name = "безымянный кот";

    public void setName(String name) {
        this.name = name;
        //напишите тут ваш код

    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Жужик");
        System.out.println(cat.name);
    }
}
