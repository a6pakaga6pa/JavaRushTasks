package com.javarush.task.task17.task1703;

import java.util.ArrayList;
import java.util.List;

/* 
Синхронизированные заметки
1. Класс Note будет использоваться нитями. Поэтому сделай так, чтобы обращения к листу notes блокировали мьютекс notes, не this
2. Все System.out.println не должны быть заблокированы (синхронизированы), т.е. не должны находиться в блоке synchronized


*/

public class Solution {

    public static void main(String[] args) {
        Note note = new Note();
        note.addNote(0,"Note1");
        note.start();
        note.addNote(1,"Note2");
     //   note.start();

    }

    public static class Note extends Thread{

        public final List<String> notes = new ArrayList<String>();

        public void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            synchronized (notes){
                notes.add(index, note);
            }

            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public void removeNote(int index) {
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            String note;
            synchronized (notes){
                note = notes.remove(index);
            }

            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        }
    }

}
