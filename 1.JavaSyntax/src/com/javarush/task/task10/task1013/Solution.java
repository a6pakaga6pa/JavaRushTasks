package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private int height;
        private boolean sex;
        private String country;
        private String city;

        public Human() {
        }

        public Human(String name, int age, boolean sex, String country, String city){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.country = country;
            this.city = city;
        }

        public Human(String country, String city){
            this.country = country;
            this.city = city;
        }

        public Human(String name, boolean sex, String country, String city){
            this.name = name;
            this.sex = sex;
            this.country = country;
            this.city = city;
        }

        public Human(boolean sex, String country, String city){
            this.sex = sex;
            this.country = country;
            this.city = city;
        }

        public Human(String name, int age, String country, String city){
            this.name = name;
            this.age = age;
            this.country = country;
            this.city = city;
        }

        public Human(String name, String city, int age, boolean sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.city = city;
        }

        public Human(String name, int age, boolean sex, String country){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.country = country;
        }

        public Human(String name, int age, boolean sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name){
            this.name = name;
        }


        // Напишите тут ваши переменные и конструкторы
    }
}
