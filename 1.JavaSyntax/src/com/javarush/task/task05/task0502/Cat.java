package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем false

Должно выполняться условие:
если cat1.fight(cat2) возвращает true,
то cat2.fight(cat1) должен возвращать false


*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int numberOfWins = 0;
        int numberOfDraws = 0;

        if (this.age > anotherCat.age) {
            numberOfWins++;

        } else if(this.age == anotherCat.age){
            numberOfDraws++;
        }

        if (this.weight > anotherCat.weight) {
            numberOfWins++;

        } else if(this.weight == anotherCat.weight){
            numberOfDraws++;
        }

        if (this.strength > anotherCat.strength) {
            numberOfWins++;

        } else if(this.strength == anotherCat.strength){
            numberOfDraws++;
        }

        if(numberOfWins>=2 || (numberOfDraws==2 & numberOfWins ==1)) return true;
        else return false;
        }




        //напишите тут ваш код


    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age = 9;
        cat1.weight = 3;
        cat1.strength = 2;

        Cat cat2 = new Cat();
        cat2.age = 8;
        cat2.weight = 3;
        cat2.strength = 5;

       System.out.println(cat2.fight(cat1));
       System.out.println(cat1.fight(cat2));


    }
}
