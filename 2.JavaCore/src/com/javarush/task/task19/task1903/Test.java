package com.javarush.task.task19.task1903;

public class Test {

    public static void main(String[] args) {
        int a = 504414720;
        int code = 38;
        String correctPhoneNumber = String.valueOf(a);
        StringBuilder buffer = new StringBuilder(correctPhoneNumber);
        buffer.insert(0, '0');
        buffer.insert(3, ')');
        buffer.insert(7, '-');
        buffer.insert(10, '-');
        String fullNumber = "+" + String.valueOf(code) + buffer.toString();
        System.out.println(fullNumber);


    }
}
