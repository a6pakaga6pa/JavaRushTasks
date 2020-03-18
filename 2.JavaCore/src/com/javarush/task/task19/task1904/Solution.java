package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner. Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные только одного человека.


*/

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
      /*  PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(new File("C:\\Users\\sereb\\Documents\\all.cfg")));
        System.out.println(adapter.read());
*/
    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String[] data = fileScanner.nextLine().split(" ", 4);
            SimpleDateFormat dateFormat = new SimpleDateFormat("d M y", Locale.ENGLISH);
            String birthDate = data[3];
            Date date = dateFormat.parse(birthDate);

            return new Person(data[1], data[2], data[0], date);
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
