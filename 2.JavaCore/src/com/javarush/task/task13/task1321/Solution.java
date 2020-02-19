package com.javarush.task.task13.task1321;


/* 
Исправление ошибок
1. Переделай наследование в классах и интерфейсах так, чтобы программа компилировалась и продолжала делать то же самое.
2. Класс Hobby должен наследоваться от интерфейсов Desire, Dream.


*/

public class Solution {

    public static void main(String[] args) {
        /*System.out.println(Dream.HOBBY.toString());
        System.out.println(new Hobby().INDEX);*/
        System.out.println(Dream.HOBBY); // 2 - т.к. создали final объект HOBBY и toString здесь отработала, хоть и не прописана явно
        System.out.println(Dream.HOBBY.toString());  //3 - объект всё тот же HOBBY, toString отработала ещё раз
        System.out.println(new Hobby().INDEX);// 3 - toString() не отработала, объект новый создался, но INDEX напрямую вытащили старый
        System.out.println(new Hobby().toString()); // 4 - опять новый объект, toString() отработала, прописана явно
        System.out.println(new Hobby()); // 5 - ну и наконец ещё раз новый объект, toString() опять отработала, хоть явно и не прописана.
    }

    interface Desire {
    }

    interface Dream extends Desire {
        public static Hobby HOBBY = new Hobby();
    }

    static class Hobby implements Desire, Dream {
        static int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }

}
