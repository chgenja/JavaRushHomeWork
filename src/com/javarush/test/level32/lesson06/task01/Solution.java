package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StringBuilder sb = generate();
        try {
            baos.write(sb.toString().getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return baos;
    }

    private static StringBuilder generate() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int symbol = random.nextInt(10);
            char c = (char) (symbol + 48);
            sb.append(c);
        }
        for (int i = 0; i < 2; i++) {
            int symbol = random.nextInt(26);
            char c = (char) (symbol + 65);
            sb.append(c);
        }
        for (int i = 0; i < 2; i++) {
            int symbol = random.nextInt(26);
            char c = (char) (symbol + 97);
            sb.append(c);
        }
        return sb;
    }
}
