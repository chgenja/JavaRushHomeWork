package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        Scanner scanner = new Scanner(new File(filename1));
        FileWriter writer = new FileWriter(filename2);
        boolean firstOne = true;
        while (scanner.hasNextLine())
        {
            String current = scanner.nextLine();
            String[] elements = current.split(" ");
            for (String element: elements)
            {
                if (isInteger(element))
                {
                    if (firstOne == true)
                    {
                        writer.write(element);
                        firstOne = false;
                    } else
                    {
                        writer.write(" "+element);
                    }
                }
            }
        }
        scanner.close();
        writer.close();
    }

    public static boolean isInteger(String s)
    {
        try
        {
            int data = Integer.parseInt(s);
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

}
