package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
1. На вход метода main() подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и, если понадобится, FileUtils.isExist()).
3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1. После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
Для создания файлов используй конструктор File(String pathname).


*/
public class Solution {
    public static void main(String[] args) throws IOException {

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        FileWriter writer = new FileWriter(allFilesContent);
        ArrayList<File> list = new ArrayList<>();


        // saving all the files' names
        for(File file: path.listFiles()){
            if(file.isFile() && !file.getName().equals("allFilesContent.txt")){
                FileInputStream fileInputStream = new FileInputStream(file);
                if(fileInputStream.available() <= 50) {
                    list.add(file);
                    fileInputStream.close();
                }
            } else if(file.isDirectory()) {
                Solution solution = new Solution();
                list.addAll(solution.takeFilesFromDirectory(file));
            }
        }

        //sorting
        list.sort(Comparator.comparing(File::getName));
        list.forEach(System.out::println);

        //writing due to the order
      //  for(File fileName: list){
        for (int i = 0; i < list.size(); i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(list.get(i))));
            List<String> stringList = new ArrayList<>();
            while(reader.ready()){
                String line = reader.readLine();
                stringList.add(line);
            }
            for(String line: stringList){
                writer.write(line + "\n");
            }
            /*if(i != (list.size() - 1)){
            writer.write("\n");
            }*/
             reader.close();
        }
        writer.close();
    }

    public List<File> takeFilesFromDirectory(File file) throws IOException {
        Queue<File> queue = new LinkedList<>();
        List<File> list = new ArrayList<>();
        queue.add(file);
        while(!queue.isEmpty()){
            File currentFolder = queue.poll();
            for(File files: currentFolder.listFiles()) {
                if(files.isDirectory()) queue.add(files);
                else list.add(files);
            }
        }
        return list;
    }
}
