package com.javarush.task.task04.task0411;

/* 
Времена года на Терре

Напишите метод checkSeason. По номеру месяца, метод должен определить время года (зима, весна, лето, осень) и вывести на экран.

Пример для номера месяца 2:
зима

Пример для номера месяца 5:
весна


*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        String i;
        if (month < 3 && month >=1 || month == 12) i ="зима";
        else {
            if(month > 2 && month < 6) i="весна";
            else if (month > 5 && month < 9) i="лето";
            else i="осень";
        }
        /*System.out.println("Пример для номера месяца "+month+":");*/
        System.out.println(i);
        //напишите тут ваш код

    }
}