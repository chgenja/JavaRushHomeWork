package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
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
        reader.close();

        Scanner scanner = new Scanner(new File(filename1));
        FileWriter writer = new FileWriter(filename2);

        while (scanner.hasNextLine())
        {
            String row = scanner.nextLine();
            String newrow = row.replaceAll("\\p{Punct}", "");
            writer.write(newrow);
        }

        scanner.close();
        writer.close();
    }

}
