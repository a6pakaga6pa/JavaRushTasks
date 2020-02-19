package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
Сделать класс StringHelper, у которого будут 2 статических метода:
String multiply(String s, int count) - возвращает строку повторенную count раз.
String multiply(String s) - возвращает строку повторенную 5 раз.

Пример:
Амиго -> АмигоАмигоАмигоАмигоАмиго


*/

public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        for (int i = 0; i <5 ; i++) {
            result = result + s;
            System.out.print(result);
        }

        //напишите тут ваш код
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        for (int i = 0; i <count ; i++) {
            result = result + s;
            System.out.print(result);

        }
        //напишите тут ваш код
        return result;
    }

    public static void main(String[] args) {
        multiply("abrakaga6pa");
        multiply("qwerty", 2);

    }
}
