package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тегом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова:
toXmlWithComment(firstSecondObject, "second", "it's a comment")

Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second><![CDATA[need CDATA because of < and >]]></second>
<!--it's a comment-->
<second/>
</first>


*/
public class Solution {

    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);
        String text = writer.toString();
        List<String> list = new ArrayList<>();

        if(text.contains(tagName)) {
            String[] allText = text.split("\n");

            for (int i = 0; i < allText.length; i++) {
                String allTextTrimmed = allText[i].trim();
                if(allTextTrimmed.startsWith("<" + tagName + ">")){
                    list.add("<!--" + comment + "-->");
                    list.add(allText[i]);
                } else list.add(allText[i]);
            }
        } else {
            String[] allText = text.split("\n");
            for (int i = 0; i < allText.length; i++) {
                    list.add(allText[i]);
            }

        }

        String xml = "";
        for (int i = 0; i < list.size(); i++) {
            if(i != list.size() - 1){
                xml += list.get(i) + "\n";
            } else xml += list.get(i);
        }

        return xml;
    }

    public static void main(String[] args) throws JAXBException {
        System.out.println(Solution.toXmlWithComment(new First(), "qweqweqwe", "it's a comment"));
    }


    @XmlRootElement(name = "first")
    public static class First {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
        @XmlElement(name = "second")
        public String item3 = "";
        @XmlElement(name = "third")
        public String item4 = "second";
        @XmlElement(name = "second")
        public String item5 = "![CDATA[need CDATA because of \"";
    }
}
