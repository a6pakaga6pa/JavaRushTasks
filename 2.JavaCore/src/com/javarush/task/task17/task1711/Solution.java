package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion.

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u - обновляет соответствующие данные людей с заданными id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке.
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople.
Порядок вывода данных соответствует вводу данных.
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных).
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997


*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();


    static {

        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1


    }

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (args[0]){

            case "-c":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i+=3) {
                        if (args[i+1].contains("м")){
                                    Person malePerson = Person.createMale(args[i], format.parse(args[i+2]));
                                    allPeople.add(malePerson);
                                    System.out.println(allPeople.indexOf(malePerson));
                                } else if (args[i+1].contains("ж")) {
                                    Person femalePerson = Person.createFemale(args[i], format.parse(args[i+2]));
                                    allPeople.add(femalePerson);
                                    System.out.println(allPeople.indexOf(femalePerson));
                                } else System.out.println("Wrong sex!");
                    } break;
                }

            case "-u":
                synchronized (allPeople){
                    for (int i = 1; i < args.length ; i+=4) {
                        for (int j = 0; j <args.length; j++) {
                            String number = String.valueOf(j);
                            if (args[i].contains(number)) {
                                Person person = allPeople.get(j);
                                person.setName(args[i+1]);

                                if(args[i+2].equals("м")) {
                                    person.setSex(Sex.MALE);
                                } else if(args[i+2].equals("ж")) {
                                    person.setSex(Sex.FEMALE);
                                }
                                person.setBirthDate(format.parse(args[i+3]));
                            }
                        }

                    } break;
                }

            case "-d":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++) {
                        for (int j = 0; j < allPeople.size() ; j++) {
                            String number = String.valueOf(j);
                            if (args[i].equals(number)) {
                                Person person = allPeople.get(j);
                                person.setName(null);
                                person.setSex(null);
                                person.setBirthDate(null);
                            }
                        }
                    } break;
                }

            case "-i":
                synchronized (allPeople){
                    for (int i = 1; i < args.length ; i++) {
                        for (int j = 0; j < allPeople.size(); j++) {
                            String number = String.valueOf(j);
                            if (args[i].equals(number)) {
                                Person person = allPeople.get(j);
                                String sex;

                                if(person.getSex().equals(Sex.MALE)) {
                                    sex = "м";
                                } else sex = "ж";

                                System.out.println(person.getName() + " " + sex + " " + format2.format(person.getBirthDate()));
                            }
                        }
                    } break;
                }
        }
    }
}
