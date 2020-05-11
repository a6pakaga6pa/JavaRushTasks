package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName = "";
    private String partOfContent = "";
    private int minSize = 0;
    private int maxSize = Integer.MAX_VALUE;
    private List<Path> foundFiles = new ArrayList<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        if(file.getFileName().toString().contains(partOfName) &&
           new String(content).contains(partOfContent) &&
           content.length > minSize && content.length < maxSize) {
           foundFiles.add(file);
        }

        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String name) {
        this.partOfName = name;
    }


    public void setPartOfContent(String content) {
        this.partOfContent = content;
    }

    public void setMinSize(int i) {
        this.minSize = i;
    }

    public void setMaxSize(int i) {
        this.maxSize = i;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
