package com.javarush.task.task35.task3509;

import java.lang.reflect.Array;
import java.util.*;

/*
Collections & Generics
Реализуй вспомогательныe методы в классе Solution, которые должны создавать соответствующую коллекцию и помещать туда переданные объекты.
Методы newArrayList, newHashSet параметризируй типом T.
Метод newHashMap параметризируй типами К(ключ) и V(значение). Аргументы метода newHashMap должны принимать списки, в которых содержатся наследники типов K и V.
Возвращаемые коллекции должны быть такого же типа, что и переданные в метод объекты.

Подсказка: в методе newHashMap нужно проверить чтобы списки ключей и значений совпадали по размерам, в противном случае кинь IllegalArgumentException.


*/
public class Solution {

    public static void main(String[] args) {
        HashMap<Object, Number> map = newHashMap(newArrayList("first", "second"), newArrayList(1,2));
        map.forEach((k,v) -> System.out.println(k + " " + v));
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        return new ArrayList<T>(Arrays.asList(elements));
        //напишите тут ваш код
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        List<T> list = Arrays.asList(elements);
        return new HashSet<T>(list);
        //напишите тут ваш код
    }

    public static <K,V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        int keysSize = keys.size();
        int valuesSize = values.size();
        if(keysSize != valuesSize) {
            throw new IllegalArgumentException("Keys and Values number is not equal!");
        } else {
            HashMap<K,V> map = new HashMap<>();
            for (int i = 0; i < keys.size() ; i++) {
                map.put(keys.get(i), values.get(i));
            }
            return map;

        }
        //напишите тут ваш код
    }
}
