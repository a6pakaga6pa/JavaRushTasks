package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.


*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> list = new HashSet<>();
        list.add(2);
        list.add(20);
        list.add(30);
        list.add(560);
        list.add(6);
        list.add(-6);
        list.add(-78);
        list.add(78);
        list.add(18);
        list.add(8);
        list.add(3);
        list.add(0);
        list.add(10);
        list.add(11);
        list.add(7);
        list.add(5);
        list.add(74);
        list.add(-74);
        list.add(-44);
        list.add(-14);
        return list;
        // напишите тут ваш код

    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {

        set.removeIf(num -> num > 10);
        return set;
        // напишите тут ваш код

    }

    public static void main(String[] args) {
        /*Set<Integer> newSet = new HashSet<>(createSet());

        Set<Integer> result = new HashSet<>(removeAllNumbersGreaterThan10(newSet));
        for (int num : result) {
            System.out.println(num);
        }*/

    }
}
