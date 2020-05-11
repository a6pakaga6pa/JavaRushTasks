package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/*Кеш на основании SoftReference
        Реализуй логику методов get, put, remove класса SoftCache:

        Метод AnyObject get(Long key) должен возвращать объект типа AnyObject из мапы cacheMap по ключу key. Если такого ключа в cacheMap нет - верни null.

        Метод AnyObject put(Long key, AnyObject value) должен добавлять в мапу пару key : value. Метод должен вернуть null,
        если в cacheMap по такому ключу ранее не было значения. Иначе - верни предыдущее значение value по этому ключу.
        Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.

        Метод AnyObject remove(Long key) должен удалить из мапы cacheMap пару key : value по ключу key.
        Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения.
        Иначе - верни предыдущее значение value по этому ключу. Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.

        Не изменяй класс AnyObject.
        Метод main не принимает участия в тестировании.*/

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {

        SoftReference<AnyObject> softReference = cacheMap.get(key);
        if(cacheMap.entrySet().stream().noneMatch(x -> softReference.equals(x.getValue()))) return null;
        List<SoftReference<AnyObject>> list = cacheMap.entrySet().stream().filter(x -> softReference.equals(x.getValue())).map(Map.Entry::getValue).collect(Collectors.toList());
        return list.get(0).get();
        //напишите тут ваш код
    }

    public AnyObject put(Long key, AnyObject value) {
        AnyObject anyObject = get(key);
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        if(softReference != null) {
            softReference.clear();
            return anyObject;
        }
        return null;
        //напишите тут ваш код
    }

    public AnyObject remove(Long key) {
        AnyObject anyObject = get(key);
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        if(softReference !=null) {
            softReference.clear();
            return anyObject;
        }
        return null;

        //напишите тут ваш код
    }
}