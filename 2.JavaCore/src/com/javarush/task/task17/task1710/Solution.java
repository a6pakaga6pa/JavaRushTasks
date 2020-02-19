package com.javarush.task.task17.task1710;

import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
CrUD - Create, Update, Delete.

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


        if(args[0].equals("-c")) {

            if(args[2].equals("м")){
                Person malePerson = Person.createMale(args[1], format.parse(args[3]));
                allPeople.add(malePerson);
                System.out.println(allPeople.indexOf(malePerson));

            } else if(args[2].equals("ж")){
                Person femalePerson = Person.createFemale(args[1], format.parse(args[3]));
                allPeople.add(femalePerson);
                System.out.println(allPeople.indexOf(femalePerson));

            } else System.out.println("Wrong sex parameter!");
        }

        if(args[0].equals("-u")){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            allPeople.remove(Integer.parseInt(args[1]));
            person.setName(args[2]);

            if(args[3].equals("м")) {
                person.setSex(Sex.MALE);
            } else if(args[3].equals("ж")) {
                person.setSex(Sex.FEMALE);
            }

            person.setBirthDate(format.parse(args[4]));

            allPeople.add(Integer.parseInt(args[1]), person);
        }

        if(args[0].equals("-d")){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            allPeople.remove(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
            allPeople.add(Integer.parseInt(args[1]), person);
        }

        if(args[0].equals("-i")){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            String sex;

            if(person.getSex().equals(Sex.MALE)) {
                sex = "м";
            } else sex = "ж";

            System.out.println(person.getName() + " " + sex + " " + format2.format(person.getBirthDate()));
        }

    }
}
