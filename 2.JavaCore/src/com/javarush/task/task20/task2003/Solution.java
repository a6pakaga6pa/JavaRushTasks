package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.


*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        load(fileInputStream);
        reader.close();
        fileInputStream.close();
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, "Some comments");

        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        properties.putAll((Map)prop);
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}
