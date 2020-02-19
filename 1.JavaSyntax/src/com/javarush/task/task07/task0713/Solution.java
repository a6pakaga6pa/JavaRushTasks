package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Играем в Jолушку
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число нацело делится на 3 (x%3==0), нацело делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
Порядок объявления списков очень важен.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.


*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> listBig = new ArrayList<>();
        ArrayList<Integer> listDivide3 = new ArrayList<>();
        ArrayList<Integer> listDivide2 = new ArrayList<>();
        ArrayList<Integer> others = new ArrayList<>();
        int number;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 20; i++) {
            number = scanner.nextInt();
            listBig.add(i, number);
        }

        for (int i = 0; i < 20; i++) {
            if (listBig.get(i)%3 == 0) {
               listDivide3.add(0, listBig.get(i));
            }
        }

        for (int i = 0; i < 20; i++) {
            if (listBig.get(i)%2 == 0) {
                listDivide2.add(0, listBig.get(i));
            }
        }

        for (int i = 0; i < 20; i++) {
            if(listBig.get(i)%2 !=0 && listBig.get(i)%3 !=0) others.add(0, listBig.get(i));
        }

        printList(listDivide3);
        printList(listDivide2);
        printList(others);
    }

    public static void printList(ArrayList<Integer> list) {

            int size = list.size();
            for (int i = 0; i < list.size() ; i++) {
                System.out.println(list.get(i));

            }
        }
        //напишите тут ваш код
    }

