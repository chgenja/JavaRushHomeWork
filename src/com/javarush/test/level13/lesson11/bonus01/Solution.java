package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file = new FileReader(reader.readLine());
        Scanner scan = new Scanner(file);

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (scan.hasNext())
        {
            int temp = scan.nextInt();
            if (temp % 2 == 0)
            {
                numbers.add(temp);
            }
        }
        scan.close();
        Integer[] even = numbers.toArray(new Integer[numbers.size()]);
        if (even.length > 1)
        {
            for (int i = 0; i < even.length-1; i++)
            {
                for (int j = i+1; j < even.length; j++)
                {
                    if (even[j] < even[i])
                    {
                        int temp = even[j];
                        even[j] = even[i];
                        even[i] = temp;
                    }
                }
            }
        }
        for (int i = 0; i < even.length; i++)
        {
            System.out.println(even[i]);
        }






    }
}
