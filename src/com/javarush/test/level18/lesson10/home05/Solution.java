package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename1 = reader.readLine();
            String filename2 = reader.readLine();
            reader.close();

            BufferedReader readerFile1 = new BufferedReader(new FileReader(filename1));
            FileWriter writer = new FileWriter(filename2);

            String s;
            List<String> lines = new ArrayList<>();
            while ((s = readerFile1.readLine()) != null)
            {
                lines.add(s);
            }
            readerFile1.close();

            for (int j = 0; j < lines.size(); j++)
            {
                String[] stringNumbers = lines.get(j).split(" ");



                for (int i = 0; i < stringNumbers.length; i++)
                {
                    double f = Double.parseDouble(stringNumbers[i]);
                    int temp = (int) Math.round(f);
                    String x = String.valueOf(temp);
                    writer.write(x);
                    writer.write(" ");
                }
            }
            writer.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
