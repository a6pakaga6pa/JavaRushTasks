package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.
Класс FileConsoleWriter должен содержать пять методов write и один метод close:

public void write(char[] cbuf, int off, int len) throws IOException
public void write(int c) throws IOException
public void write(String str) throws IOException
public void write(String str, int off, int len) throws IOException
public void write(char[] cbuf) throws IOException
public void close() throws IOException
При записи данных в файл, должен дублировать эти данные на консоль.


*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileConsoleWriter {

    private FileWriter fileWriter;

    /*public FileConsoleWriter(FileWriter fileWriter){
        this.fileWriter = fileWriter;
    }*/

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }

  /*  public FileConsoleWriter(String fileName, Charset charset) throws IOException {
        this.fileWriter = new FileWriter(fileName, charset);
    }*/

   /* public FileConsoleWriter(String fileName, Charset charset, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, charset, append);
    }*/

  /*  public FileConsoleWriter(File file, Charset charset) throws IOException {
        this.fileWriter = new FileWriter(file, charset);
    }*/

  /*  public FileConsoleWriter(File file, Charset charset, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, charset, append);
    }*/

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for (int i = off; i < (off + len); i++) {
            System.out.print(cbuf[i]);
        }
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print((char)c);
    }

    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, (off + len)));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for (int i = 0; i < cbuf.length; i++) {
            System.out.print(cbuf[i]);
        }
    }

    public void close() throws IOException{
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {

        FileConsoleWriter fcw = new FileConsoleWriter("C:\\Users\\sereb\\Documents\\file.cfg");
        fcw.write(new char[]{'q', 'w', 'e', 'r', 't', 'y'});
        fcw.write("\r\n");
        fcw.write("String");
        fcw.write("\r\n");
        fcw.write(2_000_000_000);
        fcw.write("\r\n");
        fcw.write(new char[]{'q', 'w', 'e', 'r', 't', 'y', '1', '2', '3'}, 2, 4);
        fcw.write("\r\n");
        fcw.write("Qwerty123!", 2, 6);
        fcw.close();
    }

}
