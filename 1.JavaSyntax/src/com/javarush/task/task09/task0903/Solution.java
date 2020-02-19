package com.javarush.task.task09.task0903;

/* 
Кто меня вызывал?
Написать пять методов, которые вызывают друг друга.
Метод должен вернуть номер строки кода, из которого вызвали этот метод.
Воспользуйся функцией: element.getLineNumber().


*/

public class Solution {
    public static void main(String[] args) {

        method1();
    }

    public static int method1() {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        System.out.println(stackTraceElements[2].getLineNumber());
        System.out.println(stackTraceElements[2].getMethodName());
        method2();
        return stackTraceElements[2].getLineNumber();
    }

    public static int method2() {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getLineNumber());
        System.out.println(stackTraceElements[2].getMethodName());
        method3();
        return stackTraceElements[2].getLineNumber(); /*напишите тут ваш код*/
    }

    public static int method3() {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getLineNumber());
        System.out.println(stackTraceElements[2].getMethodName());
        method4();
        return stackTraceElements[2].getLineNumber();
    }

    public static int method4() {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getLineNumber());
        System.out.println(stackTraceElements[2].getMethodName());
        method5();
        return stackTraceElements[2].getLineNumber();  /*напишите тут ваш код*/
    }

    public static int method5() {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getLineNumber());
        System.out.println(stackTraceElements[2].getMethodName());
        return stackTraceElements[2].getLineNumber();
    }
}
