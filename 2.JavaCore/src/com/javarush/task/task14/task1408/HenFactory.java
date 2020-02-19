package com.javarush.task.task14.task1408;

public class HenFactory implements Country{
    public Hen getHen(String country) {
        if (country.equalsIgnoreCase("Ukraine")) return new UkrainianHen();
        else if (country.equalsIgnoreCase("Belarus")) return new BelarusianHen();
        else if (country.equalsIgnoreCase("Russia")) return new RussianHen();
        else return new UkrainianHen();
    }

}
