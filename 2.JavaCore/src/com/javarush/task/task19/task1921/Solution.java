package com.javarush.task.task19.task1921;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
     //   String filePath = "C:\\Users\\sereb\\Documents\\all.cfg";
        String filePath = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        while(reader.ready()){
            String line = reader.readLine().trim();
            for (int i = 0; i < line.length() ; i++) {
                if(Character.isDigit(line.charAt(i))) {
                    String birthDate = line.substring(i).trim();
                    String name = line.substring(0, i).trim();
                    SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
                    Date date = format.parse(birthDate);
                    PEOPLE.add(new Person(name, date));
                    break;
                }
            }
        }
        reader.close();
    //    PEOPLE.forEach(Person -> System.out.println(Person.getName() + " " + Person.getBirthDate()));

    }
}
