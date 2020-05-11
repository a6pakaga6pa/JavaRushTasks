package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
Почитай на вики про паттерн "Null Object".
Используй Files, чтобы в конструкторе класса Solution правильно инициализировать поле fileData объектом ConcreteFileData.
Если возникли какие-то проблемы со чтением файла по пути pathToFile, то инициализируй поле объектом NullFileData.



*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        Path file = Paths.get(pathToFile);
        try {
            boolean dir = Files.isDirectory(file);
            boolean exist = Files.exists(file);
            boolean hidden = Files.isHidden(file);
            boolean exec = Files.isExecutable(file);
            boolean writable = Files.isWritable(file);
            fileData = new ConcreteFileData(hidden, exec, dir, writable);
        } catch (IOException e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
