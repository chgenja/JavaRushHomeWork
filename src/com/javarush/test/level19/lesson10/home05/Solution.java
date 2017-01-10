package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String filename1 = args[0];
        String filename2 = args[1];

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename1),"UTF-8"));
        FileWriter writer = new FileWriter(filename2);
        boolean first = true;
        while (reader.ready())
        {
            String[] s = reader.readLine().split(" ");
            for (int i = 0; i < s.length; i++)
            {
                if (s[i].matches(".*\\d+.*"))
                {
                    if (first)
                    {
                        writer.write(s[i]);
                        first = false;
                    } else
                    {
                        writer.write(" ");
                        writer.write(s[i]);
                    }
                }
            }
        }

        reader.close();
        writer.close();


    }
}
