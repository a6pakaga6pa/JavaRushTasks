package com.javarush.task.task08.task0801;

/* 
Set из растений
Создать коллекцию Set (реализация HashSet) с типом элементов String.
Добавить в неё 10 строк:
арбуз
банан
вишня
груша
дыня
ежевика
женьшень
земляника
ирис
картофель

Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.


*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("женьшень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");

        for (String text: set){
            System.out.println(text);
        }
        //напишите тут ваш код

    }
}
