package com.javarush.task.task35.task3512;

public class Generator<T> {

    public Class<T> type;

    public Generator(Class<T> type) {
        this.type = type;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return type.newInstance();
    }
}
