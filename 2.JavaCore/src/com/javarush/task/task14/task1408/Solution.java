package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        Hen hen1 = HenFactory.getHen(Country.RUSSIA);
        Hen hen2 = HenFactory.getHen("sd");
        System.out.println(hen.getDescription());
        System.out.println(hen.getCountOfEggsPerMonth());
        System.out.println(hen1.getDescription());
        System.out.println(hen1.getCountOfEggsPerMonth());
        System.out.println(hen2.getDescription());
        System.out.println(hen2.getCountOfEggsPerMonth());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            if (country.equalsIgnoreCase("Ukraine")) return new UkrainianHen();
            else if (country.equalsIgnoreCase("Belarus")) return new BelarusianHen();
            else if (country.equalsIgnoreCase("Russia")) return new RussianHen();
            else return new MoldovanHen();
        }
    }


}
