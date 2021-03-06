package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст - неизвестные. Кот - бездомный)
- вес, цвет, адрес (чужой домашний кот)

Задача конструктора - сделать объект валидным.
Например, если вес не известен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить.
То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.


*/

public class Cat {

    String name, address;
    String color = "Black";
    int age = 1;
    int weight = 2;

    public Cat(String name){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Cat(String name, int weight, int age){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color){
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color, String address){
        this.address = address;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }




    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
