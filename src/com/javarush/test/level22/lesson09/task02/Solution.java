package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params)
    {
        if ((params == null) || params.isEmpty())
            return new StringBuilder("");
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> pair : params.entrySet())
        {
            if (pair.getValue() != null)
            {
                sb.append(pair.getKey() + " = '" + pair.getValue() + "' and ");
            }
        }
        sb.delete(sb.length()-5,sb.length());
        return sb;
    }



}
