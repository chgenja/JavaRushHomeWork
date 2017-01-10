package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(filename);

        HashMap<Integer, Integer> counts = new HashMap<>();

        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            if (counts.containsKey(data))
            {
                counts.put(data,counts.get(data)+1);
            } else
                counts.put(data,1);
        }
        boolean first = false;
        int min = 0;
        for (Map.Entry<Integer, Integer> pair : counts.entrySet())
        {
            if (!first)
            {
                min = pair.getValue();
                first = true;
            }
            int current = pair.getValue();
            if (current < min)
                min = current;
        }
        for (Map.Entry<Integer, Integer> pair : counts.entrySet())
        {
            if (pair.getValue().equals(min))
                System.out.println(pair.getKey());
        }

    }

}
