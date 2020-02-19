package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: "user", "loser", "coder", "proger".
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1. Создать соответствующий объект [см. Person.java], например, для строки "user" нужно создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1. Вызывает метод live() у переданного объекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Loser.
3.3. Вызывает метод writeCode(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.


*/

public class Solution implements Person{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        label:
        while(true) {
            key = reader.readLine();
            switch (key) {
                case "user":
                    User user = new User();
                    doWork(user);
                    break;
                case "loser":
                    Loser loser = new Loser();
                    doWork(loser);
                    break;
                case "coder":
                    Coder coder = new Coder();
                    doWork(coder);
                    break;
                case "proger":
                    Proger proger = new Proger();
                    doWork(proger);
                    break;
                default:
                    break label;
            }
        }

    }

    public static void doWork(Person person) {
        if (person instanceof User) ((User) person).live();
        else if (person instanceof Loser) ((Loser) person).doNothing();
        else if (person instanceof Coder) ((Coder) person).writeCode();
        else if (person instanceof Proger) ((Proger) person).enjoy();
        // пункт 3
    }


}
