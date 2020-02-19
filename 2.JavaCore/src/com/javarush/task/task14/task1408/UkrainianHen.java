package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen implements Country{

    @Override
    public int getCountOfEggsPerMonth() {
        return 100;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
