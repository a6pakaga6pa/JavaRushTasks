package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


*/

public class Solution {

    public static class MyException extends Exception {
        public MyException(String str) {
            super(str);
        }

        public MyException() {

        }
    }


    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        MyException me = new MyException("Test1");


        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        try {
            String a = null; //null value
            System.out.println(a.charAt(0));
        } catch(NullPointerException e) {
            exceptions.add(e);
        }

        try {
            String a = "This is like chipping "; // length is 22
            char c = a.charAt(24); // accessing 25th element
            System.out.println(c);
        }
        catch(StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {

            // Following file does not exist
            File file = new File("E://file.txt");

            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        try {
            // "akki" is not a number
            int num = Integer.parseInt ("akki") ;

            System.out.println(num);
        } catch(NumberFormatException e) {
            exceptions.add(e);
        }

        try{
            int a[] = new int[5];
            a[6] = 9; // accessing 7th element in an array of
            // size 5
        }
        catch(ArrayIndexOutOfBoundsException e){
            exceptions.add(e);
        }

        try {
            int a = 1;
            if (a < 5) {
                MyException me = new MyException("Test1");
                throw me;
            }
    }catch (MyException e) {
            exceptions.add(e);
        }

        try {
            Class loadedClass = Class.forName("wer");
            System.out.println("Class " + loadedClass + " found successfully!");
        }
        catch (ClassNotFoundException ex) {
            exceptions.add(ex);
        }

        try {
            String.class.getMethod("foobar");
        }
        catch (NoSuchMethodException ex) {
            exceptions.add(ex);
        }

        try {
            throw new IOException();
        }catch (IOException e) {
            exceptions.add(e);
        }



        //напишите тут ваш код

    }
}
