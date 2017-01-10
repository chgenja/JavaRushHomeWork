package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();

        Scanner fileReader = new Scanner(new File(filename1));
        FileWriter fileWriter = new FileWriter(filename2);

        boolean firstFile = true;

        while (fileReader.hasNextLine())
        {
            String row = fileReader.nextLine();
            String newrow = row.replaceAll("\\.", "!");

            if (firstFile == true)
            {
                fileWriter.write(newrow);
                firstFile = false;
            } else
            {
                fileWriter.write(System.lineSeparator());
                fileWriter.write(newrow);
            }
        }


        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
