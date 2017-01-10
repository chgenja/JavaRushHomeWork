package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();
            File file = new File(filename);
            int count = 0;
            char[] symbols = new char[(int) file.length()];
            FileReader fileReader = new FileReader(filename);
            fileReader.read(symbols);
            for (char c : symbols)
            {
                if (c == ',')
                    count++;
            }
            System.out.println(count);
            reader.close();
            fileReader.close();


        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
