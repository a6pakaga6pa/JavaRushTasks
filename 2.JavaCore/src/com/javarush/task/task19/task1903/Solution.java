package com.javarush.task.task19.task1903;

/* 
Адаптируй IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.


*/

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
     /*   IncomeData data = new IncomeData() {
            public String getCountryCode() { return "UA"; }

            public String getCompany() { return "JavaRush Ltd."; }

            public String getContactFirstName() { return "Ivan"; }

            public String getContactLastName() { return "Ivanov"; }

            public int getCountryPhoneCode() { return 38; }

            public int getPhoneNumber() { return 4720; }
        };

        IncomeDataAdapter a = new IncomeDataAdapter(data);

        System.out.println(a.getCompanyName());
        System.out.println(a.getCountryName());
        System.out.println(a.getName());
        System.out.println(a.getPhoneNumber());*/

    }

    public static class IncomeDataAdapter implements Customer, Contact{

        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData){
            this.data = incomeData;
        }


        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            String countryName = "";
            for (Map.Entry<String, String> pair : countries.entrySet()) {
                if(pair.getKey().equals(this.data.getCountryCode())) {
                    countryName = pair.getValue();
                }
            }
            return countryName;
        }

        @Override
        public String getName() {
            String name = this.data.getContactFirstName();
            String lastName = this.data.getContactLastName();
            return lastName + ", " + name;
        }

        @Override
        public String getPhoneNumber() {
            String fullNumber = "";
            int code = this.data.getCountryPhoneCode();
            int number = this.data.getPhoneNumber();
            String numberString = String.valueOf(number);
            while(numberString.length() < 10) {
                fullNumber = "0" + numberString;
                numberString = fullNumber;
            }
            String result = "+" + code + "(" + fullNumber.substring(0,3) + ")" + fullNumber.substring(3,6) + "-" +
                    fullNumber.substring(6,8) + "-" + fullNumber.substring(8);
            return result;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}