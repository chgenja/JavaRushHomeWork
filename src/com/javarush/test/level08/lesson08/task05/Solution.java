package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Иван");
        map.put("Иванов2", "Иван");
        map.put("Иванов3", "Иван");
        map.put("Иванов4", "Иван");
        map.put("Иванов5", "Иван");
        map.put("Сергеев", "Сергей");
        map.put("Сергеев2", "Сергей2");
        map.put("Сергеев3", "Сергей3");
        map.put("Сергеев4", "Сергей4");
        map.put("Сергеев5", "Сергей5");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, Integer> unique = new HashMap<String, Integer>();

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            unique.put(pair.getValue(),0);
        }



        Iterator<Map.Entry<String, Integer>> iterator_2 = unique.entrySet().iterator();
        while (iterator_2.hasNext()) {
            Map.Entry<String, Integer> pair = iterator_2.next();
            Iterator<Map.Entry<String, String>> iterator_copy = map.entrySet().iterator();
            while (iterator_copy.hasNext()) {
                Map.Entry<String, String> pair_2 = iterator_copy.next();
                if (pair.getKey() == pair_2.getValue())
                    pair.setValue(pair.getValue()+1);
            }
        }

        Iterator<Map.Entry<String, Integer>> iterator_2_copy = unique.entrySet().iterator();

        while (iterator_2_copy.hasNext()) {
            Map.Entry<String, Integer> pair_2 = iterator_2_copy.next();
            if (pair_2.getValue() >= 2)
                removeItemFromMapByValue(map, pair_2.getKey());
        }

    }
    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getValue() == value)
                iterator.remove();
        }

    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for (Map.Entry<String, String> pair: map.entrySet())
            System.out.println(pair.getValue());
    }
}
