package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    public int count;
    public String[] secretData;
    public Goods goods;
    public double profit;

    public static class Goods {
        @XmlElement(name = "names")
       public List<String> names = new ArrayList<>();
    }

    @Override
    public String toString() {

        return "goods: " + "\n"
                + goods.names.get(0) + "\n"
                + goods.names.get(1) + "\n"
                + "count = " + count + "\n"
                + "profit = " + profit + "\n"
                + Arrays.toString(secretData);
    }
}
