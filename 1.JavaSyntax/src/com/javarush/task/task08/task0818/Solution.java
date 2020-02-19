package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: "фамилия" - "зарплата".
Удалить из словаря всех людей, у которых зарплата ниже 500.


*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Макс", 2000);
        map.put("Alex", 1000);
        map.put("Alexandr", 1020);
        map.put("Petya", 1040);
        map.put("Vasya", 440);
        map.put("Anna", 2440);
        map.put("Juliya", 3440);
        map.put("Natasha", 2140);
        map.put("Vanya", 140);
        map.put("Afonya", 340);
        return map;
        //напишите тут ваш код
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            int value = pair.getValue();
            if (value < 500) iterator.remove();
        }


        //напишите тут ваш код
    }

    public static void main(String[] args) {
        removeItemFromMap(createMap());

    }
}