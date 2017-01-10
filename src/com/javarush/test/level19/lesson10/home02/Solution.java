package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),"UTF-8"));
        HashMap<String, Double> map = new HashMap<>();

        while (reader.ready())
        {
            String[] words = reader.readLine().split(" ");
            String surname = words[0];
            Double count = Double.parseDouble(words[1]);
            if (map.containsKey(surname))
                map.put(surname,map.get(surname)+count);
            else
                map.put(surname,count);
        }
        boolean first = false;
        Double max = 0d;
        for (Map.Entry<String, Double> pair: map.entrySet())
        {
            if (!first)
            {
                max = pair.getValue();
                first = true;
            } else
            {
                if (pair.getValue() > max)
                {
                    max = pair.getValue();
                }
            }
        }
        for (Map.Entry<String, Double> pair: map.entrySet())
        {
            if (pair.getValue() == max)
                System.out.println(pair.getKey());
        }

        reader.close();
    }
}
