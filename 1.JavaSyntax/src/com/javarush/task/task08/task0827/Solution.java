package com.javarush.task.task08.task0827;

import java.util.Date;


/* 
Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате FEBRUARY 1 2013
Не забудьте учесть первый день года.

Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false


*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MARCH 7 2000"));
    }

    public static boolean isDateOdd(String date) {
        Date thisDate = new Date(date);
        Date startYear = new Date(date);
        startYear.setDate(1);
        startYear.setMonth(0);
        long daysInMs = thisDate.getTime() - startYear.getTime();
        int days = (int)(daysInMs/1000/60/60/24);
        if ((days+1)%2 == 0) return false;
        else return true;

        /*String[] dateDivided = date.split(" ");
        String month = dateDivided[0];
        String day = dateDivided[1];
        String year = dateDivided[2];
        int dayInt = Integer.parseInt(day);
        int yearInt = Integer.parseInt(year);
        Date yearStartTime = new Date();
        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);
        yearStartTime.setDate(1);      // первое число
        yearStartTime.setMonth(0);
        yearStartTime.setYear(yearInt);

        Date currentTime = new Date();
        currentTime.setTime(yearInt);
        currentTime.setDate(dayInt);
        currentTime.setMonth(month);
*/

    }
}
