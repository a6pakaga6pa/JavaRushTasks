package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
1. Создай 5 различных своих нитей c отличным от Thread типом:
        1.1. Нить 1 должна бесконечно выполняться;
        1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
        1.3. Нить 3 должна каждые полсекунды выводить "Ура";
        1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
        1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
        2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
        3. Нити не должны стартовать автоматически.

        Подсказка:
        Нить 4 можно проверить методом isAlive()
*/



public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new One());
        threads.add(new Two());
        threads.add(new Three());
        threads.add(new Four());
        threads.add(new Five());

    }

    public static class One extends Thread{
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class Two extends Thread{
        @Override
        public void run() {
            try {
                if(isInterrupted()) throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }

        }
    }

    public static class Three extends Thread {
        @Override
        public void run() {
            try {
                while(true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static class Four extends Thread implements Message{
        private boolean myStop = false;

        @Override
        public void showWarning() {
            myStop = true;
        }

        @Override
        public void run() {

                while ( !myStop ) {

                }

        }
    }

    public static class Five extends Thread {
        @Override
        public void run() {
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           boolean isEnd = false;
           int sum = 0;
           try {
               while (!isEnd) {

                   String number = reader.readLine();
                   if (!number.equals("N")) {
                       sum += Integer.parseInt(number);
                   } else {
                       System.out.println(sum);
                       reader.close();
                       isEnd = true;
                   }
           }

           } catch (IOException e) {
               e.printStackTrace();
           }
        }
    }



    public static void main(String[] args) {


    }
}