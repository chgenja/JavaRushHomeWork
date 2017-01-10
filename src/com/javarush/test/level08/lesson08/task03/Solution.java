package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов1","Иван1");
        map.put("Иванов2","Иван");
        map.put("Иванов3","Иван");
        map.put("Иванов4","Иван");
        map.put("Иванов5","Иван");
        map.put("Иванов6","Иван");
        map.put("Иванов7","Иван");
        map.put("Иванов8","Иван");
        map.put("Иванов9","Иван");
        map.put("Иванов10","Иван");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String,String> pair : map.entrySet())
        {
            if (pair.getValue().equals(name))
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String,String> pair : map.entrySet())
        {
            if (pair.getKey().equals(familiya))
                count++;
        }
        return count;

    }

    public static void main(String[] args) {
        HashMap<String,String> map = createMap();
        int name = 0;
        int surname = 0;
        name = getCountTheSameFirstName(map, "Иван");
        surname = getCountTheSameLastName(map, "Иванов7");
        System.out.println(name + " " + surname);
    }
}
