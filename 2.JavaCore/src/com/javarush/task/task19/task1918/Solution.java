package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми


*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     //   String filePath = reader.readLine();
        reader.close();
        String filePath = "C:\\Users\\sereb\\Documents\\file.cfg";
      //  String tag = "span";

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        reader = new BufferedReader(new FileReader(filePath));
        String fileContent = "";
        while(reader.ready()) {
            String line  = reader.readLine();
            fileContent = fileContent + line;
        }

        reader.close();

        Pattern pattern1 = Pattern.compile("<" + args[0] + ".*?>");
        Pattern pattern2 = Pattern.compile("</" + args[0] + ">");
        Matcher matcher1 = pattern1.matcher(fileContent);
        Matcher matcher2 = pattern2.matcher(fileContent);



        int nested = 0;

        while(matcher1.find()) {
            list1.add(matcher1.start());
        }

        while(matcher2.find()) {
            list2.add(matcher2.end());
        }

        for (int i = 0; i < list1.size() ; i++) {
            if(i != list1.size()-1) {

            }
        }

        list1.forEach(System.out::println);
        System.out.println("");
        list2.forEach(System.out::println);


        /*for (int i = 0; i < list1.size(); i++) {
            System.out.println(fileContent.substring(list1.get(i), list2.get(i)));
        }*/
    }
}
