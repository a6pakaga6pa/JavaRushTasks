package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.


*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)  {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = null;
        String file2Name = null;
        try {
            file1Name = reader.readLine();
            file2Name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fileInputStream1 = null, fileInputStream2 = null;
        try {
            fileInputStream1 = new FileInputStream(file1Name);
            fileInputStream2 = new FileInputStream(file2Name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        reader = new BufferedReader(new InputStreamReader(fileInputStream1));
        String line;
        while(true) {
            try {
                if ((line = reader.readLine()) == null) {
                    break;
                } else allLines.add(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        reader = new BufferedReader(new InputStreamReader(fileInputStream2));
        while(true) {
            try {
                if (((line = reader.readLine()) == null)){
                    break;
                } else forRemoveLines.add(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



        Solution solution = new Solution();

        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

        allLines.forEach(System.out::println);


    }

    public void joinData() throws CorruptedDataException {
        System.out.println(allLines.containsAll(forRemoveLines));
        if (allLines.containsAll(forRemoveLines)){
            for (int i = 0; i < forRemoveLines.size(); i++) {
                if(Collections.frequency(allLines, forRemoveLines.get(i)) == 1){
                    allLines.remove(forRemoveLines.get(i));
                }
                }
            } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
