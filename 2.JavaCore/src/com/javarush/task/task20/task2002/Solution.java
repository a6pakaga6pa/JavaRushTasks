package com.javarush.task.task20.task2002;

import java.io.*;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
Метод main реализован только для вас и не участвует в тестировании.


*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
         //   File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\sereb\\Documents\\file2.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\sereb\\Documents\\file2.txt");

            JavaRush javaRush = new JavaRush();
            User max = new User();
            max.setFirstName("Max");
            max.setLastName("Serebro");
            max.setCountry(User.Country.UKRAINE);
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sf.parse("30/05/1984");
            max.setBirthDate(date);
            max.setMale(true);
            User julie = new User();
            date = sf.parse("26/12/1993");
            julie.setBirthDate(date);
            julie.setMale(false);
            julie.setCountry(User.Country.UKRAINE);
            julie.setFirstName("Julie");
            julie.setLastName("Sirya");
            javaRush.users.add(julie);
            javaRush.users.add(max);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            if(!this.users.isEmpty()){
                for(User person : users) {
                        writer.println(person.getFirstName());
                        writer.println(person.getLastName());
                        writer.println(person.getBirthDate().getTime());
                        writer.println(person.getCountry());
                        writer.println(person.isMale());
                }
            }
            writer.flush();
            writer.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                while(reader.ready()){
                    User person = new User();
                        person.setFirstName(reader.readLine());
                        person.setLastName(reader.readLine());
                        person.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                        person.setCountry(User.Country.valueOf(reader.readLine()));
                        person.setMale(Boolean.parseBoolean(reader.readLine()));
                    users.add(person);
                }

              //  users.forEach((p)->System.out.println(p.getFirstName()+ p.getLastName()+p.getCountry()+p.getBirthDate()+p.isMale()));
                reader.close();


            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
