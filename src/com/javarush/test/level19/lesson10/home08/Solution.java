package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"));
        while (fileReader.ready())
        {
            String fileRow = fileReader.readLine();
            String newRow = "";
            for (int i = fileRow.length(); i > 0; i--)
                newRow += fileRow.substring(i-1,i);
            System.out.println(newRow);
        }
        fileReader.close();
    }
}
