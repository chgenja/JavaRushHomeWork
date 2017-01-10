package com.javarush.test.level08.lesson08.task04;

import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("BZzzz", new Date("JANUARY 1 1980"));
        map.put("BZzzz2", new Date("FEBRUARY 1 1980"));
        map.put("BZzzz3", new Date("MARCH 1 1980"));
        map.put("BZzzz4", new Date("APRIL 1 1980"));
        map.put("BZzzz5", new Date("MAY 1 1980"));
        map.put("BZzzz6", new Date("OCTOBER 1 1980"));
        map.put("BZzzz7", new Date("JULY 1 1980"));
        map.put("BZzzz8", new Date("AUGUST 1 1980"));
        map.put("BZzzz9", new Date("SEPTEMBER 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            Calendar cal = Calendar.getInstance();
            cal.setTime(value);
            int month = cal.get(Calendar.MONTH);
            if ((month == 5) || (month == 6) || (month == 7))
                iterator.remove();
        }
    }

    public static void main(String[] args) {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> pair : map.entrySet()) {
            System.out.println(pair.getValue());
        }
    }
}
