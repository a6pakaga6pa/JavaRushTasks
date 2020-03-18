package com.javarush.task.task19.task1928;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* 
Исправить ошибку. Классы и интерфейсы
Программа содержит всего 1 логическую ошибку.
Найди и исправь ее.


*/

public class Solution {
    {
        System.out.println("This is the Solution class");
    }

    public static void main(String... args) throws IOException {
        /*args[0] = "C:\\Users\\sereb\\Documents\\file1.txt";
        args[1] = "C:\\Users\\sereb\\Documents\\file2.txt";*/

        try (
                FileOutputStream outputStream = new FileOutputStream(args[0]);
                InputStream is = new FileInputStream(args[1]) {
                };
                //Solution.class.getClassLoader().getResourceAsStream
        ) {
            ;
            byte[] b = new byte[is.available()];
            outputStream.write(is.read(b));

            int value = 123_456_789;
            System.out.println(value);

            Example result = null;
            String s = "c";
            switch (s) {
                case "a": {
                    result = new Solution().new A();
                    break;
                }
                case "b": {
                    result = new Solution().new B();
                    break;
                }
                case "c": {
                    result = new Solution().new C();
                    break;
                }
            }

            if (result instanceof C) {
                C p = (C) result;
                System.out.println(p.getClass().getSimpleName());
            }

        } catch (IOException e) {
        }
    }

    interface Example {
    }

    class A implements Example {
        {
            System.out.println("This is the A class");
        }
    }

    class B implements Example {
        {
            System.out.println("This is the B class");
        }
    }

    class C extends A {
        {
            System.out.println("This is the C class");
        }
    }
}
