package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        FileWriter writer = new FileWriter(filename);

        while (true)
        {
            String s = reader.readLine();
            writer.write(s);
            if (s.equals("exit"))
                break;
            writer.write("\n");
        }
        writer.close();



    }
}
