package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException  {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Серебренников", dateFormat.parse("MAY 30 1984"));
        map.put("Сиряковская", dateFormat.parse("DECEMBER 26 1993"));
        map.put("Asdfg", dateFormat.parse("JUNE 26 1993"));
        map.put("Frog", dateFormat.parse("JULY 16 1991"));
        map.put("Animal", dateFormat.parse("AUGUST 06 1971"));
        map.put("Crocodile", dateFormat.parse("MARCH 06 1981"));
        map.put("Ryzhyy", dateFormat.parse("FEBRUARY 07 1982"));
        map.put("Sheri", dateFormat.parse("JANUARY 07 1989"));
        map.put("Laptop", dateFormat.parse("OCTOBER 03 1982"));

        return map;

        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
     /*   while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            String month = value.toString();
         //   System.out.println(month);
            if (month.contains("Jul") || month.contains("Jun") || month.contains("Aug")) {
                iterator.remove();
            }

        }*/

        map.entrySet().removeIf(pair -> pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8);


        //напишите тут ваш код

    }

    public static void main(String[] args) throws ParseException{
       removeAllSummerPeople(createMap());


    }
}
