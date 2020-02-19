package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        Map<Character, Integer> map = new TreeMap<>();

        FileInputStream inputStream = new FileInputStream(args[0]);
        List<Character> list = new LinkedList<>();
        while(inputStream.available() > 0) {
            int symbol = inputStream.read();
            list.add((char)symbol);
        }

        for (int i = 0; i < list.size(); i++) {
            int freq = Collections.frequency(list, list.get(i));
            map.put(list.get(i), freq);
        }

        map.forEach((k, v) -> System.out.println(k + " " + v));
        inputStream.close();

    }
}
