package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес (чужой домашний кот)

Задача инициализатора - сделать объект валидным.
Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить.
То же касается возраста и цвета.
А вот имени может и не быть (null).
То же касается адреса: null.


*/

public class Cat {
    String name;
    int weight = 2;
    int age = 1;
    String color = "Black";
    String address;

    public void initialize(String name){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public void initialize(String name, int weight, int age){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public void initialize(int weight, String color){
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public void initialize(int weight, String color, String adress){
        this.address = adress;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }


    //напишите тут ваш код

    public static void main(String[] args) {

        Cat cat1 = new Cat();
        cat1.initialize("Vaska", 7);
        System.out.println(cat1.address);
        System.out.println(cat1.weight);
        System.out.println(cat1.color);
        System.out.println(cat1.age);
        System.out.println(cat1.name);
        System.out.println(cat1);

    }
}
