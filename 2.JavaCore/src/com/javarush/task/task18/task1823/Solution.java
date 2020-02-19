package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.

*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String filePath = reader.readLine();
            if(filePath.equals("exit")){
                resultMap.forEach((k, v) -> System.out.println(k + " " + v));
                break;
            } else {
                ReadThread thread = new ReadThread(filePath);
                thread.start();
            }
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        volatile String fileName;
        public ReadThread(String fileName) {
            super(fileName);
            this.fileName = fileName;
        }

        @Override
        public void run() {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            List<Integer> list = new LinkedList<>();

            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                while(inputStream.available() > 0) {
                    int symbol = inputStream.read();
                    list.add(symbol);
                }
                for (int i = 0; i < list.size(); i++) {
                    int freq = Collections.frequency(list, list.get(i));
                    map.put(freq, list.get(i));
                }
                resultMap.put(fileName, map.lastEntry().getValue());

                inputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
