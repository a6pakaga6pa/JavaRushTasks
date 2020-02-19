package com.javarush.task.task15.task1517;

/* 
Статики и исключения
В статическом блоке выбросьте Exception
В результате класс не загрузится, и вы увидите сообщение об ошибке вместо значения переменной B

Exception in thread "main" java.lang.ExceptionInInitializerError
at java.lang.Class.forName0(Native Method)
at java.lang.Class.forName(Class.java:186)
at com.intellij.rt.execution.application.AppMain.main(AppMain.java:113)
Caused by: java.lang.RuntimeException:
at com.javarush.task.task15.task1517.Solution.<clinit>(Solution.java:22)

Hint: Нужно погуглить причину, если получилось следующее:
java: initializer must be able to complete normally
java: unreachable statement


*/

import java.io.IOException;

public class Solution {
    public static int A = 0;
    public static int B = 5;

    static {

        int v = 1 / 0;




        //throw an exception here - выбросьте эксепшн тут
    }



    public static void main(String[] args) {
        System.out.println(B);
    }
}
