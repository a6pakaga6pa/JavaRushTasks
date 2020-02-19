package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
Какое сегодня число?
Ввести с клавиатуры дату в формате "2013-08-18"
Вывести на экран введенную дату в виде "AUG 18, 2013".
Воспользоваться объектом Date и SimpleDateFormat.


*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.next();
        String[] array = dateString.split("-");
        Date date = new Date();
        int dayInt = Integer.parseInt(array[2]);
        int monthInt = Integer.parseInt(array[1]) - 1;
        int yearInt = Integer.parseInt(array[0]);
        date.setDate(dayInt);
        date.setYear(yearInt - 1900);
        date.setMonth(monthInt);


        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        String finalDate = format.format(date);
        String upper = finalDate.toUpperCase();
        System.out.println(upper);

      /* SimpleDateFormat enteredDate = new SimpleDateFormat("yyyy-MM-dd");
       Date finalDate = new Date();
       finalDate = enteredDate.parse(dateString);
       SimpleDateFormat resultDate = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(resultDate.format(finalDate).toUpperCase());
*/


        //напишите тут ваш код
    }
}
