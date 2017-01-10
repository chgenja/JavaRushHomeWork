package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;

public class Solution {
    public static void main(String[] args) {
        try
        {
            String filename = args[0];
            int symbols = 0;
            int spaces = 0;
            FileReader reader = new FileReader(filename);
            while (reader.ready())
            {
                int symbol = reader.read();
                if (symbol == 32)
                    spaces++;
                symbols++;
            }
            reader.close();
            System.out.printf("%.2f", (float) spaces / symbols * 100);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
