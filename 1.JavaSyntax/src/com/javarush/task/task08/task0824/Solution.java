package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).


*/

public class Solution {
    public static void main(String[] args) {
        Human father = new Human();
        father.age = 35;
        father.name = "Max";
        father.sex = true;
        Human mother = new Human();
        mother.age = 25;
        mother.name = "Juliya";
        mother.sex = false;
        Human grandFather1 = new Human();
        grandFather1.age = 55;
        grandFather1.name = "Igor";
        grandFather1.sex = true;
        Human grandFather2 = new Human();
        grandFather2.age = 58;
        grandFather2.name = "Alesha";
        grandFather2.sex = true;
        Human grandMother1 = new Human();
        grandMother1.age = 57;
        grandMother1.name = "Elena";
        grandMother1.sex = false;
        Human grandMother2 = new Human();
        grandMother2.age = 53;
        grandMother2.name = "Natasha";
        grandMother2.sex = false;
        Human child1 = new Human();
        child1.age = 5;
        child1.name = "Sasha";
        child1.sex = true;
        Human child2 = new Human();
        child2.age = 3;
        child2.name = "Olya";
        child2.sex = false;
        Human child3 = new Human();
        child3.age = 9;
        child3.name = "Oleg";
        child3.sex = true;

        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);

        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);

        grandFather1.children.add(father);
        grandMother1.children.add(father);

        grandMother2.children.add(mother);
        grandFather2.children.add(mother);

        System.out.println(grandFather1);
        System.out.println(grandMother1);
        System.out.println(grandFather2);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        //напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();
        //напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
