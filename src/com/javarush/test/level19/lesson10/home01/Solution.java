package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String filename = args[0];
        TreeMap<String, Double> map = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
        while (reader.ready())
        {
            String s = reader.readLine();
            String[] string = s.split(" ");
            String surname = string[0];
            double surnameValue = Double.parseDouble(string[1]);
            if (map.containsKey(surname))
            {
                map.put(surname, map.get(surname) + surnameValue);
            } else
                map.put(surname, surnameValue);

        }

        for (Map.Entry<String, Double> pair: map.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());

        reader.close();
    }
}