package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.


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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            names.add(pair.getValue());
        }

        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()){
            int freq = Collections.frequency(names, pair.getValue());
            if (freq > 1) {
                removeItemFromMapByValue(map, pair.getValue());
            }
        }
        //напишите тут ваш код

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        removeTheFirstNameDuplicates(createMap());

    }
}
