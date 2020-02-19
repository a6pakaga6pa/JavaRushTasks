package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов.
Нужно подсчитать сколько раз каждое слово встречается в списке.
Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр - уникальное слово, а второй - число, сколько раз данное слово встречалось в списке.

Вывести содержимое словаря на экран.
В тестах регистр (большая/маленькая буква) влияет на результат.


*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        for (String input : list){
            result.put(input,Collections.frequency(list, input));
        }

   /*  3.   int freq = 0;
        for (int i = 0; i < list.size(); i++) {
           freq = Collections.frequency(list, list.get(i));
           result.put(list.get(i), freq);
        }*/


        /* 1.   for (int i = 0; i < list.size() ; i++) {
            result.merge(list.get(i), 1, (oldVal, newVal) -> oldVal + newVal);
        }*/


     /*2.   int count = 0;
        for (int i = 0; i < list.size(); i++) {
            String firstString = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                String secondString = list.get(j);
                if (firstString.equals(secondString))
                    count++;
            }
            result.put(firstString,count - 1);
            count = 1;
        }*/

        //напишите тут ваш код


        return result;
    }

}

