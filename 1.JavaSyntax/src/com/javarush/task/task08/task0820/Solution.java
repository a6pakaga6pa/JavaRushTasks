package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
Внутри класса Solution создать public static классы Cat, Dog без конструктора или с конструктором без параметров.
2. Реализовать метод createCats, который должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, который должен возвращать множество с 3 собаками.
4. Реализовать метод join, который должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, который должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, который должен выводить на экран всех животных, которые в нем есть.
Каждое животное с новой строки.


*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();
        for (int i = 0; i < 4; i++) {
            result.add(new Cat());
        }
        return result;

        //напишите тут ваш код


    }

    public static Set<Dog> createDogs() {
        Set<Dog> result = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            result.add(new Dog());
        }
        return result;
        //напишите тут ваш код

    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> all = new HashSet<>();
        all.addAll(cats);
        all.addAll(dogs);
        //напишите тут ваш код
        return all;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        for (Cat cat : cats) {
            pets.remove(cat);

        }



        //напишите тут ваш код
    }

    public static void printPets(Set<Object> pets) {
        for (Object animals : pets ) {
            System.out.println(animals);
        }
        //напишите тут ваш код
    }

    public static class Cat {

    }

    public static class Dog {

    }

    //напишите тут ваш код
}
