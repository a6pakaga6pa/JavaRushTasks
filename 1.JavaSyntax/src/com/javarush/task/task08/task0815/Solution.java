package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.


*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Иванов", "Oleg");
        map.put("Петров", "Ivan");
        map.put("Сидоров", "Jles");
        map.put("Коваленко", "Hостислав");
        map.put("Петрова", "Sveta");
        map.put("Олефиренко", "Sveta");
        map.put("Кондратович", "Max");
        map.put("Серебренников", "Max");
        map.put("Назаренко", "Sasha");
        map.put("Ковалева", "Urop");
        return map;
        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int count = 0;
        while(iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String value = pair.getValue();
            if (name.equals(value)) count ++;
        }
        //напишите тут ваш код
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int count = 0;
        while(iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String value = pair.getKey();
            if (lastName.equals(value)) count ++;
        }
        //напишите тут ваш код
        return count;
    }

    public static void main(String[] args) {

    }
}
