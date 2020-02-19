package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
Создать массив, элементами которого будут списки строк.
Заполнить массив любыми данными и вывести их на экран.


*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] arrays = new ArrayList[2];
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("asd");
        list1.add("adfgdfgdsd");
        list1.add("asddd");
        list1.add("dgdjasd");
        list1.add("tuytuasd");
        list1.add("yuiyiasd");

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("a");
        list2.add("d");
        list2.add("ddd");
        list2.add("sd");
        list2.add("td");
        list2.add("y");

        arrays[0] = list1;
        arrays[1] = list2;
        return arrays;
        //напишите тут ваш код


    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}