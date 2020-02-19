package com.javarush.task.task09.task0911;

import java.util.HashMap;

/* 
Исключение при работе с коллекциями Map
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
HashMap map = new HashMap(null);
map.put(null, null);
map.remove(null);


*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            HashMap<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);

            //напишите тут ваш код
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}
