package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
     Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.


*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
    /*    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      *//*  String file1Path = reader.readLine();
        String file2Path = reader.readLine();*//*
        String file1Path = "C:\\Users\\sereb\\Documents\\file1.txt";
        String file2Path = "C:\\Users\\sereb\\Documents\\file2.txt";


        reader.close();

        BufferedReader fileReader1 = new BufferedReader(new FileReader(file1Path));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(file2Path));

        *//*while(fileReader1.ready() && fileReader2.ready()) {
            String line1File = fileReader1.readLine();
            String line2File = fileReader2.readLine();
            System.out.println("Строчка первого файла :" + line1File + ". Длина строки :" + line1File.length());
            System.out.println("Строчка второго файла :" + line2File + ". Длина строки :" + line2File.length());
            System.out.println("Строки равны? :" + line2File.equals(line1File));
            System.out.println(" ");
            if(line1File.length() == 0 && line2File.length() != 0) {
                lines.add(new LineItem(Type.ADDED, line2File));
            }
            if(line2File.length() == 0 && line1File.length() != 0) {
                lines.add(new LineItem(Type.REMOVED, line1File));
            }
            if(line1File.equals(line2File)) {
                lines.add(new LineItem(Type.SAME, line1File));
            }
        }*//*

        String line1File = fileReader1.readLine();
        String line2File = fileReader2.readLine();
        int counter = 0;

        while(fileReader1.ready() && fileReader2.ready()) {
            if (line1File.equals(line2File)) {
                lines.add(new LineItem(Type.SAME, line1File));
                line1File = fileReader1.readLine();
                line2File = fileReader2.readLine();
            } else if (counter == 0) {
                lines.add(new LineItem(Type.REMOVED, line1File));
                counter = 1;
                if (fileReader1.ready()) {
                    line1File = fileReader1.readLine();
                }
            } else {
                lines.add(new LineItem(Type.ADDED, line2File));
                counter = 0;
                if (fileReader2.ready()) {
                    line2File = fileReader2.readLine();
                }

            }
        }

        fileReader1.close();
        fileReader2.close();

        for(LineItem line: lines) {
            System.out.println(line.line + " " + line.type);
        }
    }
*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(br.readLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(br.readLine()));
        br.close();

        List<String> file1 = new ArrayList<String>();
        List<String> file2 = new ArrayList<String>();

        while (reader1.ready()) {
            file1.add(reader1.readLine());
        }
        reader1.close();

        while (reader2.ready()) {
            file2.add(reader2.readLine());
        }
        reader2.close();

        int i = 0;
        int j = 0;
        while (i < file1.size() && j < file2.size()) {
            if (file1.get(i).equals(file2.get(j))) {
                lines.add(new LineItem(Type.SAME, file1.get(i)));
                i++;
                j++;
            } else {
                if (j + 1 < file2.size() && file1.get(i).equals(file2.get(j + 1))) {
                    lines.add(new LineItem(Type.ADDED, file2.get(j)));
                    j++;
                } else {
                    lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                    i++;
                }
            }
        }
        if (i < file1.size()) lines.add(new LineItem(Type.REMOVED, file1.get(i)));
        if (j < file2.size()) lines.add(new LineItem(Type.ADDED, file2.get(j)));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
