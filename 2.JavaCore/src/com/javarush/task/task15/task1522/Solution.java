package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
1. Найти пример реализации паттерна Singleton с ленивой реализацией(lazy initialization). Используй свой любимый поисковик(например google).
2. По образу и подобию в отдельных файлах создай три класса синглтона Sun, Moon, Earth.
3. Реализуй интерфейс Planet в классах Sun, Moon, Earth.
4. В статическом блоке класса Solution вызови метод readKeyFromConsoleAndInitPlanet.
5. Реализуй функционал метода readKeyFromConsoleAndInitPlanet:
5.1. С консоли считай один параметр типа String.
5.2. Если параметр равен одной из констант интерфейса Planet, создай соответствующий объект и присвой его Planet thePlanet, иначе обнулить Planet thePlanet.


*/

public class Solution {
    public static void main(String[] args)  {


    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();

    }

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String text = reader.readLine();
            if (text.equalsIgnoreCase(Planet.EARTH)) {
                Solution.thePlanet = Earth.getInstance();
                reader.close();
            } else if (text.equalsIgnoreCase(Planet.SUN)) {
                Solution.thePlanet = Sun.getInstance();
                reader.close();
            } else if (text.equalsIgnoreCase(Planet.MOON)) {
                Solution.thePlanet = Moon.getInstance();
                reader.close();
            } else {thePlanet = null;
                reader.close(); }
        } catch (IOException e) {
            e.printStackTrace();

        }
        //System.out.println(thePlanet);


        // implement step #5 here - реализуйте задание №5 тут
    }
}
