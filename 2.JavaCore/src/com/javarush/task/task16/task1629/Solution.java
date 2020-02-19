package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*1. В классе Solution создать public static класс нити Read3Strings унаследовавшись от Thread.
        2. В методе run реализовать чтение с консоли трех строк.
        3. Три подряд введенных строки должны считываться в одной нити и объединяться в одну строку через пробел.
        4. В методе main вывести результат для каждой нити.
        5. Используй join.*/



public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException, IOException {
        Read3Strings t1 = new Read3Strings();
        t1.start();
        t1.join();
        Read3Strings t2 = new Read3Strings();
        t2.start();
        t2.join();

        //add your code here - добавьте код тут

        t1.printResult();
        t2.printResult();
        reader.close();
    }

    public static class Read3Strings extends Thread {

        String over = "";
        @Override
        public void run() {

            for (int i = 0; i < 3 ; i++) {
                try{
                    String line = reader.readLine();
                    over = over + " " + line;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        public void printResult() {
            System.out.println(over);
        }
    }

    //add your code here - добавьте код тут
}
