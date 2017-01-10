package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;

public class Solution {
    public static void main(String[] args) {
        try
        {
            String filename = args[0];
            int count = 0;

            FileReader reader = new FileReader(filename);
            while (reader.ready()) {
                int symbol = reader.read();
                if (symbol >= 65 && symbol <= 90)
                    count++;
                if (symbol >=97 && symbol <= 122)
                    count++;
            }
            reader.close();
            System.out.println(count);


        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
