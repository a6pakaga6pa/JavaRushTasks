package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву "р"
2.2. удваивать все слова содержащие букву "л".
2.3. если слово содержит и букву "р" и букву "л", то оставить это слово без изменений.
2.4. с другими словами ничего не делать.

Пример:
роза
лира
лоза

Выходные данные:
лира
лоза
лоза


*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings.add("мера");
        strings.add("вода");
        strings.add("упор");

        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
       // int size = strings.size();
        for (int i = 0; i < strings.size() ; i++) {
            String word = strings.get(i);
            if (word != null){


            if (word.contains("р") && !word.contains("л")) {
                strings.remove(i);
                i--;
            } else if (word.contains("л") && !word.contains("р")) {
                    strings.add(i, strings.get(i));
                    i++;
                } else if (word.contains("л") && word.contains("р")) {
                    strings.add(i, strings.get(i));
                    strings.remove(i);
                }
            } else break;




        }

        //напишите тут ваш код
        return strings;
    }
}