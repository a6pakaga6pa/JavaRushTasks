package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu


*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
        byte[] password = new byte[8];
        for (int i = 0; i < 8; i++) {
            if (i == 0) {
                password[i] = (byte) randomSmallLetter();
            } else if (i == 1) {
                password[i] = (byte) randomNumber();
            } else if (i == 2) {
                password[i] = (byte) randomBigLetter();
            } else {
                int a = (int) (Math.random() * 3);
                if (a == 0) password[i] = (byte) randomNumber();
                if (a == 1) password[i] = (byte) randomSmallLetter();
                if (a == 2) password[i] = (byte) randomBigLetter();
            }
        }
        try {
            byteArrayOutputStream.write(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }

    public static int randomNumber(){
        Random random = new Random();
        return 48 + random.nextInt(57 - 48 + 1);
    }

    public static int randomSmallLetter(){
        Random random = new Random();
        return 97 + random.nextInt(122 - 97 + 1);
    }

    public static int randomBigLetter(){
        Random random = new Random();
        return 65 + random.nextInt(90 - 65 + 1);
    }
}