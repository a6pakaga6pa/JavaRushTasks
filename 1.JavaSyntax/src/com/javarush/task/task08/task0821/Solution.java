package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде "Фамилия"-"Имя".
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.


*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Иванов", "Oleg");
        map.put("Петров", "Ivan");
        map.put("Петров", "Jles");
        map.put("Коваленко", "Hостислав");
        map.put("Петрова", "Sveta");
        map.put("Олефиренко", "Sveta");
        map.put("Кондратович", "Max");
        map.put("Серебренников", "Max");
        map.put("Назаренко", "Sasha");
        map.put("Назаренко", "Urop");
        return map;


    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
