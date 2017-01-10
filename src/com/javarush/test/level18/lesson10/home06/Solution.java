package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        try
        {
            String filename = args[0];
            FileReader reader = new FileReader(filename);
            HashMap<Integer, Integer> symbolCounts = new HashMap<>();
            while (reader.ready())
            {
                int data = reader.read();
                if (symbolCounts.containsKey(data))
                {
                    symbolCounts.put(data,symbolCounts.get(data)+1);
                } else
                    symbolCounts.put(data,1);
            }
            reader.close();

            int[] symbols = new int[symbolCounts.size()];
            int i = 0;
            for (Map.Entry<Integer,Integer> pair : symbolCounts.entrySet())
            {
                symbols[i] = pair.getKey();
                i++;
            }

            for (int k = 0; k < symbols.length - 1; k++)
            {
                for (int j = k+1; j < symbols.length; j++)
                {
                    if (symbols[j] < symbols[k])
                    {
                        int temp = symbols[k];
                        symbols[k] = symbols[j];
                        symbols[j] = temp;
                    }
                }
            }

            for (int j = 0; j < symbols.length; j++)
            {
                System.out.println((char) symbols[j] + " " + symbolCounts.get(symbols[j]));
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
