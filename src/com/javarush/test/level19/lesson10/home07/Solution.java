package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),"UTF-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]),"UTF-8"));
        String temp = "";
        while (reader.ready())
        {
            String[] s = reader.readLine().split(" ");

            for (int i = 0; i < s.length; i++)
            {
                if (s[i].length() > 6)
                {
                    temp = temp + s[i] + ",";
                }
            }
        }
        writer.write(temp.substring(0,temp.length()-1));
        reader.close();
        writer.close();

    }
}
