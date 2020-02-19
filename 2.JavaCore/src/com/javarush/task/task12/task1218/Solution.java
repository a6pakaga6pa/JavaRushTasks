package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

import javax.sound.midi.Soundbank;

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanMove {
        public void move();
    }

    public interface CanEat {
        public void eat();
    }

    public class Dog implements CanEat, CanMove{
        public void move() {
            System.out.println("I'm moving");
        }

        public void eat() {
            System.out.println("I'm eating");
        }
    }

    public class Duck implements CanEat, CanFly, CanMove{
        public void fly() {
            System.out.println("I'm flying");
        }

        public void move() {
            System.out.println("I'm moving");
        }

        public void eat() {
            System.out.println("I'm eating");
        }
    }

    public class Car implements CanMove{
        public void move() {
            System.out.println("I'm moving");
        }
    }

    public class Airplane implements CanFly, CanMove{
        public void fly() {
            System.out.println("I'm flying");
        }

        public void move() {
            System.out.println("I'm moving");
        }
    }
}
