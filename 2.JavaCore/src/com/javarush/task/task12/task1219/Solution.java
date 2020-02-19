package com.javarush.task.task12.task1219;

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }


    public class Human implements CanRun, CanSwim{

        public void run() {
            System.out.println(1);
        }

        public void swim() {
            System.out.println(2);
        }

    }

    public class Duck implements CanSwim, CanFly, CanRun{
        public void swim() {
            System.out.println(2);
        }
        public void fly() {
            System.out.println(3);
        }
        public void run() {
            System.out.println(1);
        }



    }

    public class Penguin implements CanSwim, CanRun{
        public void swim() {
            System.out.println(2);
        }

        public void run() {
            System.out.println(1);
        }
    }

    public class Airplane implements CanFly, CanRun{
        public void fly() {
            System.out.println(3);
        }
        public void run() {
            System.out.println(1);
        }
    }
}
