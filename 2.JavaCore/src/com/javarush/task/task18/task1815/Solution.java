package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
Измени класс TableInterfaceWrapper так, чтобы он стал Wrapper-ом для TableInterface.
Метод setModel должен вывести в консоль количество элементов в новом листе перед обновлением модели.
Метод getHeaderText должен возвращать текст в верхнем регистре - используйте метод toUpperCase().


*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        private TableInterface table;

        public TableInterfaceWrapper(TableInterface table){
            this.table = table;

        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            table.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return table.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            table.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {


    }
}