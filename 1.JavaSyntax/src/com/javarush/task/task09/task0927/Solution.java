package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
Есть класс кот - Cat, с полем "имя" (String).
Создать словарь Map<String, Cat> и добавить туда 10 котов в виде "Имя"-"Кот".
Получить из Map множество(Set) всех котов и вывести его на экран.


*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> map = new HashMap<>();
       /* for (int i = 1; i < 11 ; i++) {
            map.put("Кот"+i, new Cat("Мурзик"+i));
        }*/
        Cat cat1 = new Cat("cat1");
        Cat cat2 = new Cat("cat2");
        Cat cat3 = new Cat("cat3");
        Cat cat4 = new Cat("cat4");
        Cat cat5 = new Cat("cat5");
        Cat cat6 = new Cat("cat6");
        Cat cat7 = new Cat("cat7");
        Cat cat8 = new Cat("cat8");
        Cat cat9 = new Cat("cat9");
        Cat cat10 = new Cat("cat10");
        map.put(cat1.name, cat1);
        map.put(cat2.name, cat2);
        map.put(cat3.name, cat3);
        map.put(cat4.name, cat4);
        map.put(cat5.name, cat5);
        map.put(cat6.name, cat6);
        map.put(cat7.name, cat7);
        map.put(cat8.name, cat8);
        map.put(cat9.name, cat9);
        map.put(cat10.name, cat10);
        return map;
        //напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> catsSet = new HashSet<>();

        map.forEach((k,v)-> {
            catsSet.add(v);
        });
        return catsSet;
        //напишите тут ваш код
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
