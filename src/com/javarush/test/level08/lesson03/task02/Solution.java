package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз - ягода, банан - трава, вишня - ягода, груша - фрукт, дыня - овощ, ежевика - куст, жень-шень - корень, земляника - ягода, ирис - цветок, картофель - клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель - клубень
*/

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        Map<String, String> pairs = new HashMap<String, String>();
        pairs.put("арбуз", "ягода");
        pairs.put("банан", "трава");
        pairs.put("вишня", "ягода");
        pairs.put("груша", "фрукт");
        pairs.put("дыня", "овощ");
        pairs.put("ежевика", "куст");
        pairs.put("жень-шень", "корень");
        pairs.put("земляника", "ягода");
        pairs.put("ирис", "цветок");
        pairs.put("картофель", "клубень");

        for (Map.Entry<String, String> pair : pairs.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }

    }
}
