package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.

Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada


*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
            Customer cus = new Customer() {
            public String getCompanyName() { return "JavaRush Ltd."; }
            public String getCountryName() { return "Ukraine"; }
        };
              Contact con = new Contact() {
              public String getName() { return "Ivanov, Ivan"; }
              public String getPhoneNumber()  { return "+38(050)123-45-67"; } // or +3(805)0123-4567 or +380(50)123-4567 or ...
        };

              DataAdapter adapter = new DataAdapter(cus, con);


        System.out.println(adapter.getCountryCode());
        System.out.println(adapter.getCompany());
        System.out.println(adapter.getContactFirstName());
        System.out.println(adapter.getContactLastName());
        System.out.println(adapter.getDialString());

    }

    public static class DataAdapter implements RowItem{

        private Contact contact;
        private Customer customer;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryCode = "";
            for (Map.Entry<String, String> pair : countries.entrySet()) {
                if (pair.getValue().equals(customer.getCountryName())){
                    countryCode = pair.getKey();
                }

            } return countryCode;

        }

        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String fullName = this.contact.getName();
            String[] data = fullName.split(" ");
            return data[1];
        }

        @Override
        public String getContactLastName() {
            String fullName = this.contact.getName();
            String[] data = fullName.split(",");
            return data[0];
        }

        @Override
        public String getDialString() {
            String newNumber = "";
            String oldNumber = this.contact.getPhoneNumber();
            for (int i = 0; i < oldNumber.length(); i++) {
                try {
                    int currentSymbol = Integer.parseInt(String.valueOf(oldNumber.charAt(i)));
                    newNumber = newNumber + currentSymbol;
                } catch (NumberFormatException e) {}
            }
            return "callto://+" + newNumber;


        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}