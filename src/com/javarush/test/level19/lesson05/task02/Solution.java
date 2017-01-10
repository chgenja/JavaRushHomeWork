package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        int worldCount = 0;

        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine())
        {
            String s = scanner.nextLine();
            String[] words = s.split("[., !?;:-]");
            for (String word : words)
                if (word.equals("world"))
                    worldCount++;
        }
        scanner.close();
        System.out.println(worldCount);
    }
}
